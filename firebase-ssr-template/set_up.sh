#!/bin/bash

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Helper functions
print_header() {
    echo -e "\n${BLUE}========================================${NC}"
    echo -e "${BLUE}$1${NC}"
    echo -e "${BLUE}========================================${NC}\n"
}

print_success() {
    echo -e "${GREEN}✓ $1${NC}"
}

print_error() {
    echo -e "${RED}✗ $1${NC}"
}

print_warning() {
    echo -e "${YELLOW}⚠ $1${NC}"
}

print_info() {
    echo -e "${BLUE}ℹ $1${NC}"
}

# Check if command exists
command_exists() {
    command -v "$1" >/dev/null 2>&1
}

# Validate required tools
check_dependencies() {
    print_header "Checking Dependencies"

    local missing_deps=()

    if ! command_exists node; then
        missing_deps+=("node")
    fi

    if ! command_exists npm; then
        missing_deps+=("npm")
    fi

    if ! command_exists firebase; then
        print_warning "Firebase CLI not found"
        echo -e "Install it with: ${BLUE}npm install -g firebase-tools${NC}"
        missing_deps+=("firebase-tools")
    fi

    if [ ${#missing_deps[@]} -ne 0 ]; then
        print_error "Missing dependencies: ${missing_deps[*]}"
        echo "Please install the missing dependencies and try again."
        exit 1
    fi

    print_success "All dependencies found"
}

# Prompt with default value
prompt_with_default() {
    local prompt="$1"
    local default="$2"
    local result

    if [ -n "$default" ]; then
        read -p "$prompt [$default]: " result
        echo "${result:-$default}"
    else
        read -p "$prompt: " result
        echo "$result"
    fi
}

# Generate random string for project ID uniqueness
generate_random_string() {
    local length="${1:-6}"
    cat /dev/urandom | LC_ALL=C tr -dc 'a-z0-9' | fold -w "$length" | head -n 1
}

# Create Firebase project
create_firebase_project() {
    local project_id="$1"
    local display_name="$2"

    # Sanitize display name (remove special chars, max 30 chars)
    local sanitized_display=$(echo "$display_name" | tr -cd '[:alnum:] -' | sed 's/  */ /g')
    if [ ${#sanitized_display} -gt 30 ]; then
        sanitized_display="${sanitized_display:0:30}"
    fi

    print_info "Creating Firebase project: $project_id..."

    if firebase projects:create "$project_id" --display-name "$sanitized_display" 2>&1; then
        print_success "Firebase project created: $project_id"
        return 0
    else
        print_error "Failed to create Firebase project: $project_id"
        return 1
    fi
}

# Create Firebase web app and return the app ID
create_firebase_web_app() {
    local project_id="$1"
    local app_name="$2"

    print_info "Creating web app in project $project_id..."

    firebase use "$project_id" >/dev/null 2>&1
    local output=$(firebase apps:create web "$app_name" 2>&1)

    if echo "$output" | grep -q "Created"; then
        print_success "Web app created: $app_name"
        # Extract app ID from output (format: "App ID: 1:123456789:web:abc123def456")
        local app_id=$(echo "$output" | grep "App ID:" | sed 's/.*App ID: //' | tr -d '\n')
        echo "$app_id"
        return 0
    else
        print_warning "Web app may already exist or creation failed"
        return 1
    fi
}

# Fetch Firebase config for a web app
fetch_firebase_config() {
    local project_id="$1"

    print_info "Fetching Firebase configuration for $project_id..."

    firebase use "$project_id" >/dev/null 2>&1
    local config=$(firebase apps:sdkconfig web 2>/dev/null)

    if [ $? -eq 0 ] && [ -n "$config" ]; then
        echo "$config"
        return 0
    else
        return 1
    fi
}

# Main setup function
main() {
    clear
    echo -e "${GREEN}"
    cat << "EOF"
╔═══════════════════════════════════════╗
║   Firebase SSR Template Setup        ║
╚═══════════════════════════════════════╝
EOF
    echo -e "${NC}"

    # Check for command line arguments
    if [ $# -gt 0 ]; then
        PROJECT_ID_ARG="$1"
        print_info "Using provided project ID: $PROJECT_ID_ARG"
    fi

    check_dependencies

    # Step 1: Project Configuration
    print_header "Step 1: Project Configuration"

    # Generate random strings for unique project IDs (done once)
    RANDOM_DEV=$(generate_random_string 4)
    RANDOM_PROD=$(generate_random_string 4)

    # Firebase project ID max length is 30 characters
    # Format: "name-dev-ab12" = name + "-dev-" (5) + random (4) = 9 chars reserved
    # So base name can be max 21 chars after sanitization
    MAX_BASE_LENGTH=21

    # Loop until we get a valid project name
    VALID_NAME=false
    while [ "$VALID_NAME" = false ]; do
        if [ -n "$PROJECT_ID_ARG" ] && [ "$VALID_NAME" = false ]; then
            # First iteration with provided argument
            BASE_PROJECT_NAME="$PROJECT_ID_ARG"
            PROJECT_NAME="$BASE_PROJECT_NAME"
            print_info "Using provided project name: $BASE_PROJECT_NAME"
            PROJECT_ID_ARG=""  # Clear so we don't use it again
        else
            # Prompt for project name
            PROJECT_NAME=$(prompt_with_default "Enter your project name" "firebase-ssr-template")
            BASE_PROJECT_NAME="$PROJECT_NAME"
        fi

        # Sanitize project name (lowercase, replace spaces/underscores with hyphens, remove invalid chars)
        SANITIZED_BASE=$(echo "$BASE_PROJECT_NAME" | tr '[:upper:]' '[:lower:]' | tr '_' '-' | tr -cd '[:alnum:]-')

        # Check length
        if [ ${#SANITIZED_BASE} -gt $MAX_BASE_LENGTH ]; then
            print_error "Project name '$BASE_PROJECT_NAME' is too long"
            echo -e "${YELLOW}After sanitization: '$SANITIZED_BASE' (${#SANITIZED_BASE} chars)${NC}"
            echo -e "${YELLOW}Maximum allowed: $MAX_BASE_LENGTH characters${NC}"
            echo -e "${YELLOW}Final project IDs will be: <name>-dev-${RANDOM_DEV} and <name>-prod-${RANDOM_PROD}${NC}"
            echo ""
        else
            VALID_NAME=true
        fi
    done

    print_info "Project name: $PROJECT_NAME"
    print_info "Sanitized base: $SANITIZED_BASE"

    # Create project IDs with random suffixes to prevent collisions
    DEV_PROJECT_ID="${SANITIZED_BASE}-dev-${RANDOM_DEV}"
    PROD_PROJECT_ID="${SANITIZED_BASE}-prod-${RANDOM_PROD}"

    print_info "Generated DEV project ID: $DEV_PROJECT_ID (${#DEV_PROJECT_ID} chars)"
    print_info "Generated PROD project ID: $PROD_PROJECT_ID (${#PROD_PROJECT_ID} chars)"

    # Update .firebaserc immediately to avoid Firebase CLI reading invalid placeholder values
    print_info "Updating .firebaserc with generated project IDs..."
    cat > .firebaserc << EOF
{
  "projects": {
    "default": "$DEV_PROJECT_ID",
    "dev": "$DEV_PROJECT_ID",
    "prod": "$PROD_PROJECT_ID"
  }
}
EOF

    print_success "Project configuration set"

    # Step 2: App Metadata
    print_header "Step 2: App Metadata"

    APP_TITLE=$(prompt_with_default "App title" "$PROJECT_NAME")
    APP_DESCRIPTION=$(prompt_with_default "App description" "A Next.js SSR app powered by Firebase App Hosting")

    print_success "App metadata set"

    # Step 3: UI Library Selection
    print_header "Step 3: UI Library Selection"

    echo "Select a UI library to install:"
    echo "1) Shadcn UI (Recommended)"
    echo "2) Material UI"
    echo "3) Chakra UI"
    echo "4) Skip (install later)"
    echo ""

    read -p "Enter your choice [1-4]: " UI_CHOICE

    case $UI_CHOICE in
        1) UI_LIBRARY="shadcn" ;;
        2) UI_LIBRARY="material-ui" ;;
        3) UI_LIBRARY="chakra-ui" ;;
        4) UI_LIBRARY="skip" ;;
        *)
            print_warning "Invalid choice. Skipping UI library installation."
            UI_LIBRARY="skip"
            ;;
    esac

    print_success "UI library selection: $UI_LIBRARY"

    # Step 4: Firebase Login and Project Creation
    print_header "Step 4: Firebase Authentication and Project Creation"

    read -p "Do you want to login to Firebase now? (y/n): " LOGIN_CHOICE

    if [[ "$LOGIN_CHOICE" =~ ^[Yy]$ ]]; then
        firebase login
        if [ $? -eq 0 ]; then
            print_success "Firebase login successful"
        else
            print_error "Firebase login failed"
            exit 1
        fi

        # Create Firebase projects
        echo ""
        print_info "Creating Firebase projects..."
        echo ""

        read -p "Do you want to create Firebase projects automatically? (y/n): " CREATE_PROJECTS

        if [[ "$CREATE_PROJECTS" =~ ^[Yy]$ ]]; then
            # Create DEV project
            if create_firebase_project "$DEV_PROJECT_ID" "$PROJECT_NAME (Dev)"; then
                DEV_PROJECT_CREATED=true
            else
                print_warning "Failed to create DEV project. You may need to create it manually."
                DEV_PROJECT_CREATED=false
            fi

            echo ""

            # Create PROD project
            if create_firebase_project "$PROD_PROJECT_ID" "$PROJECT_NAME (Prod)"; then
                PROD_PROJECT_CREATED=true
            else
                print_warning "Failed to create PROD project. You may need to create it manually."
                PROD_PROJECT_CREATED=false
            fi

            echo ""
            print_info "Waiting for projects to be ready..."
            sleep 3

            # Create web apps for the projects
            if [ "$DEV_PROJECT_CREATED" = true ]; then
                create_firebase_web_app "$DEV_PROJECT_ID" "$PROJECT_NAME-dev-web"
            fi

            if [ "$PROD_PROJECT_CREATED" = true ]; then
                create_firebase_web_app "$PROD_PROJECT_ID" "$PROJECT_NAME-prod-web"
            fi

            print_success "Firebase projects and web apps created"
            PROJECTS_CREATED=true
        else
            print_warning "Skipping Firebase project creation."
            echo "You'll need to create the projects manually:"
            echo "  DEV:  firebase projects:create $DEV_PROJECT_ID --display-name \"$PROJECT_NAME (Dev)\""
            echo "  PROD: firebase projects:create $PROD_PROJECT_ID --display-name \"$PROJECT_NAME (Prod)\""
            PROJECTS_CREATED=false
        fi
    else
        print_warning "Skipping Firebase login and project creation."
        echo "You'll need to:"
        echo "  1. Login: firebase login"
        echo "  2. Create DEV project: firebase projects:create $DEV_PROJECT_ID --display-name \"$PROJECT_NAME (Dev)\""
        echo "  3. Create PROD project: firebase projects:create $PROD_PROJECT_ID --display-name \"$PROJECT_NAME (Prod)\""
        PROJECTS_CREATED=false
    fi

    # Step 5: Firebase Configuration
    print_header "Step 5: Firebase Configuration"

    # Development Environment
    print_info "Development Environment Configuration"

    if [ "$PROJECTS_CREATED" = true ] && [ "$DEV_PROJECT_CREATED" = true ]; then
        print_info "Attempting to fetch DEV configuration automatically..."
        DEV_CONFIG=$(fetch_firebase_config "$DEV_PROJECT_ID")

        if [ $? -eq 0 ]; then
            DEV_API_KEY=$(echo "$DEV_CONFIG" | grep "apiKey" | sed 's/.*apiKey: "\(.*\)".*/\1/')
            DEV_AUTH_DOMAIN=$(echo "$DEV_CONFIG" | grep "authDomain" | sed 's/.*authDomain: "\(.*\)".*/\1/')
            DEV_STORAGE_BUCKET=$(echo "$DEV_CONFIG" | grep "storageBucket" | sed 's/.*storageBucket: "\(.*\)".*/\1/')
            DEV_MESSAGING_SENDER_ID=$(echo "$DEV_CONFIG" | grep "messagingSenderId" | sed 's/.*messagingSenderId: "\(.*\)".*/\1/')
            DEV_APP_ID=$(echo "$DEV_CONFIG" | grep "appId" | sed 's/.*appId: "\(.*\)".*/\1/')
            DEV_MEASUREMENT_ID=$(echo "$DEV_CONFIG" | grep "measurementId" | sed 's/.*measurementId: "\(.*\)".*/\1/')

            print_success "DEV configuration fetched automatically"
            echo -e "  API Key: ${GREEN}${DEV_API_KEY:0:20}...${NC}"
            echo -e "  Auth Domain: ${GREEN}${DEV_AUTH_DOMAIN}${NC}"
            echo -e "  Storage Bucket: ${GREEN}${DEV_STORAGE_BUCKET}${NC}"
        else
            print_warning "Could not fetch DEV config automatically. Please enter manually."
            DEV_API_KEY=$(prompt_with_default "DEV API Key" "")
            DEV_AUTH_DOMAIN=$(prompt_with_default "DEV Auth Domain" "${DEV_PROJECT_ID}.firebaseapp.com")
            DEV_STORAGE_BUCKET=$(prompt_with_default "DEV Storage Bucket" "${DEV_PROJECT_ID}.firebasestorage.app")
            DEV_MESSAGING_SENDER_ID=$(prompt_with_default "DEV Messaging Sender ID" "")
            DEV_APP_ID=$(prompt_with_default "DEV App ID" "")
            DEV_MEASUREMENT_ID=$(prompt_with_default "DEV Measurement ID (optional)" "")
        fi
    else
        echo -e "${YELLOW}Get DEV configuration from Firebase Console:${NC}"
        echo -e "${BLUE}https://console.firebase.google.com/project/$DEV_PROJECT_ID${NC}\n"
        DEV_API_KEY=$(prompt_with_default "DEV API Key" "")
        DEV_AUTH_DOMAIN=$(prompt_with_default "DEV Auth Domain" "${DEV_PROJECT_ID}.firebaseapp.com")
        DEV_STORAGE_BUCKET=$(prompt_with_default "DEV Storage Bucket" "${DEV_PROJECT_ID}.firebasestorage.app")
        DEV_MESSAGING_SENDER_ID=$(prompt_with_default "DEV Messaging Sender ID" "")
        DEV_APP_ID=$(prompt_with_default "DEV App ID" "")
        DEV_MEASUREMENT_ID=$(prompt_with_default "DEV Measurement ID (optional)" "")
    fi

    DEV_VAPID_KEY=$(prompt_with_default "DEV VAPID Key (optional, for push notifications)" "")

    echo ""
    print_info "For SSR, you'll also need Firebase Admin SDK credentials:"
    print_warning "Go to Project Settings > Service Accounts > Generate new private key"
    echo ""

    DEV_CLIENT_EMAIL=$(prompt_with_default "DEV Service Account Email" "")
    echo "DEV Private Key (paste the entire private key including headers):"
    read -r DEV_PRIVATE_KEY

    echo ""
    read -p "Press Enter to continue with PROD environment configuration..."

    # Production Environment
    print_info "Production Environment Configuration"

    if [ "$PROJECTS_CREATED" = true ] && [ "$PROD_PROJECT_CREATED" = true ]; then
        print_info "Attempting to fetch PROD configuration automatically..."
        PROD_CONFIG=$(fetch_firebase_config "$PROD_PROJECT_ID")

        if [ $? -eq 0 ]; then
            PROD_API_KEY=$(echo "$PROD_CONFIG" | grep "apiKey" | sed 's/.*apiKey: "\(.*\)".*/\1/')
            PROD_AUTH_DOMAIN=$(echo "$PROD_CONFIG" | grep "authDomain" | sed 's/.*authDomain: "\(.*\)".*/\1/')
            PROD_STORAGE_BUCKET=$(echo "$PROD_CONFIG" | grep "storageBucket" | sed 's/.*storageBucket: "\(.*\)".*/\1/')
            PROD_MESSAGING_SENDER_ID=$(echo "$PROD_CONFIG" | grep "messagingSenderId" | sed 's/.*messagingSenderId: "\(.*\)".*/\1/')
            PROD_APP_ID=$(echo "$PROD_CONFIG" | grep "appId" | sed 's/.*appId: "\(.*\)".*/\1/')
            PROD_MEASUREMENT_ID=$(echo "$PROD_CONFIG" | grep "measurementId" | sed 's/.*measurementId: "\(.*\)".*/\1/')

            print_success "PROD configuration fetched automatically"
            echo -e "  API Key: ${GREEN}${PROD_API_KEY:0:20}...${NC}"
            echo -e "  Auth Domain: ${GREEN}${PROD_AUTH_DOMAIN}${NC}"
            echo -e "  Storage Bucket: ${GREEN}${PROD_STORAGE_BUCKET}${NC}"
        else
            print_warning "Could not fetch PROD config automatically. Please enter manually."
            PROD_API_KEY=$(prompt_with_default "PROD API Key" "")
            PROD_AUTH_DOMAIN=$(prompt_with_default "PROD Auth Domain" "${PROD_PROJECT_ID}.firebaseapp.com")
            PROD_STORAGE_BUCKET=$(prompt_with_default "PROD Storage Bucket" "${PROD_PROJECT_ID}.firebasestorage.app")
            PROD_MESSAGING_SENDER_ID=$(prompt_with_default "PROD Messaging Sender ID" "")
            PROD_APP_ID=$(prompt_with_default "PROD App ID" "")
            PROD_MEASUREMENT_ID=$(prompt_with_default "PROD Measurement ID (optional)" "")
        fi
    else
        echo -e "${YELLOW}Get PROD configuration from Firebase Console:${NC}"
        echo -e "${BLUE}https://console.firebase.google.com/project/$PROD_PROJECT_ID${NC}\n"
        PROD_API_KEY=$(prompt_with_default "PROD API Key" "")
        PROD_AUTH_DOMAIN=$(prompt_with_default "PROD Auth Domain" "${PROD_PROJECT_ID}.firebaseapp.com")
        PROD_STORAGE_BUCKET=$(prompt_with_default "PROD Storage Bucket" "${PROD_PROJECT_ID}.firebasestorage.app")
        PROD_MESSAGING_SENDER_ID=$(prompt_with_default "PROD Messaging Sender ID" "")
        PROD_APP_ID=$(prompt_with_default "PROD App ID" "")
        PROD_MEASUREMENT_ID=$(prompt_with_default "PROD Measurement ID (optional)" "")
    fi

    PROD_VAPID_KEY=$(prompt_with_default "PROD VAPID Key (optional, for push notifications)" "")

    PROD_CLIENT_EMAIL=$(prompt_with_default "PROD Service Account Email" "")
    echo "PROD Private Key (paste the entire private key including headers):"
    read -r PROD_PRIVATE_KEY

    print_success "Firebase configuration collected"

    # Step 6: Apply Configuration
    print_header "Step 6: Applying Configuration"

    # Update package.json
    print_info "Updating package.json..."

    if command_exists jq; then
        # Use jq if available for safer JSON manipulation
        jq --arg name "$PROJECT_NAME" \
           '.name = $name' \
           package.json > package.json.tmp && mv package.json.tmp package.json
        print_success "package.json updated"
    else
        # Fallback to sed
        sed -i.bak "s/\"name\": \".*\"/\"name\": \"$PROJECT_NAME\"/" package.json
        rm package.json.bak
        print_success "package.json updated (using sed)"
    fi

    # Create .env.development
    print_info "Creating .env.development..."
    cat > .env.development << EOF
NODE_ENV=development

# Firebase Development Configuration
NEXT_PUBLIC_FIREBASE_API_KEY="$DEV_API_KEY"
NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN="$DEV_AUTH_DOMAIN"
NEXT_PUBLIC_FIREBASE_PROJECT_ID="$DEV_PROJECT_ID"
NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET="$DEV_STORAGE_BUCKET"
NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID="$DEV_MESSAGING_SENDER_ID"
NEXT_PUBLIC_FIREBASE_APP_ID="$DEV_APP_ID"
NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID="$DEV_MEASUREMENT_ID"

# Firebase Admin SDK (Server-side)
FIREBASE_CLIENT_EMAIL="$DEV_CLIENT_EMAIL"
FIREBASE_PRIVATE_KEY="$DEV_PRIVATE_KEY"

NEXT_FIREBASE_MESSAGING_VAPID=$DEV_VAPID_KEY
EOF
    print_success ".env.development created"

    # Create .env.production
    print_info "Creating .env.production..."
    cat > .env.production << EOF
NODE_ENV=production

# Firebase Production Configuration
NEXT_PUBLIC_FIREBASE_API_KEY="$PROD_API_KEY"
NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN="$PROD_AUTH_DOMAIN"
NEXT_PUBLIC_FIREBASE_PROJECT_ID="$PROD_PROJECT_ID"
NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET="$PROD_STORAGE_BUCKET"
NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID="$PROD_MESSAGING_SENDER_ID"
NEXT_PUBLIC_FIREBASE_APP_ID="$PROD_APP_ID"
NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID="$PROD_MEASUREMENT_ID"

# Firebase Admin SDK (Server-side)
FIREBASE_CLIENT_EMAIL="$PROD_CLIENT_EMAIL"
FIREBASE_PRIVATE_KEY="$PROD_PRIVATE_KEY"

NEXT_FIREBASE_MESSAGING_VAPID=$PROD_VAPID_KEY
EOF
    print_success ".env.production created"

    # Clean up example files
    print_info "Cleaning up example files..."
    if [ -f ".env.development.example" ]; then
        rm .env.development.example
        print_success "Removed .env.development.example"
    fi
    if [ -f ".env.production.example" ]; then
        rm .env.production.example
        print_success "Removed .env.production.example"
    fi

    # Update app metadata in layout.tsx
    print_info "Updating app metadata in layout.tsx..."
    if [ -f "src/app/layout.tsx" ]; then
        sed -i.bak "s/title: \".*\"/title: \"$APP_TITLE\"/" src/app/layout.tsx
        sed -i.bak "s/description: \".*\"/description: \"$APP_DESCRIPTION\"/" src/app/layout.tsx
        rm src/app/layout.tsx.bak
        print_success "layout.tsx updated"
    else
        print_warning "layout.tsx not found, skipping metadata update"
    fi

    # Step 7: Install Dependencies
    print_header "Step 7: Installing Dependencies"

    print_info "Installing main project dependencies..."
    npm install
    if [ $? -eq 0 ]; then
        print_success "Main dependencies installed"
    else
        print_error "Failed to install main dependencies"
        exit 1
    fi

    print_info "Installing functions dependencies..."
    cd functions && npm install && cd ..
    if [ $? -eq 0 ]; then
        print_success "Functions dependencies installed"
    else
        print_error "Failed to install functions dependencies"
        exit 1
    fi

    # Step 8: Install UI Library
    if [ "$UI_LIBRARY" != "skip" ]; then
        print_header "Step 8: Installing UI Library"

        case $UI_LIBRARY in
            shadcn)
                print_info "Installing Shadcn UI..."
                npx shadcn@latest init
                ;;
            material-ui)
                print_info "Installing Material UI..."
                npm install @mui/material @emotion/react @emotion/styled
                ;;
            chakra-ui)
                print_info "Installing Chakra UI..."
                npm install @chakra-ui/react @emotion/react @emotion/styled framer-motion
                ;;
        esac

        print_success "$UI_LIBRARY installed"
    fi

    # Step 9: Firebase Setup
    print_header "Step 9: Firebase Setup"

    read -p "Do you want to deploy Firestore rules now? (y/n): " DEPLOY_RULES

    if [[ "$DEPLOY_RULES" =~ ^[Yy]$ ]]; then
        print_info "Deploying Firestore rules to DEV..."
        firebase use dev
        firebase deploy --only firestore:rules

        print_info "Deploying Firestore rules to PROD..."
        firebase use prod
        firebase deploy --only firestore:rules

        print_success "Firestore rules deployed"
    else
        print_warning "Skipped Firestore rules deployment"
        echo "You can deploy them later with:"
        echo "  firebase use dev && firebase deploy --only firestore:rules"
        echo "  firebase use prod && firebase deploy --only firestore:rules"
    fi

    # Step 10: Rename Directory
    print_header "Step 10: Finalizing Project Setup"

    # Get current directory name and parent directory
    CURRENT_DIR=$(basename "$PWD")
    PARENT_DIR=$(dirname "$PWD")
    
    # Only rename if the current directory name is different from project name
    if [ "$CURRENT_DIR" != "$PROJECT_NAME" ]; then
        print_info "Renaming project directory from '$CURRENT_DIR' to '$PROJECT_NAME'..."
        
        # Check if target directory already exists
        if [ -d "$PARENT_DIR/$PROJECT_NAME" ]; then
            print_warning "Directory '$PROJECT_NAME' already exists in parent directory"
            read -p "Do you want to use a different name? (y/n): " USE_DIFFERENT_NAME
            
            if [[ "$USE_DIFFERENT_NAME" =~ ^[Yy]$ ]]; then
                NEW_PROJECT_NAME=$(prompt_with_default "Enter new project directory name" "${PROJECT_NAME}-new")
                PROJECT_NAME="$NEW_PROJECT_NAME"
            else
                print_warning "Skipping directory rename"
            fi
        fi
        
        # Perform the rename if target doesn't exist
        if [ ! -d "$PARENT_DIR/$PROJECT_NAME" ] && [ "$CURRENT_DIR" != "$PROJECT_NAME" ]; then
            cd "$PARENT_DIR"
            mv "$CURRENT_DIR" "$PROJECT_NAME"
            cd "$PROJECT_NAME"
            print_success "Project directory renamed to '$PROJECT_NAME'"
        fi
    else
        print_info "Project directory already has the correct name: '$PROJECT_NAME'"
    fi

    # Final Summary
    print_header "Setup Complete!"

    echo -e "${GREEN}Your Firebase SSR project has been configured successfully!${NC}\n"

    echo -e "${BLUE}Project Details:${NC}"
    echo -e "  Name: ${GREEN}$PROJECT_NAME${NC}"
    echo -e "  Dev Project: ${GREEN}$DEV_PROJECT_ID${NC}"
    echo -e "  Prod Project: ${GREEN}$PROD_PROJECT_ID${NC}"
    echo -e "  UI Library: ${GREEN}$UI_LIBRARY${NC}\n"

    echo -e "${BLUE}Next Steps:${NC}"
    if [ "$CURRENT_DIR" != "$PROJECT_NAME" ]; then
        echo -e "  1. Navigate to project: ${GREEN}cd ../$PROJECT_NAME${NC}"
        echo -e "  2. Start development server: ${GREEN}npm run dev${NC}"
        echo -e "  3. Build for production: ${GREEN}npm run build${NC}"
        echo -e "  4. Deploy to dev: ${GREEN}npm run deploy:dev${NC}"
        echo -e "  5. Deploy to prod: ${GREEN}npm run deploy:prod${NC}\n"
    else
        echo -e "  1. Start development server: ${GREEN}npm run dev${NC}"
        echo -e "  2. Build for production: ${GREEN}npm run build${NC}"
        echo -e "  3. Deploy to dev: ${GREEN}npm run deploy:dev${NC}"
        echo -e "  4. Deploy to prod: ${GREEN}npm run deploy:prod${NC}\n"
    fi

    echo -e "${BLUE}Firebase Console Links:${NC}"
    echo -e "  Dev: ${GREEN}https://console.firebase.google.com/project/$DEV_PROJECT_ID${NC}"
    echo -e "  Prod: ${GREEN}https://console.firebase.google.com/project/$PROD_PROJECT_ID${NC}\n"

    echo -e "${YELLOW}SSR-Specific Notes:${NC}"
    echo -e "  • This template uses Firebase App Hosting for SSR support"
    echo -e "  • Server-side Firebase Admin SDK credentials are configured"
    echo -e "  • Make sure to keep private keys secure and never commit them"
    echo -e "  • Consider using environment variable injection for production\n"

    echo -e "${YELLOW}Remember to:${NC}"
    echo -e "  • Enable Authentication methods in Firebase Console"
    echo -e "  • Set up billing alerts"
    echo -e "  • Review and customize Firestore rules"
    echo -e "  • Configure custom domains (if needed)"
    echo -e "  • Set up proper CI/CD for environment variables\n"

    print_success "Happy coding with SSR! 🚀"
}

# Show usage information
show_usage() {
    echo "Usage: $0 [PROJECT_ID]"
    echo ""
    echo "Arguments:"
    echo "  PROJECT_ID    Optional base project ID to use for dev/prod environments"
    echo ""
    echo "Examples:"
    echo "  $0                           # Interactive setup"
    echo "  $0 my-project-abc123         # Use my-project-abc123 as base ID"
    echo ""
    echo "If PROJECT_ID is provided, it will be used as the base for:"
    echo "  - Dev environment: PROJECT_ID-dev"
    echo "  - Prod environment: PROJECT_ID-prod"
    echo ""
    echo "Note: This is the SSR template that supports Server-Side Rendering"
    echo "with Firebase App Hosting and requires Firebase Admin SDK credentials."
    echo ""
}

# Check for help flag
if [[ "$1" == "-h" || "$1" == "--help" ]]; then
    show_usage
    exit 0
fi

# Run main function with all arguments
main "$@"
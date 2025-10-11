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

    check_dependencies

    # Step 1: Project Configuration
    print_header "Step 1: Project Configuration"

    PROJECT_NAME=$(prompt_with_default "Enter your project name" "firebase-ssr-template")
    print_info "Project name: $PROJECT_NAME"

    DEV_PROJECT_ID=$(prompt_with_default "Enter Firebase DEV project ID" "${PROJECT_NAME}-dev")
    PROD_PROJECT_ID=$(prompt_with_default "Enter Firebase PROD project ID" "${PROJECT_NAME}-prod")

    print_success "Project configuration set"

    # Step 2: Firebase Configuration
    print_header "Step 2: Firebase Configuration"

    echo -e "${YELLOW}You'll need to get these values from Firebase Console:${NC}"
    echo -e "${BLUE}https://console.firebase.google.com/${NC}\n"
    echo "Go to Project Settings > General > Your apps > Web app"
    echo ""

    read -p "Press Enter to continue with DEV environment configuration..."

    # Development Environment
    print_info "Development Environment Configuration"

    DEV_API_KEY=$(prompt_with_default "DEV API Key" "")
    DEV_AUTH_DOMAIN=$(prompt_with_default "DEV Auth Domain" "${DEV_PROJECT_ID}.firebaseapp.com")
    DEV_STORAGE_BUCKET=$(prompt_with_default "DEV Storage Bucket" "${DEV_PROJECT_ID}.firebasestorage.app")
    DEV_MESSAGING_SENDER_ID=$(prompt_with_default "DEV Messaging Sender ID" "")
    DEV_APP_ID=$(prompt_with_default "DEV App ID" "")
    DEV_MEASUREMENT_ID=$(prompt_with_default "DEV Measurement ID (optional)" "")
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

    PROD_API_KEY=$(prompt_with_default "PROD API Key" "")
    PROD_AUTH_DOMAIN=$(prompt_with_default "PROD Auth Domain" "${PROD_PROJECT_ID}.firebaseapp.com")
    PROD_STORAGE_BUCKET=$(prompt_with_default "PROD Storage Bucket" "${PROD_PROJECT_ID}.firebasestorage.app")
    PROD_MESSAGING_SENDER_ID=$(prompt_with_default "PROD Messaging Sender ID" "")
    PROD_APP_ID=$(prompt_with_default "PROD App ID" "")
    PROD_MEASUREMENT_ID=$(prompt_with_default "PROD Measurement ID (optional)" "")
    PROD_VAPID_KEY=$(prompt_with_default "PROD VAPID Key (optional, for push notifications)" "")

    PROD_CLIENT_EMAIL=$(prompt_with_default "PROD Service Account Email" "")
    echo "PROD Private Key (paste the entire private key including headers):"
    read -r PROD_PRIVATE_KEY

    print_success "Firebase configuration collected"

    # Step 3: App Metadata
    print_header "Step 3: App Metadata"

    APP_TITLE=$(prompt_with_default "App title" "$PROJECT_NAME")
    APP_DESCRIPTION=$(prompt_with_default "App description" "A Next.js SSR app powered by Firebase App Hosting")

    print_success "App metadata set"

    # Step 4: UI Library Selection
    print_header "Step 4: UI Library Selection"

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

    # Step 5: Firebase Login
    print_header "Step 5: Firebase Authentication"

    read -p "Do you want to login to Firebase now? (y/n): " LOGIN_CHOICE

    if [[ "$LOGIN_CHOICE" =~ ^[Yy]$ ]]; then
        firebase login
        if [ $? -eq 0 ]; then
            print_success "Firebase login successful"
        else
            print_error "Firebase login failed"
            exit 1
        fi
    else
        print_warning "Skipping Firebase login. You'll need to login later with: firebase login"
    fi

    # Step 6: Apply Configuration
    print_header "Step 6: Applying Configuration"

    # Update package.json
    print_info "Updating package.json..."

    if command_exists jq; then
        # Use jq if available for safer JSON manipulation
        jq --arg name "$PROJECT_NAME" \
           --arg dev "$DEV_PROJECT_ID" \
           --arg prod "$PROD_PROJECT_ID" \
           '.name = $name |
            .scripts["deploy:dev"] = "dotenv -e .env.development -- npm run build && firebase deploy --only hosting --project \($dev)" |
            .scripts["deploy:prod"] = "dotenv -e .env.production -- npm run build && firebase deploy --only hosting --project \($prod)"' \
           package.json > package.json.tmp && mv package.json.tmp package.json
        print_success "package.json updated"
    else
        # Fallback to sed
        sed -i.bak "s/\"name\": \".*\"/\"name\": \"$PROJECT_NAME\"/" package.json
        sed -i.bak "s/firebase-ssr-template-dev/$DEV_PROJECT_ID/g" package.json
        sed -i.bak "s/firebase-ssr-template-prod/$PROD_PROJECT_ID/g" package.json
        rm package.json.bak
        print_success "package.json updated (using sed)"
    fi

    # Update .firebaserc
    print_info "Updating .firebaserc..."
    cat > .firebaserc << EOF
{
  "projects": {
    "default": "$DEV_PROJECT_ID",
    "dev": "$DEV_PROJECT_ID",
    "prod": "$PROD_PROJECT_ID"
  }
}
EOF
    print_success ".firebaserc updated"

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

    # Final Summary
    print_header "Setup Complete!"

    echo -e "${GREEN}Your Firebase SSR project has been configured successfully!${NC}\n"

    echo -e "${BLUE}Project Details:${NC}"
    echo -e "  Name: ${GREEN}$PROJECT_NAME${NC}"
    echo -e "  Dev Project: ${GREEN}$DEV_PROJECT_ID${NC}"
    echo -e "  Prod Project: ${GREEN}$PROD_PROJECT_ID${NC}"
    echo -e "  UI Library: ${GREEN}$UI_LIBRARY${NC}\n"

    echo -e "${BLUE}Next Steps:${NC}"
    echo -e "  1. Start development server: ${GREEN}npm run dev${NC}"
    echo -e "  2. Build for production: ${GREEN}npm run build${NC}"
    echo -e "  3. Deploy to dev: ${GREEN}npm run deploy:dev${NC}"
    echo -e "  4. Deploy to prod: ${GREEN}npm run deploy:prod${NC}\n"

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

# Run main function
main
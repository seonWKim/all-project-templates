#!/bin/bash

# Setup script for the project
# This script automates the initial setup process

set -e # Exit on error

echo "🚀 Starting project setup..."
echo ""

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check if Node.js is installed
if ! command -v node &> /dev/null; then
    echo "❌ Node.js is not installed. Please install Node.js 20+ first."
    exit 1
fi

echo -e "${BLUE}✓${NC} Node.js version: $(node -v)"

# Check if npm is installed
if ! command -v npm &> /dev/null; then
    echo "❌ npm is not installed. Please install npm first."
    exit 1
fi

echo -e "${BLUE}✓${NC} npm version: $(npm -v)"

# Check if Firebase CLI is installed
if ! command -v firebase &> /dev/null; then
    echo -e "${YELLOW}⚠${NC}  Firebase CLI is not installed."
    read -p "Would you like to install it now? (y/n) " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        npm install -g firebase-tools
    else
        echo "⚠️  You can install it later with: npm install -g firebase-tools"
    fi
else
    echo -e "${BLUE}✓${NC} Firebase CLI version: $(firebase --version)"
fi

# Install root dependencies
echo ""
echo "📦 Installing root dependencies..."
npm install

# Install functions dependencies
echo ""
echo "📦 Installing Firebase Functions dependencies..."
cd functions && npm install && cd ..

# Setup environment files
echo ""
echo "🔧 Setting up environment files..."

if [ ! -f .env.development ]; then
    if [ -f .env.development.example ]; then
        cp .env.development.example .env.development
        echo -e "${GREEN}✓${NC} Created .env.development from example"
        echo -e "${YELLOW}⚠${NC}  Please update .env.development with your Firebase credentials"
    else
        echo "⚠️  .env.development.example not found"
    fi
else
    echo -e "${BLUE}✓${NC} .env.development already exists"
fi

if [ ! -f .env.production ]; then
    if [ -f .env.production.example ]; then
        cp .env.production.example .env.production
        echo -e "${GREEN}✓${NC} Created .env.production from example"
        echo -e "${YELLOW}⚠${NC}  Please update .env.production with your Firebase credentials"
    else
        echo "⚠️  .env.production.example not found"
    fi
else
    echo -e "${BLUE}✓${NC} .env.production already exists"
fi

# Check if Firebase is logged in
echo ""
echo "🔑 Checking Firebase authentication..."
if firebase login --non-interactive &> /dev/null; then
    echo -e "${BLUE}✓${NC} Already logged in to Firebase"
else
    echo -e "${YELLOW}⚠${NC}  Not logged in to Firebase"
    read -p "Would you like to login now? (y/n) " -n 1 -r
    echo
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        firebase login
    else
        echo "⚠️  You can login later with: firebase login"
    fi
fi

# Setup complete
echo ""
echo -e "${GREEN}✅ Setup complete!${NC}"
echo ""
echo "📝 Next steps:"
echo "  1. Update .env.development with your Firebase dev credentials"
echo "  2. Update .env.production with your Firebase prod credentials"
echo "  3. Update .firebaserc with your Firebase project IDs"
echo "  4. Run 'npm run dev' to start the development server"
echo ""
echo "📚 For more information, see README.md"

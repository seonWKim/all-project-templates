#!/bin/bash

# Deployment script with pre-deployment checks
# Usage: ./scripts/deploy.sh [dev|prod]

set -e # Exit on error

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Get environment argument
ENV=${1:-dev}

if [[ "$ENV" != "dev" && "$ENV" != "prod" ]]; then
    echo -e "${RED}❌ Invalid environment. Use 'dev' or 'prod'${NC}"
    exit 1
fi

echo -e "${BLUE}🚀 Starting deployment to ${ENV}...${NC}"
echo ""

# Run pre-deployment checks
echo "🔍 Running pre-deployment checks..."
echo ""

echo "  → Checking code formatting..."
if npm run format:check; then
    echo -e "${GREEN}  ✓ Formatting check passed${NC}"
else
    echo -e "${RED}  ✗ Formatting check failed${NC}"
    exit 1
fi

echo "  → Running linter..."
if npm run lint; then
    echo -e "${GREEN}  ✓ Linting passed${NC}"
else
    echo -e "${RED}  ✗ Linting failed${NC}"
    exit 1
fi

echo "  → Running type check..."
if npm run type-check; then
    echo -e "${GREEN}  ✓ Type check passed${NC}"
else
    echo -e "${RED}  ✗ Type check failed${NC}"
    exit 1
fi

echo "  → Running tests..."
if npm test; then
    echo -e "${GREEN}  ✓ Tests passed${NC}"
else
    echo -e "${RED}  ✗ Tests failed${NC}"
    exit 1
fi

echo ""
echo -e "${GREEN}✅ All pre-deployment checks passed!${NC}"
echo ""

# Confirm deployment
echo -e "${YELLOW}⚠  You are about to deploy to ${ENV}${NC}"
read -p "Continue with deployment? (y/n) " -n 1 -r
echo
if [[ ! $REPLY =~ ^[Yy]$ ]]; then
    echo "Deployment cancelled"
    exit 0
fi

# Build and deploy
echo ""
echo "📦 Building application..."
if [[ "$ENV" == "dev" ]]; then
    npm run deploy:dev
else
    npm run deploy:prod
fi

echo ""
echo -e "${GREEN}✅ Deployment to ${ENV} complete!${NC}"
echo ""
echo "🔗 Check your Firebase console for deployment details"

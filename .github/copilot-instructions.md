# GitHub Copilot Instructions

This repository contains production-ready project templates for building modern web applications with Next.js and Firebase.

## Repository Overview

This is a **monorepo** containing multiple project templates:
- `firebase-csr-template`: Next.js with client-side rendering (CSR) and Firebase
- `firebase-ssr-template`: Next.js with server-side rendering (SSR) and Firebase App Hosting
- `claude-setup`: Configuration files for Claude Code integration

Each template is a complete, self-contained starter project with Firebase integration, authentication, testing, and deployment configurations.

## Tech Stack

### Core Technologies
- **Next.js 15**: React framework with App Router
- **TypeScript**: Strict type checking enabled
- **Firebase**: Backend-as-a-Service (Authentication, Firestore, Cloud Functions, Hosting, Storage, Cloud Messaging)
- **Tailwind CSS**: Utility-first CSS framework
- **Jest**: Testing framework with React Testing Library

### Development Tools
- **ESLint**: Code linting with Next.js config
- **Prettier**: Code formatting
- **dotenv-cli**: Environment variable management
- **Firebase CLI**: Firebase deployment and management

## Project Structure

```
all-project-templates/
├── .github/                    # GitHub configuration (Copilot instructions)
├── .claude/                    # Claude Code agents and settings
├── firebase-csr-template/      # Client-side rendering template
│   ├── src/                   # Source code
│   │   ├── app/              # Next.js App Router pages (all client components)
│   │   ├── components/       # React components
│   │   ├── hooks/            # Custom React hooks
│   │   ├── lib/              # Utilities and Firebase initialization
│   │   └── types/            # TypeScript type definitions
│   ├── functions/            # Firebase Cloud Functions
│   ├── public/               # Static assets
│   ├── firestore.rules       # Firestore security rules
│   └── firebase.json         # Firebase configuration
├── firebase-ssr-template/      # Server-side rendering template
│   └── [similar structure]
└── claude-setup/               # Claude Code configuration files
```

## Coding Conventions

### TypeScript
- Use strict TypeScript configuration
- Prefer interfaces over types for object shapes
- Use explicit return types for functions
- Avoid `any` type - use `unknown` if type is truly unknown
- Use path aliases (e.g., `@/components`, `@/lib`)

### React & Next.js
- **CSR Template**: All components must include `"use client"` directive (no server components)
- **SSR Template**: Use server components by default, add `"use client"` only when needed
- Prefer functional components with hooks
- Use custom hooks for reusable logic
- Follow Next.js App Router conventions (layout.tsx, page.tsx, route.ts)
- Keep components small and focused

### Firebase
- Initialize Firebase in `src/lib/firebase.ts`
- Use environment variables for Firebase configuration (NEXT_PUBLIC_ prefix for client-side)
- Always write Firestore security rules for all collections
- Test security rules before deploying
- Use Firebase Admin SDK only in Cloud Functions or API routes (SSR template)
- Never expose Firebase Admin credentials to the client

### Styling
- Use Tailwind CSS utility classes
- Follow mobile-first responsive design
- Use `clsx` or `tailwind-merge` for conditional classes
- Keep custom CSS in `globals.css` minimal
- No UI library dependencies by default - templates are library-agnostic

### Code Quality
- Run `npm run lint` before committing
- Run `npm run format` to format code
- Run `npm run type-check` to verify TypeScript
- Run `npm test` for unit tests
- Write tests for utility functions and hooks

### File Naming
- Use kebab-case for file and folder names
- React component files: PascalCase.tsx (e.g., `UserProfile.tsx`)
- Utility files: kebab-case.ts (e.g., `format-date.ts`)
- Test files: `*.test.ts` or `*.test.tsx` (same name as file being tested)

## Building and Testing

### CSR Template
```bash
cd firebase-csr-template

# Install dependencies
npm run setup  # Installs both root and functions dependencies

# Development
npm run dev    # Start dev server with Turbopack

# Build
npm run build:dev   # Build for development environment
npm run build:prod  # Build for production environment

# Testing
npm test            # Run tests
npm run test:watch  # Run tests in watch mode
npm run test:coverage  # Run tests with coverage

# Code Quality
npm run lint        # Run ESLint
npm run lint:fix    # Fix ESLint issues
npm run format      # Format code with Prettier
npm run check       # Run all checks (lint, format, type-check, test)

# Type Checking
npm run type-check  # Run TypeScript compiler without emitting files
```

### SSR Template
```bash
cd firebase-ssr-template

# Similar commands as CSR template
npm install
npm run dev
npm run build
npm test
```

### Cloud Functions
```bash
cd functions

# Install dependencies
npm install

# Development
npm run dev    # Run functions locally with Firebase emulator

# Build
npm run build  # Build TypeScript functions

# Deploy
cd ..
npm run deploy:functions:dev   # Deploy to dev environment
npm run deploy:functions:prod  # Deploy to production environment
```

## Deployment

### CSR Template (Static Export)
```bash
# Deploy to Firebase Hosting
npm run deploy:dev   # Deploy to development
npm run deploy:prod  # Deploy to production
npm run deploy       # Deploy to both environments

# This runs:
# 1. firebase use [env]
# 2. npm run build:[env]
# 3. firebase deploy --only hosting
```

### SSR Template (App Hosting)
```bash
# Deploy to Firebase App Hosting
npm run deploy:dev   # Deploy to development
npm run deploy:prod  # Deploy to production

# Uses Firebase App Hosting for SSR support
```

### Firestore
```bash
# Update indexes
npm run update-local-index   # Download indexes from Firebase
npm run update-remote-index  # Deploy indexes to Firebase

# Update security rules
npm run update-remote-rules  # Deploy security rules to Firebase
```

## Environment Management

Each template uses separate development and production environments:

### Environment Files
- `.env.development`: Development Firebase configuration
- `.env.production`: Production Firebase configuration
- `.env.development.example`: Template for development config
- `.env.production.example`: Template for production config

**IMPORTANT**: Never commit actual `.env` files to version control. They contain sensitive Firebase credentials.

### Firebase Projects
Configure in `.firebaserc`:
```json
{
  "projects": {
    "default": "project-dev",
    "dev": "project-dev",
    "prod": "project-prod"
  }
}
```

## Security Best Practices

### Firestore Security Rules
- Always write security rules for all collections
- Test rules before deploying: `firebase emulators:start`
- Use `request.auth` to validate authenticated users
- Validate all fields in write operations
- Use rules to prevent unauthorized data access

### Environment Variables
- Use `NEXT_PUBLIC_` prefix for client-side variables
- Never expose Firebase Admin credentials to client
- Store sensitive data in Firebase Functions config or Secret Manager
- Review all environment variables before committing examples

### Authentication
- Validate user authentication in security rules
- Use Firebase Auth tokens for API authentication
- Implement proper session management
- Add rate limiting for sensitive operations

## Claude Code Agents

This repository includes specialized AI agents in `.claude/agents/`:
- `architecture-agent.md`: System architecture and design decisions
- `development-agent.md`: Development workflow and implementation
- `firebase-agent.md`: Firebase backend and database design
- `ui-ux-agent.md`: UI/UX design and component development
- `code-review-agent.md`: Code quality and best practices
- `qa-agent.md`: Testing and quality assurance

Use these agents in Claude Code by typing `/` and selecting the appropriate agent.

## Common Tasks

### Adding a New Component
1. Create component file in `src/components/`
2. Add `"use client"` directive if in CSR template or if component uses hooks/interactivity
3. Export component as default or named export
4. Write tests in `__tests__` directory
5. Update component documentation

### Adding a New Page
1. Create `page.tsx` in appropriate `src/app/` directory
2. Add `"use client"` directive if in CSR template
3. Implement page component
4. Update navigation if needed
5. Test page functionality

### Adding a Cloud Function
1. Add function in `functions/src/index.ts`
2. Export function (e.g., `export const myFunction = onCall(...)`)
3. Update TypeScript types if needed
4. Test locally with emulator
5. Deploy: `npm run deploy:functions:dev`

### Adding Firebase Service
1. Enable service in Firebase Console
2. Update `src/lib/firebase.ts` with initialization
3. Add environment variables if needed
4. Update security rules if applicable
5. Document usage in README

## Testing Guidelines

### Unit Tests
- Test utility functions in `src/lib/__tests__/`
- Test custom hooks with React Testing Library
- Mock Firebase SDK: `jest.mock('firebase/...', () => ({...}))`
- Use descriptive test names: `describe()` and `it()`

### Test Structure
```typescript
describe('ComponentName', () => {
  it('should render correctly', () => {
    // Arrange
    // Act
    // Assert
  });
});
```

### Running Tests
- Run all tests: `npm test`
- Run specific test: `npm test -- ComponentName.test.tsx`
- Update snapshots: `npm test -- -u`
- Coverage report: `npm run test:coverage`

## Troubleshooting

### Build Errors
- Clear Next.js cache: `npm run clean`
- Reinstall dependencies: `npm run reset`
- Check TypeScript errors: `npm run type-check`
- Verify all environment variables are set

### Firebase Errors
- Verify Firebase CLI is logged in: `firebase login`
- Check project configuration: `firebase projects:list`
- Verify credentials in `.env` files match Firebase console
- Check Firebase quota limits and billing

### Deployment Issues
- Verify build completes successfully: `npm run build:prod`
- Check Firebase hosting configuration in `firebase.json`
- Review deployment logs in Firebase console
- Verify security rules don't block legitimate access

## Additional Notes

### Template Customization
These templates are intentionally minimal and unopinionated:
- No UI component library included (add Shadcn, MUI, Chakra, etc. as needed)
- No state management library (add Redux, Zustand, Jotai, etc. as needed)
- No form library (add React Hook Form, Formik, etc. as needed)

### Version Requirements
- Node.js 20+ recommended
- npm 10+ recommended
- Firebase CLI 13+ required

### Useful Commands
```bash
# Check versions
node --version
npm --version
firebase --version

# Firebase CLI
firebase login                    # Login to Firebase
firebase projects:list           # List projects
firebase use dev                 # Switch to dev environment
firebase emulators:start        # Start local emulators

# Git
git status                       # Check working tree status
git branch                       # List branches
git log --oneline -10           # Show recent commits
```

## Contributing to Templates

When modifying templates:
1. Test changes in both development and production environments
2. Update relevant documentation (README.md, ARCHITECTURE.md, etc.)
3. Run all quality checks: `npm run check`
4. Test deployment process end-to-end
5. Update example files if configuration changes
6. Keep templates minimal and focused

## Support and Resources

- [Next.js Documentation](https://nextjs.org/docs)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)
- [TypeScript Documentation](https://www.typescriptlang.org/docs)
- [Jest Documentation](https://jestjs.io/docs/getting-started)

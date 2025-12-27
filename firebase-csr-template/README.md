# Firebase CSR Template

A comprehensive, production-ready Next.js + Firebase template for building modern client-side rendered (CSR) web applications. This template provides a complete foundation with TypeScript, Tailwind CSS, Firebase integration, pre-built UI components, authentication flows, testing setup, and Claude Code agents.

## ✨ Features

### Core Stack
- **Next.js 15** with App Router and Turbopack (Static Export / CSR only)
- **React 19** with modern hooks and patterns
- **TypeScript** for full type safety
- **Tailwind CSS 4** for utility-first styling

### Firebase Integration
- **Authentication** (client-side) with pre-built sign-in/sign-up forms
- **Firestore Database** (client-side) with security rules
- **Cloud Functions** (backend) with examples
- **Storage** (client-side) for file uploads
- **Cloud Messaging** (client-side) for push notifications
- **Hosting** (static files) with automatic SSL

### UI Components
- **Reusable Components**: Button, Input, Card, Toast notifications
- **Authentication Forms**: Sign-in and sign-up with validation
- **Protected Routes**: Automatic route protection for authenticated pages
- **Navigation**: Responsive navbar with user state
- **Error Boundaries**: Graceful error handling
- **Loading States**: Smooth loading indicators throughout

### Developer Experience
- **Jest Testing** with React Testing Library
- **ESLint & Prettier** for code quality
- **Type-Safe Environment Variables** with validation
- **Claude Code Agents** for AI-assisted development
- **Dev/Prod Environments** out of the box
- **Hot Module Replacement** for fast development

### Security
- **No Vulnerabilities**: All dependencies audited and secured
- **CodeQL Scanned**: Automated security analysis
- **Enhanced Firestore Rules**: Comprehensive security examples
- **Input Validation**: Client-side form validation
- **Error Handling**: Proper error boundaries and user feedback

> **Note**: This template is configured for client-side rendering (CSR) only. All pages are static exports with no server-side rendering or API routes.

## Quick Start

### 1. Prerequisites

- Node.js 20+ and npm
- Firebase CLI: `npm install -g firebase-tools`
- Firebase account and two projects (dev and prod)

### 2. Installation

```bash
# Clone or copy this template
cd your-project-name

# Install dependencies
npm run setup
```

### 3. Firebase Setup

1. Create two Firebase projects:
   - `your-project-dev` (development)
   - `your-project-prod` (production)

2. Copy environment files:
```bash
cp .env.development.example .env.development
cp .env.production.example .env.production
```

3. Update `.env.development` and `.env.production` with your Firebase credentials

4. Update `.firebaserc` with your project IDs:
```json
{
  "projects": {
    "default": "your-project-dev",
    "dev": "your-project-dev",
    "prod": "your-project-prod"
  }
}
```

5. Login to Firebase:
```bash
firebase login
```

6. Initialize Firebase (optional - if you need to reconfigure):
```bash
firebase init
```

### 4. Update Project Names

Update the following files with your project name:
- `package.json` - Change `name` field
- `template/src/app/layout.tsx` - Update metadata
- `template/README.md` - Update project name

### 5. Development

```bash
# Start development server
npm run dev

# Open http://localhost:3000
```

## Scripts

### Development
```bash
npm run dev          # Start dev server with Turbopack
npm run build        # Build for production
npm run start        # Serve production build locally
```

### Code Quality
```bash
npm run lint         # Run ESLint
npm run lint:fix     # Fix ESLint issues
npm run format       # Format code with Prettier
npm run format:check # Check code formatting
```

### Testing
```bash
npm test             # Run tests
npm run test:watch   # Run tests in watch mode
npm run test:coverage # Run tests with coverage
```

### Deployment
```bash
npm run deploy       # Deploy to both dev and prod
npm run deploy:dev   # Deploy to development
npm run deploy:prod  # Deploy to production
```

### Firebase Functions
```bash
npm run deploy:functions     # Deploy functions to both environments
npm run deploy:functions:dev # Deploy functions to dev
npm run deploy:functions:prod # Deploy functions to prod

# Or manually in functions directory:
cd functions
npm run dev          # Run functions locally with emulator
npm run build        # Build functions
```

### Firestore
```bash
npm run update-local-index   # Download indexes from Firebase
npm run update-remote-index  # Deploy indexes to Firebase
npm run update-remote-rules  # Deploy security rules to Firebase
```

## Project Structure

```
├── .claude/                 # Claude Code agent configurations
│   ├── agents/             # Specialized AI agents
│   └── settings.local.json
├── functions/              # Firebase Cloud Functions (backend)
│   └── src/
│       └── index.ts       # Functions entry point
├── public/                 # Static assets (robots.txt, sitemap.xml, etc.)
├── src/
│   ├── app/               # Next.js App Router pages (client-side only)
│   │   ├── layout.tsx    # Root layout with providers
│   │   ├── page.tsx      # Landing page with auth
│   │   ├── dashboard/    # Protected dashboard
│   │   └── globals.css   # Global styles
│   ├── components/        # React components (all client-side)
│   │   ├── ui/           # Reusable UI components
│   │   │   ├── button.tsx
│   │   │   ├── input.tsx
│   │   │   ├── card.tsx
│   │   │   ├── toast.tsx
│   │   │   └── error-boundary.tsx
│   │   ├── auth/         # Authentication components
│   │   │   ├── sign-in-form.tsx
│   │   │   ├── sign-up-form.tsx
│   │   │   └── protected-route.tsx
│   │   ├── layout/       # Layout components
│   │   │   └── navbar.tsx
│   │   └── __tests__/    # Component tests
│   ├── hooks/            # Custom React hooks
│   │   └── useAuth.ts   # Firebase auth hook
│   ├── lib/              # Utility functions and services
│   │   ├── env.ts       # Environment variable validation
│   │   ├── firebase.ts  # Firebase client initialization
│   │   ├── utils.ts     # Common utilities
│   │   └── __tests__/   # Test files
│   └── types/           # TypeScript type definitions
├── .env.development.example
├── .env.production.example
├── firebase.json         # Firebase configuration
├── .firebaserc          # Firebase projects
├── firestore.rules      # Firestore security rules
├── firestore.indexes.json # Firestore indexes
├── next.config.ts       # Next.js configuration (static export)
├── tsconfig.json        # TypeScript configuration
├── eslint.config.mjs    # ESLint configuration
├── .prettierrc          # Prettier configuration
├── jest.config.js       # Jest configuration
└── package.json
```

## What's New in This Version

This template has been significantly enhanced to provide a production-ready foundation:

### 🎨 Complete UI Component Library
- Pre-built Button, Input, Card components with variants
- Toast notification system for user feedback
- Error boundary for graceful error handling
- Fully responsive and accessible components

### 🔐 Ready-to-Use Authentication
- Sign-in and sign-up forms with validation
- Protected route wrapper for secure pages
- Responsive navigation with user state
- Dashboard page for authenticated users
- Comprehensive error messages for better UX

### 🔒 Enhanced Security
- All dependencies updated to fix vulnerabilities
- Improved Firestore security rules with examples
- CodeQL security scanning passed
- Input validation on all forms
- Proper error handling throughout

### 🧪 Comprehensive Testing
- Component tests for all UI components
- 31 passing tests out of the box
- React Testing Library integration
- Easy to extend with your own tests

### 📱 Better User Experience
- Beautiful landing page with feature showcase
- Smooth loading states and transitions
- Toast notifications for actions
- Responsive design for all screen sizes
- Dark mode support via CSS variables

## Firebase Services

### Authentication

Authentication is configured and ready to use. Import from `@/lib/firebase`:

```typescript
import { auth } from "@/lib/firebase";
import { signInWithEmailAndPassword } from "firebase/auth";
```

### Firestore Database

Firestore is initialized and ready. Security rules are in `firestore.rules`:

```typescript
import { db } from "@/lib/firebase";
import { collection, addDoc } from "firebase/firestore";
```

### Cloud Functions

Example functions are in `functions/src/index.ts`:
- HTTP function
- Firestore trigger
- Scheduled function
- Callable function

### Storage

Firebase Storage is configured:

```typescript
import { storage } from "@/lib/firebase";
import { ref, uploadBytes } from "firebase/storage";
```

### Cloud Messaging

Optional messaging support:

```typescript
import { messaging } from "@/lib/firebase";
```

## Claude Code Agents

This template includes specialized AI agents for different development tasks:

- **architecture-agent**: System architecture and design decisions
- **development-agent**: Development workflow and implementation
- **firebase-agent**: Firebase backend and database design
- **ui-ux-agent**: UI/UX design and component development
- **code-review-agent**: Code quality and best practices
- **qa-agent**: Testing and quality assurance

Use agents in Claude Code by typing `/` to see available agents.

## Environment Variables

### Development (.env.development)
```env
PHASE=development
NEXT_PUBLIC_FIREBASE_API_KEY=...
NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN=...
NEXT_PUBLIC_FIREBASE_PROJECT_ID=...
NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET=...
NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID=...
NEXT_PUBLIC_FIREBASE_APP_ID=...
NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID=...
NEXT_FIREBASE_MESSAGING_VAPID=...
```

### Production (.env.production)
Same variables but with production values.

## Best Practices

### Security
- Never commit `.env.development` or `.env.production` files
- Review and test Firestore security rules thoroughly
- Use environment variables for sensitive data
- Enable Firebase App Check for production

### Code Quality
- Run `npm run lint` before committing
- Run `npm run format` to maintain consistent style
- Write tests for critical functionality
- Use TypeScript strictly

### Firebase
- Test with Firebase emulators during development
- Use separate dev/prod environments
- Monitor Firebase usage and costs
- Set up Firebase budget alerts

### Deployment
- Test thoroughly in development before deploying to production
- Review security rules before deploying
- Monitor deployments for errors
- Keep functions deployment separate from hosting

## Customization

### Add UI Components

This template intentionally doesn't include a UI library. Add your preferred library:

```bash
# Shadcn UI
npx shadcn@latest init

# Material UI
npm install @mui/material @emotion/react @emotion/styled

# Chakra UI
npm install @chakra-ui/react @emotion/react @emotion/styled

# Or any other library you prefer
```

### Add More Firebase Features

Enable additional Firebase services in your Firebase console and add them to `src/lib/firebase.ts`.

### Customize Tailwind

Edit `src/app/globals.css` to customize Tailwind CSS variables and add custom styles.

## Troubleshooting

### Build Errors
- Ensure all environment variables are set
- Check TypeScript errors with `npx tsc --noEmit`
- Clear Next.js cache: `rm -rf .next`

### Firebase Errors
- Verify Firebase credentials in `.env` files
- Check Firebase project IDs in `.firebaserc`
- Ensure Firebase CLI is logged in: `firebase login`

### Deployment Issues
- Check Firebase hosting configuration in `firebase.json`
- Verify build completes successfully: `npm run build`
- Check Firebase console for deployment logs

## Contributing

This is a template repository. Fork it and customize it for your needs!

## License

MIT License - feel free to use this template for any project.
# side-project-template

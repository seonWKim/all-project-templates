# Firebase CSR Template (Hexagonal Architecture)

A comprehensive, production-ready Next.js + Firebase template for building modern client-side rendered (CSR) web applications with **hexagonal architecture** and **BAAS provider abstraction**. This template enables seamless switching between Firebase, AWS, Supabase, or any other Backend-as-a-Service provider.

## ✨ Features

### Core Stack

- **Next.js 15** with App Router and Turbopack (Static Export / CSR only)
- **React 19** with modern hooks and patterns
- **TypeScript** for full type safety
- **Tailwind CSS 4** for utility-first styling

### Hexagonal Architecture

- **Ports and Adapters Pattern**
  - Clean separation between business logic and external services
  - BAAS-agnostic design - switch providers without changing business logic
  - Testable, maintainable, and scalable architecture
- **BAAS Abstraction Layer**
  - Currently supports Firebase (fully implemented)
  - Ready for AWS Amplify, Supabase, or custom backends
  - Port interfaces for Auth, Database, Storage, Messaging

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
  - Architectural tests to enforce design boundaries
  - Port interface validation
  - Component tests with coverage
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

### Comprehensive Documentation

- **ARCHITECTURE.md** - Hexagonal architecture principles
- **CLAUDE.md** - AI assistant guidelines with architectural decisions
- **BAAS_CONFIGURATION.md** - Provider switching guide
- **README.md** - This file with quick start and usage

> **Note**: This template is configured for client-side rendering (CSR) only. All pages are static exports with no server-side rendering or API routes.

## Architecture Overview

This template follows **Hexagonal Architecture** principles:

```
┌─────────────────────────────────────────────────┐
│              Primary Adapters                   │
│         (UI Components, API Routes)             │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│           Application Layer                     │
│          (Use Cases, Services)                  │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│            Domain Layer                         │
│     (Business Logic, Port Interfaces)           │
└────────────────┬────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────┐
│          Secondary Adapters                     │
│    (Firebase, AWS, Supabase, etc.)              │
└─────────────────────────────────────────────────┘
```

**Key Benefits:**

- Switch BAAS providers via environment variable
- Business logic independent of external services
- Easy to test with mocked adapters
- Clear boundaries and separation of concerns

See [ARCHITECTURE.md](./ARCHITECTURE.md) for detailed architecture documentation.

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

## Project Structure (Hexagonal Architecture)

```
├── .claude/                      # Claude Code agent configurations
│   ├── agents/                  # Specialized AI agents
│   └── settings.local.json
├── __tests__/                   # Architecture tests
│   └── architecture/            # Architectural validation tests
├── functions/                   # Firebase Cloud Functions (backend)
│   └── src/
│       └── index.ts            # Functions entry point
├── public/                      # Static assets
├── src/
│   ├── app/                    # Next.js App Router (Primary Adapters)
│   │   ├── layout.tsx          # Root layout
│   │   ├── page.tsx            # Home page
│   │   └── globals.css         # Global styles
│   ├── components/             # React components (Primary Adapters)
│   ├── domain/                 # DOMAIN LAYER (Core Business Logic)
│   │   ├── models/             # Domain entities (User, Post, etc.)
│   │   ├── ports/              # Port interfaces (contracts)
│   │   └── services/           # Domain services
│   ├── application/            # APPLICATION LAYER
│   │   ├── use-cases/          # Business use cases
│   │   └── services/           # Application services
│   ├── adapters/               # ADAPTER LAYER (Secondary Adapters)
│   │   └── baas/               # BAAS provider adapters
│   │       ├── firebase/       # Firebase implementations
│   │       │   ├── firebase-auth.adapter.ts
│   │       │   ├── firebase-database.adapter.ts
│   │       │   ├── firebase-storage.adapter.ts
│   │       │   └── firebase-messaging.adapter.ts
│   │       ├── aws/            # AWS Amplify (future)
│   │       ├── supabase/       # Supabase (future)
│   │       └── factory.ts      # Adapter factory
│   ├── hooks/                  # Custom React hooks
│   │   └── useAuth.ts          # Auth hook (uses ports)
│   ├── lib/                    # Utilities and configuration
│   │   ├── env.ts              # Environment validation
│   │   ├── firebase.ts         # Firebase initialization
│   │   ├── utils.ts            # Utility functions
│   │   └── __tests__/          # Test files
│   └── types/                  # TypeScript types
├── ARCHITECTURE.md              # Architecture documentation
├── CLAUDE.md                    # AI assistant guidelines
├── BAAS_CONFIGURATION.md        # BAAS provider configuration guide
├── .env.development.example
├── .env.production.example
├── firebase.json                # Firebase configuration
├── next.config.ts               # Next.js configuration
└── package.json
```

## Architecture Documentation

- **[ARCHITECTURE.md](./ARCHITECTURE.md)** - Detailed architecture overview, data flow, and design decisions
- **[CLAUDE.md](./CLAUDE.md)** - Guidelines for AI assistants working on this codebase
- **[BAAS_CONFIGURATION.md](./BAAS_CONFIGURATION.md)** - Guide to configuring and switching BAAS providers

## Using the Architecture

### Working with Authentication

```typescript
// ✅ CORRECT: Use adapter via factory (provider-agnostic)
import { getAuthAdapter } from "@/adapters/baas/factory";
import { LoginUseCase } from "@/application/use-cases/login.use-case";

const authAdapter = getAuthAdapter();
const loginUseCase = new LoginUseCase(authAdapter);
await loginUseCase.execute({ email, password });

// ❌ WRONG: Direct Firebase import (couples to provider)
import { signInWithEmailAndPassword } from "firebase/auth";
```

### Working with Database

```typescript
// ✅ CORRECT: Use adapter via factory
import { getDatabaseAdapter } from "@/adapters/baas/factory";

const db = getDatabaseAdapter<Post>();
const posts = await db.findMany("posts", [
  { field: "authorId", operator: "==", value: userId },
]);

// ❌ WRONG: Direct Firestore import
import { collection, query, where, getDocs } from "firebase/firestore";
```

### Creating Custom Hooks

```typescript
// Custom hook using the adapter pattern
import { getAuthAdapter } from "@/adapters/baas/factory";

export function useAuth() {
  const [user, setUser] = useState<User | null>(null);

  useEffect(() => {
    const authAdapter = getAuthAdapter();
    return authAdapter.onAuthStateChanged(setUser);
  }, []);

  return { user };
}
```

## BAAS Services (Provider-Agnostic)

## BAAS Services (Provider-Agnostic)

All BAAS services are accessed through port interfaces, making them provider-agnostic.

### Authentication

```typescript
import { getAuthAdapter } from "@/adapters/baas/factory";

const auth = getAuthAdapter();

// Sign in
const user = await auth.signIn({ email, password });

// Sign up
const newUser = await auth.signUp({ email, password });

// Sign out
await auth.signOut();

// Listen to auth state
const unsubscribe = auth.onAuthStateChanged(user => {
  console.log("User:", user);
});
```

### Database (Firestore/DynamoDB/PostgreSQL)

```typescript
import { getDatabaseAdapter } from "@/adapters/baas/factory";

const db = getDatabaseAdapter<YourType>();

// Create document
const id = await db.create("collection", { name: "Item" });

// Find by ID
const item = await db.findById("collection", id);

// Query documents
const items = await db.findMany("collection", [
  { field: "status", operator: "==", value: "active" },
]);

// Update
await db.update("collection", id, { name: "Updated" });

// Delete
await db.delete("collection", id);

// Real-time subscription
const unsubscribe = db.subscribe("collection", undefined, data => {
  console.log("Data updated:", data);
});
```

### Storage

```typescript
import { getStorageAdapter } from "@/adapters/baas/factory";

const storage = getStorageAdapter();

// Upload file
const url = await storage.upload("path/to/file.jpg", file);

// Get download URL
const downloadUrl = await storage.getDownloadURL("path/to/file.jpg");

// Delete file
await storage.delete("path/to/file.jpg");
```

### Messaging (Push Notifications)

```typescript
import { getMessagingAdapter } from "@/adapters/baas/factory";

const messaging = getMessagingAdapter();

// Request permission and get token
const token = await messaging.requestPermission();

// Listen for messages
const unsubscribe = messaging.onMessage(payload => {
  console.log("Message received:", payload);
});
```

## Switching BAAS Providers

To switch from Firebase to another provider (e.g., AWS Amplify):

1. **Set environment variable:**

```bash
NEXT_PUBLIC_BAAS_PROVIDER=aws
```

2. **Implement AWS adapters** (or use existing ones)

3. **Configure AWS credentials** in `.env`

4. **No code changes needed** - your application continues to work!

See [BAAS_CONFIGURATION.md](./BAAS_CONFIGURATION.md) for detailed instructions.

## Firebase-Specific Setup (Current Default)

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

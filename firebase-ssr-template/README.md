# Firebase SSR Template

A Next.js SSR application template powered by Firebase App Hosting with authentication, Firestore, and cloud functions.

## Features

- **Next.js 15** with Server-Side Rendering (SSR)
- **Firebase App Hosting** for SSR deployment
- **Firebase Authentication** with email/password
- **Firestore** for real-time database
- **Firebase Cloud Functions** for backend logic
- **TypeScript** for type safety
- **TailwindCSS** for styling
- **ESLint + Prettier** for code quality
- **Jest** for testing

## Quick Start

1. **Clone and setup:**
   ```bash
   git clone <repo-url>
   cd firebase-ssr-template
   npm install
   ```

2. **Firebase setup:**
   ```bash
   # Install Firebase CLI
   npm install -g firebase-tools
   
   # Login to Firebase
   firebase login
   
   # Create Firebase projects
   firebase projects:create firebase-ssr-template-dev
   firebase projects:create firebase-ssr-template-prod
   ```

3. **Environment configuration:**
   ```bash
   # Copy and configure environment files
   cp .env.development.example .env.development
   cp .env.production.example .env.production
   
   # Edit the files with your Firebase configuration
   ```

4. **Get Firebase service account key:**
   - Go to Firebase Console → Project Settings → Service Accounts
   - Generate new private key
   - Add the client email and private key to your environment files

5. **Run development server:**
   ```bash
   npm run dev
   ```

## Project Structure

```
src/
├── app/                 # Next.js app directory
│   ├── layout.tsx       # Root layout
│   ├── page.tsx         # Home page
│   └── globals.css      # Global styles
├── components/          # React components
│   ├── UserProfile.tsx  # Authentication component
│   └── PostsList.tsx    # Server-side rendered posts
├── hooks/               # Custom React hooks
│   └── useAuth.ts       # Authentication hook
├── lib/                 # Utility libraries
│   ├── firebase-client.ts  # Client-side Firebase config
│   ├── firebase-admin.ts   # Server-side Firebase config
│   ├── env.ts              # Environment validation
│   └── utils.ts            # Utility functions
└── types/               # TypeScript type definitions
    └── index.ts
```

## Development

```bash
# Start development server
npm run dev

# Run tests
npm test

# Run linting
npm run lint

# Format code
npm run format

# Type checking
npm run type-check

# Run all checks
npm run check
```

## Deployment

```bash
# Build and deploy to development
npm run deploy:dev

# Build and deploy to production
npm run deploy:prod

# Deploy functions only
npm run deploy:functions
```

## Firebase App Hosting vs Static Hosting

This template uses Firebase App Hosting which supports:
- Server-Side Rendering (SSR)
- API routes
- Server components
- Dynamic routes

For static sites, use the `firebase-csr-template` instead.

## Environment Variables

### Client-side (Public)
- `NEXT_PUBLIC_FIREBASE_API_KEY`
- `NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN`
- `NEXT_PUBLIC_FIREBASE_PROJECT_ID`
- `NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET`
- `NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID`
- `NEXT_PUBLIC_FIREBASE_APP_ID`
- `NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID` (optional)

### Server-side (Private)
- `FIREBASE_CLIENT_EMAIL`
- `FIREBASE_PRIVATE_KEY`

## License

MIT
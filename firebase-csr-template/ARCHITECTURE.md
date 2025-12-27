# Architecture Overview

This document describes the **Hexagonal Architecture** (Ports and Adapters) implementation of the Firebase CSR template.

## Architecture Philosophy

This template follows **Hexagonal Architecture** principles to achieve:
- **BAAS Provider Independence**: Seamlessly switch between Firebase, AWS Amplify, Supabase, or other BAAS providers
- **Testability**: Core business logic isolated from external dependencies
- **Maintainability**: Clear separation of concerns with defined boundaries
- **Extensibility**: Easy to add new features and integrations

## Hexagonal Architecture Layers

### 1. Domain Layer (Core)
The innermost layer containing:
- **Domain Models**: Pure business entities (User, Post, etc.)
- **Domain Logic**: Business rules independent of frameworks
- **Port Interfaces**: Contracts for external dependencies

### 2. Application Layer
Coordinates domain objects and implements use cases:
- **Use Cases**: Application-specific business logic
- **Application Services**: Orchestrate domain objects
- **Port Definitions**: Input/output interfaces

### 3. Adapter Layer
Implements port interfaces for external systems:
- **Primary Adapters** (Driving): UI components, API endpoints
- **Secondary Adapters** (Driven): BAAS providers, storage, messaging
- **Adapter Factory**: Creates appropriate adapter instances

### 4. Infrastructure Layer
Framework and tool-specific code:
- Next.js configuration
- Build tools
- Deployment scripts

## Tech Stack

- **Frontend**: Next.js 15 (App Router) + React + TypeScript (CSR/Static Export Only)
- **Styling**: Tailwind CSS
- **Backend**: Backend-as-a-Service (BAAS) - Currently Firebase
  - Authentication (via adapter)
  - Database (via adapter)
  - Storage (via adapter)
  - Messaging (via adapter)
  - Hosting
- **Testing**: Jest + Architecture Tests
- **Code Quality**: ESLint + Prettier
- **AI Assistance**: Claude Code with specialized agents

## Rendering Strategy

This template uses **Client-Side Rendering (CSR)** exclusively with Next.js static export:
- All pages are pre-built as static HTML/CSS/JS
- No server-side rendering (SSR) or API routes
- All dynamic functionality runs in the browser
- Firebase client SDKs handle all backend communication
- Deployed as static files to Firebase Hosting

## Directory Structure (Hexagonal Architecture)

```
├── .claude/                      # Claude Code configuration
│   ├── agents/                  # Specialized AI agents
│   └── settings.local.json      # Local settings
├── .github/                     # GitHub configuration
│   ├── workflows/               # CI/CD workflows
│   └── PULL_REQUEST_TEMPLATE.md # PR guidelines with architecture checklist
├── functions/                   # Firebase Cloud Functions (adapter layer)
│   └── src/
│       └── index.ts            # Functions entry point
├── public/                      # Static assets
├── src/
│   ├── app/                    # Next.js App Router (primary adapters)
│   │   ├── layout.tsx          # Root layout
│   │   ├── page.tsx            # Home page
│   │   ├── globals.css         # Global styles
│   │   ├── api/                # API routes
│   │   ├── robots.ts           # Robots.txt
│   │   └── sitemap.ts          # Sitemap
│   ├── components/             # React components (primary adapters)
│   │   └── providers/          # Context providers
│   ├── domain/                 # DOMAIN LAYER
│   │   ├── models/             # Pure domain entities
│   │   ├── ports/              # Port interfaces (contracts)
│   │   └── services/           # Domain logic/business rules
│   ├── application/            # APPLICATION LAYER
│   │   ├── use-cases/          # Application use cases
│   │   └── services/           # Application services
│   ├── adapters/               # ADAPTER LAYER
│   │   ├── baas/               # BAAS provider adapters
│   │   │   ├── firebase/       # Firebase implementation
│   │   │   ├── aws/            # AWS Amplify implementation (future)
│   │   │   ├── supabase/       # Supabase implementation (future)
│   │   │   └── factory.ts      # Adapter factory
│   │   └── storage/            # Storage adapters
│   ├── hooks/                  # Custom hooks (using ports)
│   ├── lib/                    # Utilities and configuration
│   │   ├── config.ts           # BAAS configuration
│   │   ├── utils.ts            # Utility functions
│   │   └── __tests__/          # Test files
│   └── types/                  # TypeScript types
├── __tests__/                  # Architecture tests
│   └── architecture/           # Architecture validation tests
├── CLAUDE.md                   # Architectural guidelines for AI
├── firebase.json               # Firebase configuration
├── .firebaserc                 # Firebase projects
├── firestore.rules             # Firestore security rules
├── firestore.indexes.json      # Firestore indexes
└── package.json                # Dependencies and scripts
```

## Data Flow (Hexagonal Architecture)

### Primary Adapter → Application → Domain → Secondary Adapter Flow

```
UI Component (Primary Adapter)
    ↓
Use Case (Application Layer)
    ↓
Domain Service (Domain Layer)
    ↓
Port Interface (Domain Layer)
    ↓
BAAS Adapter (Secondary Adapter - e.g., Firebase)
    ↓
External Service (Firebase/AWS/etc.)
```

### Example: Authentication Flow

```
Login Component
    ↓ calls
AuthUseCase.login(email, password)
    ↓ uses
AuthPort.authenticate(credentials)
    ↓ implemented by
FirebaseAuthAdapter.authenticate(credentials)
    ↓ calls
Firebase Auth SDK
```

### Example: Data Access Flow

```
User Profile Component
    ↓ calls
UserUseCase.getUserProfile(userId)
    ↓ uses
UserPort.findById(userId)
    ↓ implemented by
FirebaseDatabaseAdapter.findById(userId)
    ↓ calls
Firestore SDK
```

## BAAS Provider Abstraction

### Supported BAAS Providers

This architecture supports multiple BAAS providers through the adapter pattern:

1. **Firebase** (Current Default)
   - Authentication, Firestore, Storage, Cloud Messaging, Functions
2. **AWS Amplify** (Future)
   - Cognito, DynamoDB, S3, SNS, Lambda
3. **Supabase** (Future)
   - Auth, PostgreSQL, Storage, Realtime
4. **Custom/Other** (Extensible)
   - Any BAAS that implements the port interfaces

### Switching BAAS Providers

To switch BAAS providers:

1. **Configuration**: Update `src/lib/config.ts` to specify the provider
2. **Adapter**: Ensure the adapter for the provider exists in `src/adapters/baas/`
3. **Environment Variables**: Update `.env` with provider-specific credentials
4. **Dependencies**: Install provider-specific SDKs

Example configuration:

```typescript
// src/lib/config.ts
export const baasConfig = {
  provider: 'firebase', // or 'aws', 'supabase'
  // provider-specific config
};
```

The adapter factory automatically instantiates the correct adapter based on configuration.

### Port Interfaces (Contracts)

All BAAS adapters must implement these port interfaces:

#### AuthPort
```typescript
interface AuthPort {
  signIn(email: string, password: string): Promise<User>;
  signUp(email: string, password: string): Promise<User>;
  signOut(): Promise<void>;
  getCurrentUser(): Promise<User | null>;
  onAuthStateChanged(callback: (user: User | null) => void): () => void;
}
```

#### DatabasePort
```typescript
interface DatabasePort<T> {
  create(collection: string, data: T): Promise<string>;
  findById(collection: string, id: string): Promise<T | null>;
  findMany(collection: string, query?: Query): Promise<T[]>;
  update(collection: string, id: string, data: Partial<T>): Promise<void>;
  delete(collection: string, id: string): Promise<void>;
  subscribe(collection: string, callback: (data: T[]) => void): () => void;
}
```

#### StoragePort
```typescript
interface StoragePort {
  upload(path: string, file: File): Promise<string>;
  download(path: string): Promise<Blob>;
  delete(path: string): Promise<void>;
  getDownloadURL(path: string): Promise<string>;
}
```

#### MessagingPort
```typescript
interface MessagingPort {
  requestPermission(): Promise<string>;
  onMessage(callback: (payload: any) => void): () => void;
  subscribeToTopic(topic: string): Promise<void>;
}
```

## Firebase Services

### Authentication

- Email/Password authentication
- Google Sign-In
- OAuth providers
- Anonymous auth
- Custom tokens

### Firestore Database

- NoSQL document database
- Real-time updates
- Offline support
- Security rules for access control
- Composite indexes for complex queries

### Cloud Functions

- HTTP functions for APIs
- Firestore triggers for data events
- Scheduled functions for cron jobs
- Callable functions for client calls
- Auth triggers for user events

### Storage

- File uploads and downloads
- Secure access rules
- CDN-backed delivery
- Image optimization (optional)

### Cloud Messaging

- Push notifications
- Topic-based messaging
- Device group messaging
- Message scheduling

### Hosting

- Static site hosting
- Automatic SSL
- CDN distribution
- URL rewrites
- Custom domains

## Environment Management

### Development Environment

- `.env.development` for local development
- Firebase dev project
- Local emulators (optional)
- Development Firebase credentials

### Production Environment

- `.env.production` for production builds
- Firebase prod project
- Production Firebase credentials
- Stricter security rules

## Security

### Client-Side Security

- Firebase Auth for user authentication
- Firestore security rules for data access
- Input validation and sanitization
- HTTPS-only communication

### Server-Side Security

- Firebase Admin SDK with elevated permissions
- API route authentication
- Rate limiting (implement as needed)
- CORS configuration

### Best Practices

- Never expose admin credentials
- Use security rules for all Firestore collections
- Validate all user inputs
- Implement proper error handling
- Use environment variables for secrets
- Enable Firebase App Check

## Performance

### Optimization Strategies

- Static generation where possible
- Dynamic imports for code splitting
- Image optimization
- Lazy loading components
- Caching strategies
- Firebase query optimization

### Monitoring

- Firebase Performance Monitoring
- Firebase Analytics
- Error tracking
- Cloud Functions monitoring
- Hosting metrics

## Testing Strategy

### Architecture Tests

Validates adherence to hexagonal architecture principles:

```typescript
// __tests__/architecture/dependency-rules.test.ts
// Ensures domain layer has no dependencies on adapters
// Ensures adapters depend only on ports, not concrete implementations
// Validates unidirectional dependency flow
```

### Unit Tests

- Test domain logic in isolation
- Test use cases with mocked ports
- Test utility functions
- Mock BAAS adapters in tests

### Integration Tests

- Test adapter implementations
- Test use cases with real adapters (test environment)
- Test authentication flows
- Test data operations

### End-to-End Tests

- Test user flows
- Test complete feature scenarios
- Test error handling
- Test across different BAAS providers (if applicable)

## Deployment

### Build Process

1. Install dependencies
2. Run type checking
3. Run linting
4. Run tests
5. Build Next.js app
6. Build Cloud Functions

### Deployment Process

1. Deploy security rules
2. Deploy indexes
3. Deploy Cloud Functions
4. Deploy hosting (static export)
5. Verify deployment

### CI/CD

- GitHub Actions for automated testing
- Automated deployments on merge
- Environment-specific deployments
- Rollback capability

## Scalability Considerations

### Architecture Scalability

- **Provider Independence**: Switch BAAS providers without changing business logic
- **Adapter Pattern**: Add new adapters for new providers
- **Port Interfaces**: Standardized contracts enable interoperability
- **Domain Isolation**: Business logic can scale independently

### Database

- Denormalize data where appropriate
- Use subcollections for nested data
- Implement pagination
- Cache frequently accessed data
- Use composite indexes wisely

### Functions

- Keep functions small and focused
- Use connection pooling
- Implement retry logic
- Monitor cold starts
- Optimize bundle size

### Frontend

- Code splitting by route
- Lazy load heavy components
- Implement virtual scrolling
- Optimize images and assets
- Use service workers (PWA)

## Future Enhancements

- PWA support
- Internationalization (i18n)
- Advanced caching strategies
- Background sync
- Offline-first architecture
- GraphQL layer (optional)
- Server-side rendering (optional)
- Edge functions (optional)

## References

- [Next.js Documentation](https://nextjs.org/docs)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)
- [TypeScript Documentation](https://www.typescriptlang.org/docs)

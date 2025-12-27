# Architecture Overview

This document describes the **Hexagonal Architecture** (Ports and Adapters) implementation of the Firebase SSR template with **Context-Aware Adapter Pattern** for Server-Side Rendering.

## Architecture Philosophy

This template follows **Hexagonal Architecture** principles enhanced for SSR:

- **BAAS Provider Independence**: Seamlessly switch between Firebase, AWS Amplify, Supabase
- **SSR Compatibility**: Dual adapters (client/server) with automatic context detection
- **Testability**: Core business logic isolated from external dependencies
- **Maintainability**: Clear separation of concerns with defined boundaries
- **Extensibility**: Easy to add new features and integrations

## SSR-Specific Architecture Innovation

### Context-Aware Adapter Pattern

The key innovation is the **context-aware adapter factory** that automatically selects the appropriate adapter based on execution context:

```typescript
// Automatically detects server vs client
export function getExecutionContext(): ExecutionContext {
  return typeof window === "undefined" ? "server" : "client";
}

// Returns server adapter on server, client adapter in browser
export function getAuthAdapter(): AuthPort {
  const context = getExecutionContext();
  return context === "server"
    ? new FirebaseAuthServerAdapter()
    : new FirebaseAuthClientAdapter();
}
```

### Dual Adapter Implementation

**Client Adapters** (`src/adapters/baas/firebase/client/`)
- Use Firebase Client SDK
- Run in the browser
- Handle authentication flows (sign in/up/out)
- Real-time subscriptions
- Push notifications

**Server Adapters** (`src/adapters/baas/firebase/server/`)
- Use Firebase Admin SDK
- Run on Node.js (server components)
- Auth token verification
- Server-side data fetching
- No real-time subscriptions

## Hexagonal Architecture Layers

### 1. Domain Layer (Core)

The innermost layer containing pure business logic:

- **Domain Models**: Pure business entities using standard JS types (Date, not Timestamp)
- **Port Interfaces**: Contracts that both client and server adapters implement
- **No Framework Dependencies**: Zero imports from React, Next.js, or Firebase

**Files**:
- `src/domain/models/user.model.ts`
- `src/domain/ports/auth.port.ts`
- `src/domain/ports/database.port.ts`
- `src/domain/ports/storage.port.ts`
- `src/domain/ports/messaging.port.ts`

### 2. Application Layer

Coordinates domain objects and implements use cases:

- **Use Cases**: Business operations (LoginUseCase, SignUpUseCase)
- **Depends Only on Domain**: No adapter or framework dependencies
- **Works in Any Context**: Same use cases work client-side and server-side

**Files**:
- `src/application/use-cases/login.use-case.ts`
- `src/application/use-cases/signup.use-case.ts`
- `src/application/use-cases/logout.use-case.ts`

### 3. Adapter Layer (SSR Dual Pattern)

Implements port interfaces for both execution contexts:

**Client Adapters**:
- `src/adapters/baas/firebase/client/firebase-auth-client.adapter.ts`
- `src/adapters/baas/firebase/client/firebase-database-client.adapter.ts`
- `src/adapters/baas/firebase/client/firebase-storage-client.adapter.ts`
- `src/adapters/baas/firebase/client/firebase-messaging-client.adapter.ts`

**Server Adapters**:
- `src/adapters/baas/firebase/server/firebase-auth-server.adapter.ts`
- `src/adapters/baas/firebase/server/firebase-database-server.adapter.ts`
- `src/adapters/baas/firebase/server/firebase-storage-server.adapter.ts`

**Context-Aware Factory**:
- `src/adapters/baas/factory.ts` - Auto-detects context and returns appropriate adapter

### 4. UI Layer

React components acting as primary adapters:

**Server Components** (no "use client"):
```typescript
export async function PostsList() {
  const posts = await fetchCollection<Post>("posts");
  return <div>{posts.map(...)}</div>;
}
```

**Client Components** ("use client"):
```typescript
"use client";
export function UserProfile() {
  const { user } = useAuth(); // Uses client adapter
  return <div>{user?.displayName}</div>;
}
```

## Tech Stack

- **Frontend**: Next.js 15 (App Router) + React 19 + TypeScript
- **Rendering**: Server-Side Rendering (SSR) + Client-Side Hydration
- **Styling**: Tailwind CSS v4
- **Backend**: Firebase (via dual adapter pattern)
  - Authentication (Client + Admin SDK)
  - Firestore Database (Client + Admin SDK)
  - Cloud Storage (Client + Admin SDK)
  - Cloud Messaging (Client SDK only)
  - Cloud Functions
  - App Hosting (Cloud Run)
- **Testing**: Jest + Architecture Tests + SSR Context Tests
- **Code Quality**: ESLint + Prettier
- **AI Assistance**: Claude Code

## Rendering Strategy: SSR with Dual Adapters

### Server-Side Rendering (SSR)
- Pages rendered on server (Node.js)
- Server components use **server adapters** (Firebase Admin SDK)
- Fast initial page load with pre-rendered HTML
- SEO-friendly

### Client-Side Hydration
- Client components use **client adapters** (Firebase Client SDK)
- Interactive features run in browser
- Real-time updates via client SDK

### Data Flow

**Server Component Data Flow**:
```
Server Component
    ↓
fetchCollection() [server utility]
    ↓
getDatabaseAdapter() [detects server context]
    ↓
FirebaseDatabaseServerAdapter
    ↓
Firebase Admin SDK
```

**Client Component Data Flow**:
```
Client Component
    ↓
useFirestore() [client hook]
    ↓
getDatabaseAdapter() [detects client context]
    ↓
FirebaseDatabaseClientAdapter
    ↓
Firebase Client SDK
```

## Directory Structure (SSR Hexagonal Architecture)

```
firebase-ssr-template/
├── .claude/                      # Claude Code configuration
├── functions/                    # Firebase Cloud Functions
│   └── src/index.ts
├── public/                       # Static assets
├── src/
│   ├── app/                     # Next.js App Router (SSR)
│   │   ├── layout.tsx           # Root layout
│   │   └── page.tsx             # Home page (server component)
│   │
│   ├── domain/                  # ✅ DOMAIN LAYER (Pure)
│   │   ├── models/
│   │   │   └── user.model.ts   # Pure business entities
│   │   └── ports/
│   │       ├── auth.port.ts     # Port interfaces
│   │       ├── database.port.ts
│   │       ├── storage.port.ts
│   │       └── messaging.port.ts
│   │
│   ├── application/             # ✅ APPLICATION LAYER
│   │   └── use-cases/
│   │       ├── login.use-case.ts
│   │       ├── signup.use-case.ts
│   │       └── logout.use-case.ts
│   │
│   ├── adapters/                # ✅ ADAPTER LAYER (SSR Dual Pattern)
│   │   └── baas/
│   │       ├── factory.ts       # 🔑 Context-aware factory
│   │       └── firebase/
│   │           ├── client/      # Browser adapters
│   │           │   ├── firebase-auth-client.adapter.ts
│   │           │   ├── firebase-database-client.adapter.ts
│   │           │   ├── firebase-storage-client.adapter.ts
│   │           │   └── firebase-messaging-client.adapter.ts
│   │           └── server/      # Node.js adapters
│   │               ├── firebase-auth-server.adapter.ts
│   │               ├── firebase-database-server.adapter.ts
│   │               └── firebase-storage-server.adapter.ts
│   │
│   ├── components/              # UI Components (Primary Adapters)
│   │   ├── ui/                  # Reusable UI (client components)
│   │   │   ├── button.tsx
│   │   │   ├── input.tsx
│   │   │   ├── card.tsx
│   │   │   ├── toast.tsx
│   │   │   ├── loading.tsx
│   │   │   └── error-boundary.tsx
│   │   ├── auth/                # Auth components (client)
│   │   │   ├── sign-in-form.tsx
│   │   │   ├── sign-up-form.tsx
│   │   │   └── protected-route.tsx
│   │   └── layout/
│   │       └── navbar.tsx
│   │
│   ├── hooks/                   # Client-side hooks
│   │   ├── useAuth.ts          # Auth state subscription
│   │   └── useFirestore.ts     # Real-time data subscriptions
│   │
│   ├── lib/
│   │   ├── firebase-client.ts   # Client SDK initialization
│   │   ├── firebase-admin.ts    # Admin SDK initialization
│   │   ├── server-data.ts       # 🔑 Server utilities
│   │   ├── env.ts              # Environment validation
│   │   └── utils.ts            # Shared utilities
│   │
│   └── types/                   # TypeScript definitions
│       └── index.ts
│
├── __tests__/                   # Architecture tests
│   └── architecture/
│       ├── dependency-rules.test.ts
│       └── adapter-compliance.test.ts
│
├── firebase.json                # Firebase configuration
├── firestore.rules             # Firestore security rules
├── firestore.indexes.json      # Firestore indexes
├── .firebaserc                 # Firebase project aliases
├── next.config.ts              # Next.js configuration (SSR)
├── tsconfig.json               # TypeScript configuration
├── jest.config.js              # Jest configuration
├── tailwind.config.ts          # Tailwind configuration
├── package.json                # Dependencies
├── ARCHITECTURE.md             # This file
├── BAAS_CONFIGURATION.md       # Provider switching guide
└── CLAUDE.md                   # AI assistant guidelines
```

## Key Architectural Patterns

### 1. Context-Aware Adapter Selection

Automatic detection of execution environment:

```typescript
// In factory.ts
export function getExecutionContext(): ExecutionContext {
  return typeof window === "undefined" ? "server" : "client";
}
```

**Benefits**:
- No manual configuration needed
- Same code works in server and client
- Impossible to use wrong adapter in wrong context

### 2. Server Utilities for Server Components

Helper functions for server components:

```typescript
// src/lib/server-data.ts
export async function fetchCollection<T>(
  collection: string,
  queries?: Query[]
): Promise<T[]> {
  const dbAdapter = getDatabaseAdapter<T>(); // Returns server adapter
  return await dbAdapter.findMany(collection, queries);
}
```

**Usage**:
```typescript
// Server component
export async function PostsList() {
  const posts = await fetchCollection<Post>("posts");
  return <div>{posts.map(post => ...)}</div>;
}
```

### 3. Client Hooks for Client Components

React hooks wrap client adapters:

```typescript
// src/hooks/useAuth.ts
"use client";
export function useAuth() {
  const [user, setUser] = useState<User | null>(null);

  useEffect(() => {
    const authAdapter = getAuthAdapter(); // Returns client adapter
    const unsubscribe = authAdapter.onAuthStateChanged(setUser);
    return unsubscribe;
  }, []);

  return { user, loading };
}
```

### 4. Type Mapping in Adapters

Adapters handle type conversions between Firebase and domain:

**Client Adapter**:
```typescript
// Firebase metadata.creationTime (string) → Date
createdAt: new Date(firebaseUser.metadata.creationTime)
```

**Server Adapter**:
```typescript
// Firestore Timestamp → Date
if (value instanceof admin.firestore.Timestamp) {
  mapped[key] = value.toDate();
}
```

## Adding Features

### Adding a New Server Component

```typescript
// 1. Create server component (no "use client")
export async function UserList() {
  // 2. Use server utilities
  const users = await fetchCollection<User>("users");

  // 3. Render
  return <div>{users.map(...)}</div>;
}
```

### Adding a New Client Component

```typescript
// 1. Mark as client component
"use client";

// 2. Use hooks
export function Dashboard() {
  const { user } = useAuth();
  const { data: posts } = useFirestore<Post>("posts");

  // 3. Render
  return <div>...</div>;
}
```

### Adding a New Port & Adapters

```typescript
// 1. Define port in domain/ports
export interface NotificationPort {
  send(userId: string, message: string): Promise<void>;
}

// 2. Implement client adapter
export class FirebaseNotificationClientAdapter implements NotificationPort {
  async send(userId: string, message: string) {
    // Use client SDK
  }
}

// 3. Implement server adapter
export class FirebaseNotificationServerAdapter implements NotificationPort {
  async send(userId: string, message: string) {
    // Use admin SDK
  }
}

// 4. Update factory
export function createNotificationAdapter(config?: BaasConfig): NotificationPort {
  const context = getExecutionContext();
  return context === "server"
    ? new FirebaseNotificationServerAdapter()
    : new FirebaseNotificationClientAdapter();
}
```

## Testing Strategy

### Architecture Tests

Validate hexagonal architecture compliance:

```bash
npm run test:architecture
```

Tests verify:
- Domain layer has no adapter/framework imports
- Application layer has no adapter imports
- Adapters implement port interfaces
- Components use factory, not direct imports
- Context detection works correctly

### SSR-Specific Tests

```typescript
it("server adapter throws error for client-only operations", () => {
  const adapter = new FirebaseAuthServerAdapter();

  expect(() => adapter.signIn(...)).toThrow("client-side adapter");
});

it("factory returns server adapter in server context", () => {
  // In Node.js (tests), should return server adapter
  const adapter = getAuthAdapter();
  expect(adapter).toBeInstanceOf(FirebaseAuthServerAdapter);
});
```

## Deployment

### Firebase App Hosting (Cloud Run)

This template deploys to Firebase App Hosting which uses Cloud Run for SSR:

```bash
# Development
npm run deploy:dev

# Production
npm run deploy:prod
```

**Deployment Flow**:
1. Build Next.js app with SSR support
2. Upload to Firebase App Hosting
3. Deploy to Cloud Run
4. Configure domain and routing

## Migration from CSR to SSR

Key differences when migrating from CSR template:

| Aspect | CSR Template | SSR Template |
|--------|-------------|--------------|
| Rendering | Static export | Server-side + Client |
| Adapters | Single set (client) | Dual (client + server) |
| Factory | Simple | Context-aware |
| Data Fetching | Hooks only | Hooks (client) + Utilities (server) |
| Firebase SDK | Client only | Client + Admin |
| Deployment | Static hosting | Cloud Run (App Hosting) |

## Best Practices

### DO ✅

- Let factory auto-detect context
- Use `fetchCollection()` in server components
- Use `useFirestore()` in client components
- Keep domain models pure (standard JS types)
- Map types in adapters, not domain
- Test architecture compliance regularly

### DON'T ❌

- Manually specify context in factory calls
- Use hooks in server components
- Import adapters directly (use factory)
- Put Firebase types in domain models
- Mix client and server SDK imports
- Bypass adapter pattern

## Resources

- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Next.js SSR](https://nextjs.org/docs/app/building-your-application/rendering/server-components)
- [Firebase Admin SDK](https://firebase.google.com/docs/admin/setup)
- [BAAS_CONFIGURATION.md](./BAAS_CONFIGURATION.md) - Provider switching guide
- [CLAUDE.md](./CLAUDE.md) - AI assistant guidelines

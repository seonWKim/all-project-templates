# CLAUDE.md - Architectural Guidelines

Quick reference for AI assistants maintaining hexagonal architecture and BAAS abstraction.

## Architecture Rules

**Golden Rule**: Dependencies flow inward → Domain never depends on adapters/frameworks.

**Layers**:

- **Domain** (`src/domain/`): Pure business logic, port interfaces
- **Application** (`src/application/`): Use cases, orchestration
- **Adapters** (`src/adapters/`): BAAS implementations (Firebase/AWS/Supabase)
- **UI** (`src/app/`, `src/components/`): React components

## Key Decisions

### 1. Port-Adapter Pattern for BAAS

- Define ports in `src/domain/ports/`
- Implement adapters in `src/adapters/baas/{provider}/`
- Factory switches providers via env var

### 2. BAAS-Independent Domain Models

- Domain models use standard types (Date, not Timestamp)
- Adapters map between domain and BAAS schemas

### 3. Use Cases Coordinate Logic

- Each use case = single business operation
- Depend on ports, not concrete implementations

### 4. Components Are Primary Adapters

- Call use cases or adapters via factory
- Keep thin - delegate to use cases

## Adding Features

```typescript
// 1. Domain model
export interface Post {
  id: string;
  title: string;
  authorId: string;
}

// 2. Port interface
export interface PostPort {
  create(post: Omit<Post, "id">): Promise<Post>;
  findById(id: string): Promise<Post | null>;
}

// 3. Use case
export class CreatePostUseCase {
  constructor(private postPort: PostPort) {}
  async execute(data: CreatePostDTO): Promise<Post> {
    return this.postPort.create(data);
  }
}

// 4. Adapter
export class FirebasePostAdapter implements PostPort {
  async create(post: Omit<Post, "id">): Promise<Post> {
    // Firebase implementation
  }
}

// 5. Component
const createPost = useCreatePost(); // Hook wraps use case
```

## Common Mistakes

❌ **Direct Firebase imports in components**

```typescript
import { signInWithEmailAndPassword } from "firebase/auth";
```

✅ **Use adapter factory**

```typescript
import { getAuthAdapter } from "@/adapters/baas/factory";
const auth = getAuthAdapter();
```

❌ **Business logic in components**

```typescript
const handleSubmit = async data => {
  // validation, business rules here...
  await addDoc(collection(db, "posts"), data);
};
```

✅ **Delegate to use case**

```typescript
const createPost = useCreatePost();
const handleSubmit = async data => {
  await createPost.execute(data);
};
```

❌ **Firebase types in domain**

```typescript
import { Timestamp } from "firebase/firestore";
interface User {
  createdAt: Timestamp;
}
```

✅ **Standard types**

```typescript
interface User {
  createdAt: Date;
}
// Adapter maps Timestamp ↔ Date
```

## Directory Rules

**Domain** - No imports from:

- adapters, application, components, frameworks (react, firebase, aws)

**Application** - No imports from:

- adapters, components

**Adapters** - Imports allowed:

- domain (ports), application, BAAS SDKs

**Components** - Imports allowed:

- domain, application, hooks (no direct adapter imports except factory)

## Quick Commands

```bash
npm test                    # All tests
npm test -- architecture    # Architecture tests only
npm run type-check          # TypeScript
npm run lint                # ESLint
```

## Maintenance

**Adding BAAS providers**:

1. Implement adapters in `src/adapters/baas/{provider}/`
2. Register in factory (`src/adapters/baas/factory.ts`)
3. Add env vars, update docs

**Reviewing PRs**:

- [ ] No domain imports from adapters
- [ ] Adapters implement port interfaces
- [ ] Business logic in use cases, not components
- [ ] Architecture tests pass

## Resources

- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [ARCHITECTURE.md](./ARCHITECTURE.md) - Detailed design
- [BAAS_CONFIGURATION.md](./BAAS_CONFIGURATION.md) - Provider setup

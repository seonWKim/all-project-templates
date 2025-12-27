# CLAUDE.md - Architectural Guidelines for AI Assistants

This document provides guidelines and recommendations for AI assistants (like Claude) working on this codebase to maintain architectural integrity.

## Core Architectural Principles

### 1. Hexagonal Architecture (Ports and Adapters)

This project follows hexagonal architecture to achieve clean separation of concerns:

- **Domain Layer**: Contains pure business logic, no external dependencies
- **Application Layer**: Orchestrates use cases
- **Adapter Layer**: Implements external integrations (BAAS, UI, etc.)
- **Infrastructure Layer**: Framework-specific code

**Golden Rule**: Dependencies flow inward. Domain never depends on adapters.

### 2. Backend-as-a-Service (BAAS) Abstraction

The architecture is designed to be BAAS-agnostic:

- All BAAS interactions go through **port interfaces**
- Current implementation uses **Firebase adapters**
- Can switch to AWS, Supabase, or custom backends without changing business logic

## Key Architectural Decisions

### Decision 1: Port-Adapter Pattern for BAAS

**Rationale**: Enable seamless switching between BAAS providers (Firebase, AWS, Supabase)

**Implementation**:
- Define port interfaces in `src/domain/ports/`
- Implement adapters in `src/adapters/baas/{provider}/`
- Use factory pattern to instantiate correct adapter

**When adding new features**:
1. Define the port interface first
2. Implement the adapter for current BAAS
3. Use the port in application/domain layers

### Decision 2: Domain Models are BAAS-Independent

**Rationale**: Business entities should not be coupled to database schemas

**Implementation**:
- Domain models in `src/domain/models/` are pure TypeScript interfaces
- Adapters handle mapping between domain models and BAAS schemas
- Never import BAAS SDKs in domain layer

**When creating new models**:
1. Define in domain layer with business properties only
2. Create mapper functions in adapters for BAAS-specific transformations

### Decision 3: Use Cases Coordinate Business Logic

**Rationale**: Centralize application logic in testable, reusable use cases

**Implementation**:
- Use cases in `src/application/use-cases/`
- Use cases depend on ports, not concrete implementations
- Each use case represents a single business operation

**When adding new features**:
1. Create a use case that orchestrates the operation
2. Inject required ports via constructor
3. Keep use cases framework-agnostic

### Decision 4: React Components are Primary Adapters

**Rationale**: UI is just another adapter to the business logic

**Implementation**:
- Components call use cases, not BAAS SDKs directly
- Keep components thin - delegate to use cases
- Use custom hooks to bridge React and use cases

**When creating new components**:
1. Import use cases, not adapters
2. Handle UI concerns only (rendering, events)
3. Delegate business logic to use cases

### Decision 5: Architectural Tests Enforce Boundaries

**Rationale**: Prevent architectural violations automatically

**Implementation**:
- Tests in `__tests__/architecture/`
- Validate dependency directions
- Ensure no circular dependencies
- Check that domain has no adapter imports

**Before committing code**:
1. Run `npm test` to validate architecture
2. Fix any architectural violations
3. Update architectural tests if architecture evolves legitimately

## Directory Structure Guidelines

### Domain Layer (`src/domain/`)

**Purpose**: Core business logic, completely independent

**What belongs here**:
- Domain models (User, Post, Order, etc.)
- Port interfaces (AuthPort, DatabasePort, etc.)
- Domain services (business rules)
- Domain events
- Value objects

**What does NOT belong here**:
- Framework imports (React, Next.js)
- BAAS SDK imports (Firebase, AWS)
- HTTP libraries
- UI components

### Application Layer (`src/application/`)

**Purpose**: Use cases and application services

**What belongs here**:
- Use cases (LoginUseCase, CreatePostUseCase)
- Application services
- DTOs (Data Transfer Objects)
- Application events

**What does NOT belong here**:
- UI components
- Direct BAAS SDK usage
- Framework-specific code

### Adapter Layer (`src/adapters/`)

**Purpose**: Connect external world to business logic

**What belongs here**:
- BAAS adapters (Firebase, AWS, Supabase implementations)
- HTTP clients
- External service integrations
- Mapper functions (domain ↔ external)

**Structure**:
```
adapters/
├── baas/
│   ├── firebase/
│   │   ├── firebase-auth.adapter.ts
│   │   ├── firebase-database.adapter.ts
│   │   └── firebase-storage.adapter.ts
│   ├── aws/
│   ├── supabase/
│   └── factory.ts  # Creates appropriate adapter
└── storage/
```

### Components (`src/app/`, `src/components/`)

**Purpose**: UI layer (primary adapters)

**What belongs here**:
- React components
- Next.js pages
- UI logic (rendering, events)
- Custom hooks (using use cases)

**Best practices**:
- Import use cases, not adapters
- Keep components presentational
- Extract logic to use cases or hooks

## Code Patterns

### Pattern 1: Creating a New Feature

```typescript
// 1. Define domain model
// src/domain/models/post.model.ts
export interface Post {
  id: string;
  title: string;
  content: string;
  authorId: string;
  createdAt: Date;
}

// 2. Define port interface
// src/domain/ports/post.port.ts
export interface PostPort {
  create(post: Omit<Post, 'id'>): Promise<Post>;
  findById(id: string): Promise<Post | null>;
  findByAuthor(authorId: string): Promise<Post[]>;
}

// 3. Create use case
// src/application/use-cases/create-post.use-case.ts
export class CreatePostUseCase {
  constructor(private postPort: PostPort) {}
  
  async execute(data: CreatePostDTO): Promise<Post> {
    // Validate
    // Business logic
    return this.postPort.create(data);
  }
}

// 4. Implement adapter
// src/adapters/baas/firebase/firebase-post.adapter.ts
export class FirebasePostAdapter implements PostPort {
  async create(post: Omit<Post, 'id'>): Promise<Post> {
    // Firebase-specific implementation
  }
  // ... other methods
}

// 5. Use in component
// src/app/posts/create/page.tsx
export default function CreatePostPage() {
  const createPost = useCreatePost(); // Hook wraps use case
  // UI logic
}
```

### Pattern 2: Switching BAAS Providers

```typescript
// src/lib/config.ts
export const config = {
  baasProvider: process.env.NEXT_PUBLIC_BAAS_PROVIDER || 'firebase'
};

// src/adapters/baas/factory.ts
export function createAuthAdapter(): AuthPort {
  switch(config.baasProvider) {
    case 'firebase':
      return new FirebaseAuthAdapter();
    case 'aws':
      return new AWSAuthAdapter();
    case 'supabase':
      return new SupabaseAuthAdapter();
    default:
      throw new Error('Unknown BAAS provider');
  }
}

// Use in application
const authAdapter = createAuthAdapter();
const loginUseCase = new LoginUseCase(authAdapter);
```

### Pattern 3: Testing with Architecture

```typescript
// __tests__/architecture/dependency-rules.test.ts
describe('Architecture Rules', () => {
  it('domain layer should not import from adapters', () => {
    // Use dependency cruiser or similar
    const domainFiles = getDomainFiles();
    domainFiles.forEach(file => {
      expect(file).not.toImportFrom('adapters');
    });
  });
  
  it('adapters should implement port interfaces', () => {
    // Validate all adapters implement correct interfaces
  });
});
```

## Common Pitfalls and How to Avoid Them

### ❌ Pitfall 1: Importing Firebase Directly in Components

**Bad**:
```typescript
// components/UserProfile.tsx
import { auth, db } from '@/lib/firebase';

function UserProfile() {
  const user = await auth.currentUser;
  // ...
}
```

**Good**:
```typescript
// components/UserProfile.tsx
function UserProfile() {
  const { user } = useAuth(); // Hook uses AuthPort
  // ...
}
```

### ❌ Pitfall 2: Business Logic in Components

**Bad**:
```typescript
function CreatePost() {
  const handleSubmit = async (data) => {
    // Validation logic
    // Business rules
    const docRef = await addDoc(collection(db, 'posts'), data);
  };
}
```

**Good**:
```typescript
function CreatePost() {
  const createPost = useCreatePost(); // Use case handles logic
  
  const handleSubmit = async (data) => {
    await createPost.execute(data);
  };
}
```

### ❌ Pitfall 3: Domain Models Tied to BAAS Schema

**Bad**:
```typescript
// domain/models/user.model.ts
import { Timestamp } from 'firebase/firestore';

interface User {
  id: string;
  createdAt: Timestamp; // Firebase-specific!
}
```

**Good**:
```typescript
// domain/models/user.model.ts
interface User {
  id: string;
  createdAt: Date; // Standard JavaScript
}

// adapters/baas/firebase/mappers/user.mapper.ts
function toDomain(firestoreUser: any): User {
  return {
    id: firestoreUser.id,
    createdAt: firestoreUser.createdAt.toDate()
  };
}
```

### ❌ Pitfall 4: Skipping Port Interfaces

**Bad**:
```typescript
// application/use-cases/login.use-case.ts
import { FirebaseAuthAdapter } from '@/adapters/baas/firebase';

class LoginUseCase {
  constructor(private auth: FirebaseAuthAdapter) {} // Concrete!
}
```

**Good**:
```typescript
// application/use-cases/login.use-case.ts
import { AuthPort } from '@/domain/ports';

class LoginUseCase {
  constructor(private auth: AuthPort) {} // Interface!
}
```

## Maintenance Guidelines

### When Adding New Dependencies

1. **Evaluate Impact**: Does this affect domain layer? (It shouldn't)
2. **Adapter Placement**: Add BAAS-specific deps to adapter folders only
3. **Update Tests**: Add architectural tests if needed

### When Refactoring

1. **Check Architecture Tests**: Ensure they still pass
2. **Maintain Boundaries**: Don't introduce new dependencies across layers
3. **Update Documentation**: Update ARCHITECTURE.md if structure changes

### When Reviewing Pull Requests

Use the PR template checklist to verify:
- [ ] No domain layer dependencies on adapters
- [ ] Port interfaces used instead of concrete implementations
- [ ] New adapters implement required ports
- [ ] Architectural tests pass
- [ ] Business logic in use cases, not components

## AI Assistant Best Practices

### Before Making Changes

1. **Understand the Layer**: Identify which architectural layer you're working in
2. **Check Dependencies**: Ensure you're not violating dependency rules
3. **Review Patterns**: Follow established patterns in similar code

### When Implementing Features

1. **Start with Domain**: Define models and ports first
2. **Implement Use Cases**: Add application logic
3. **Create Adapters**: Implement external integrations
4. **Build UI**: Create components using use cases

### When Debugging

1. **Isolate Layer**: Determine which layer has the issue
2. **Test Ports**: Verify adapter implementations match port contracts
3. **Check Mappings**: Ensure data transformations are correct

### When Uncertain

1. **Ask Questions**: Request clarification on architectural decisions
2. **Propose Alternatives**: Suggest improvements with rationale
3. **Document Decisions**: Update this file with new patterns

## Quick Reference

### Import Rules

```typescript
// ✅ Allowed
// domain can import: domain
// application can import: domain
// adapters can import: domain, application
// components can import: domain, application, hooks

// ❌ Not Allowed
// domain importing: adapters, components, framework
// application importing: adapters, components
// components importing: adapters directly
```

### File Naming Conventions

```
Domain Models:     user.model.ts
Port Interfaces:   auth.port.ts
Use Cases:         login.use-case.ts
Adapters:          firebase-auth.adapter.ts
Mappers:           user.mapper.ts
Tests:             *.test.ts
Arch Tests:        dependency-rules.test.ts
```

### Key Commands

```bash
# Validate architecture
npm test

# Type check
npm run type-check

# Lint
npm run lint

# Run architectural tests only
npm test -- architecture
```

## Version History

- **v1.0** (2025-12-27): Initial hexagonal architecture specification
  - Added port-adapter pattern
  - Defined BAAS abstraction layer
  - Created architectural guidelines

## Further Reading

- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Ports and Adapters Pattern](https://herbertograca.com/2017/09/14/ports-adapters-architecture/)
- [Clean Architecture by Robert C. Martin](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Domain-Driven Design](https://martinfowler.com/bliki/DomainDrivenDesign.html)

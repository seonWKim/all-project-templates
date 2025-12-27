# BAAS Provider Configuration Guide

This guide explains how to configure and switch between different Backend-as-a-Service (BAAS) providers in the Firebase CSR template.

## Supported Providers

- **Firebase** (Default) - Fully implemented
- **AWS Amplify** - Planned (requires implementation)
- **Supabase** - Planned (requires implementation)
- **Custom** - Extensible for any provider

## Current Configuration

The BAAS provider is configured via environment variables:

```bash
# .env.development or .env.production
NEXT_PUBLIC_BAAS_PROVIDER=firebase
```

## Firebase Configuration (Current Default)

Firebase is the default and currently implemented BAAS provider.

### Environment Variables

```bash
NEXT_PUBLIC_FIREBASE_API_KEY=your-api-key
NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN=your-project.firebaseapp.com
NEXT_PUBLIC_FIREBASE_PROJECT_ID=your-project-id
NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET=your-project.appspot.com
NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID=123456789
NEXT_PUBLIC_FIREBASE_APP_ID=1:123456789:web:abcdef
NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID=G-XXXXXXXXXX
```

## How to Switch BAAS Providers

### Step 1: Set Environment Variable

```bash
# For AWS Amplify (once implemented)
NEXT_PUBLIC_BAAS_PROVIDER=aws

# For Supabase (once implemented)
NEXT_PUBLIC_BAAS_PROVIDER=supabase
```

### Step 2: Implement the Adapter

Create adapter files in `src/adapters/baas/{provider}/`:

```typescript
// src/adapters/baas/aws/aws-auth.adapter.ts
import { AuthPort } from "@/domain/ports";

export class AWSAuthAdapter implements AuthPort {
  // Implement all AuthPort methods using AWS SDK
  async signIn(credentials: UserCredentials): Promise<User> {
    // AWS Cognito implementation
  }
  // ... other methods
}
```

### Step 3: Register in Factory

Update `src/adapters/baas/factory.ts`:

```typescript
import { AWSAuthAdapter } from "./aws/aws-auth.adapter";

export function createAuthAdapter(config?: BaasConfig): AuthPort {
  const baasConfig = config || getBaasConfig();

  switch (baasConfig.provider) {
    case "firebase":
      return new FirebaseAuthAdapter();
    case "aws":
      return new AWSAuthAdapter(); // Add this
    case "supabase":
      throw new Error("Supabase adapter not yet implemented");
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}
```

### Step 4: Install Provider SDK

```bash
# For AWS
npm install aws-amplify @aws-amplify/auth

# For Supabase
npm install @supabase/supabase-js
```

### Step 5: Configure Provider Credentials

Add provider-specific environment variables:

```bash
# For AWS
NEXT_PUBLIC_AWS_REGION=us-east-1
NEXT_PUBLIC_AWS_USER_POOL_ID=us-east-1_ABC123
NEXT_PUBLIC_AWS_USER_POOL_CLIENT_ID=abcdef123456

# For Supabase
NEXT_PUBLIC_SUPABASE_URL=https://your-project.supabase.co
NEXT_PUBLIC_SUPABASE_ANON_KEY=your-anon-key
```

## Architecture Benefits

### 1. Zero Business Logic Changes

Your business logic (use cases, domain models) remain unchanged when switching providers:

```typescript
// This code works with ANY provider
const loginUseCase = new LoginUseCase(getAuthAdapter());
await loginUseCase.execute({ email, password });
```

### 2. Easy Testing

Mock the port interface instead of the actual provider:

```typescript
const mockAuthPort: AuthPort = {
  signIn: jest.fn().mockResolvedValue(mockUser),
  // ... other methods
};

const useCase = new LoginUseCase(mockAuthPort);
```

### 3. Gradual Migration

Switch providers incrementally:

- Start with Firebase
- Implement AWS adapters
- Test in parallel
- Switch via environment variable

## Example: Implementing AWS Adapter

Here's a complete example of implementing an AWS Amplify authentication adapter:

```typescript
// src/adapters/baas/aws/aws-auth.adapter.ts
import { Auth } from "aws-amplify";
import { AuthPort } from "@/domain/ports";
import { User, UserCredentials } from "@/domain/models/user.model";

export class AWSAuthAdapter implements AuthPort {
  async signIn(credentials: UserCredentials): Promise<User> {
    const cognitoUser = await Auth.signIn(
      credentials.email,
      credentials.password
    );
    return this.mapCognitoUserToDomain(cognitoUser);
  }

  async signUp(credentials: UserCredentials): Promise<User> {
    const result = await Auth.signUp({
      username: credentials.email,
      password: credentials.password,
    });
    return this.mapCognitoUserToDomain(result.user);
  }

  async signOut(): Promise<void> {
    await Auth.signOut();
  }

  async getCurrentUser(): Promise<User | null> {
    try {
      const cognitoUser = await Auth.currentAuthenticatedUser();
      return this.mapCognitoUserToDomain(cognitoUser);
    } catch {
      return null;
    }
  }

  onAuthStateChanged(callback: (user: User | null) => void): () => void {
    const hubListener = (data: any) => {
      switch (data.payload.event) {
        case "signIn":
        case "signOut":
          this.getCurrentUser().then(callback);
          break;
      }
    };

    Hub.listen("auth", hubListener);

    return () => Hub.remove("auth", hubListener);
  }

  async sendPasswordResetEmail(email: string): Promise<void> {
    await Auth.forgotPassword(email);
  }

  async updateProfile(userId: string, profile: any): Promise<void> {
    const user = await Auth.currentAuthenticatedUser();
    await Auth.updateUserAttributes(user, profile);
  }

  async deleteAccount(userId: string): Promise<void> {
    const user = await Auth.currentAuthenticatedUser();
    await user.deleteUser();
  }

  private mapCognitoUserToDomain(cognitoUser: any): User {
    return {
      id: cognitoUser.username,
      email: cognitoUser.attributes.email,
      displayName: cognitoUser.attributes.name,
      photoURL: cognitoUser.attributes.picture,
      emailVerified: cognitoUser.attributes.email_verified,
      createdAt: new Date(cognitoUser.attributes.created_at),
      updatedAt: new Date(),
    };
  }
}
```

## Best Practices

### 1. Keep Adapters Isolated

Never let provider-specific code leak into domain or application layers:

```typescript
// ❌ BAD - Firebase in domain
import { Timestamp } from "firebase/firestore";
interface User {
  createdAt: Timestamp; // Firebase-specific!
}

// ✅ GOOD - Standard types
interface User {
  createdAt: Date; // Works with any provider
}
```

### 2. Map Provider Data to Domain Models

Always transform provider data to domain models in adapters:

```typescript
// In adapter
private mapFirebaseUserToDomain(firebaseUser: FirebaseUser): User {
  return {
    id: firebaseUser.uid,
    email: firebaseUser.email || '',
    createdAt: new Date(firebaseUser.metadata.creationTime),
    // ... map all fields
  };
}
```

### 3. Handle Provider-Specific Features

Some features may not be available in all providers:

```typescript
async subscribeToTopic(token: string, topic: string): Promise<void> {
  // Firebase: Supported via FCM
  // AWS: Supported via SNS
  // Supabase: Not supported - throw error
  throw new Error('Topic subscription not supported by this provider');
}
```

### 4. Test with Multiple Providers

Run your architectural tests to ensure compliance:

```bash
# Test with Firebase
NEXT_PUBLIC_BAAS_PROVIDER=firebase npm test

# Test with AWS (once implemented)
NEXT_PUBLIC_BAAS_PROVIDER=aws npm test
```

## Troubleshooting

### Error: "Unknown BAAS provider"

Make sure `NEXT_PUBLIC_BAAS_PROVIDER` is set in your `.env` file and the provider is registered in the factory.

### Error: "Adapter not yet implemented"

The selected provider hasn't been implemented. Either:

1. Implement the adapter following this guide
2. Switch back to Firebase (the default)

### Provider SDK initialization errors

Ensure all provider-specific environment variables are set correctly.

## Future Enhancements

- Multi-provider support (use different providers for different services)
- Provider feature detection
- Automatic fallback to alternative providers
- Provider-specific optimization strategies

## Contributing

When adding a new BAAS provider:

1. Implement all port interfaces in `src/adapters/baas/{provider}/`
2. Register in the factory (`src/adapters/baas/factory.ts`)
3. Add environment variable documentation
4. Add tests for the new adapter
5. Update this configuration guide
6. Submit a PR using the template

## Resources

- [Firebase Documentation](https://firebase.google.com/docs)
- [AWS Amplify Documentation](https://docs.amplify.aws/)
- [Supabase Documentation](https://supabase.com/docs)
- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)

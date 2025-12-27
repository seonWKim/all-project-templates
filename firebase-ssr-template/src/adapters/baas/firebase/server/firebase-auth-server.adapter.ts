/**
 * Firebase Authentication Server Adapter
 *
 * Implements AuthPort interface using Firebase Admin SDK.
 * Runs on the server (Node.js).
 *
 * Note: Server-side auth is primarily for verification.
 * Sign in/up/out operations must happen client-side.
 */

import { adminAuth } from "@/lib/firebase-admin";
import { AuthPort } from "@/domain/ports";
import { User, UserCredentials } from "@/domain/models/user.model";

export class FirebaseAuthServerAdapter implements AuthPort {
  /**
   * Verify a Firebase ID token (server-side auth verification)
   * This is a server-specific method not in the AuthPort interface
   */
  async verifyIdToken(idToken: string): Promise<User> {
    const decodedToken = await adminAuth.verifyIdToken(idToken);
    const userRecord = await adminAuth.getUser(decodedToken.uid);

    return {
      id: userRecord.uid,
      email: userRecord.email || "",
      displayName: userRecord.displayName || undefined,
      photoURL: userRecord.photoURL || undefined,
      emailVerified: userRecord.emailVerified,
      createdAt: new Date(userRecord.metadata.creationTime),
      updatedAt: new Date(
        userRecord.metadata.lastSignInTime || userRecord.metadata.creationTime
      ),
    };
  }

  /**
   * Get user by ID (server-side only)
   */
  async getUserById(userId: string): Promise<User | null> {
    try {
      const userRecord = await adminAuth.getUser(userId);
      return {
        id: userRecord.uid,
        email: userRecord.email || "",
        displayName: userRecord.displayName || undefined,
        photoURL: userRecord.photoURL || undefined,
        emailVerified: userRecord.emailVerified,
        createdAt: new Date(userRecord.metadata.creationTime),
        updatedAt: new Date(
          userRecord.metadata.lastSignInTime ||
            userRecord.metadata.creationTime
        ),
      };
    } catch (error) {
      return null;
    }
  }

  // These operations are NOT supported server-side
  // They must be performed client-side
  async signIn(_credentials: UserCredentials): Promise<User> {
    throw new Error(
      "signIn must be called from client-side adapter. Use Firebase Client SDK in the browser."
    );
  }

  async signUp(_credentials: UserCredentials): Promise<User> {
    throw new Error(
      "signUp must be called from client-side adapter. Use Firebase Client SDK in the browser."
    );
  }

  async signOut(): Promise<void> {
    throw new Error(
      "signOut must be called from client-side adapter. Use Firebase Client SDK in the browser."
    );
  }

  async getCurrentUser(): Promise<User | null> {
    throw new Error(
      "getCurrentUser must be called from client-side adapter. On the server, use verifyIdToken() or getUserById() instead."
    );
  }

  onAuthStateChanged(_callback: (user: User | null) => void): () => void {
    throw new Error(
      "onAuthStateChanged must be called from client-side adapter. Auth state subscriptions are browser-only."
    );
  }

  async sendPasswordResetEmail(_email: string): Promise<void> {
    // Could be implemented server-side via Admin SDK if needed
    throw new Error(
      "sendPasswordResetEmail should typically be called from client-side adapter."
    );
  }

  async updateProfile(
    userId: string,
    profile: { displayName?: string; photoURL?: string }
  ): Promise<void> {
    // This CAN be implemented server-side via Admin SDK
    await adminAuth.updateUser(userId, {
      displayName: profile.displayName,
      photoURL: profile.photoURL,
    });
  }

  async deleteAccount(userId: string): Promise<void> {
    // This CAN be implemented server-side via Admin SDK
    await adminAuth.deleteUser(userId);
  }
}

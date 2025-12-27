/**
 * Firebase Authentication Adapter
 *
 * Implements AuthPort interface using Firebase Authentication SDK.
 */

import {
  signInWithEmailAndPassword,
  createUserWithEmailAndPassword,
  signOut as firebaseSignOut,
  onAuthStateChanged as firebaseOnAuthStateChanged,
  sendPasswordResetEmail as firebaseSendPasswordResetEmail,
  updateProfile as firebaseUpdateProfile,
  deleteUser,
  User as FirebaseUser,
} from "firebase/auth";
import { AuthPort } from "@/domain/ports";
import { User, UserCredentials } from "@/domain/models/user.model";
import { auth } from "@/lib/firebase";

/**
 * Maps Firebase User to Domain User model
 */
function mapFirebaseUserToDomain(
  firebaseUser: FirebaseUser | null
): User | null {
  if (!firebaseUser) return null;

  return {
    id: firebaseUser.uid,
    email: firebaseUser.email || "",
    displayName: firebaseUser.displayName || undefined,
    photoURL: firebaseUser.photoURL || undefined,
    emailVerified: firebaseUser.emailVerified,
    createdAt: firebaseUser.metadata.creationTime
      ? new Date(firebaseUser.metadata.creationTime)
      : new Date(),
    updatedAt: firebaseUser.metadata.lastSignInTime
      ? new Date(firebaseUser.metadata.lastSignInTime)
      : new Date(),
  };
}

export class FirebaseAuthAdapter implements AuthPort {
  async signIn(credentials: UserCredentials): Promise<User> {
    const userCredential = await signInWithEmailAndPassword(
      auth,
      credentials.email,
      credentials.password
    );
    const user = mapFirebaseUserToDomain(userCredential.user);
    if (!user) throw new Error("Failed to sign in");
    return user;
  }

  async signUp(credentials: UserCredentials): Promise<User> {
    const userCredential = await createUserWithEmailAndPassword(
      auth,
      credentials.email,
      credentials.password
    );
    const user = mapFirebaseUserToDomain(userCredential.user);
    if (!user) throw new Error("Failed to sign up");
    return user;
  }

  async signOut(): Promise<void> {
    await firebaseSignOut(auth);
  }

  async getCurrentUser(): Promise<User | null> {
    return mapFirebaseUserToDomain(auth.currentUser);
  }

  onAuthStateChanged(callback: (user: User | null) => void): () => void {
    return firebaseOnAuthStateChanged(auth, firebaseUser => {
      const user = mapFirebaseUserToDomain(firebaseUser);
      callback(user);
    });
  }

  async sendPasswordResetEmail(email: string): Promise<void> {
    await firebaseSendPasswordResetEmail(auth, email);
  }

  async updateProfile(
    userId: string,
    profile: { displayName?: string; photoURL?: string }
  ): Promise<void> {
    const user = auth.currentUser;
    if (!user || user.uid !== userId) {
      throw new Error("User not authenticated");
    }
    await firebaseUpdateProfile(user, profile);
  }

  async deleteAccount(userId: string): Promise<void> {
    const user = auth.currentUser;
    if (!user || user.uid !== userId) {
      throw new Error("User not authenticated");
    }
    await deleteUser(user);
  }
}

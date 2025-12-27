/**
 * Port Interface: Authentication
 *
 * Defines the contract for authentication services.
 * Any BAAS provider (Firebase, AWS, Supabase, etc.) must implement this interface.
 */

import { User, UserCredentials } from "../models/user.model";

export interface AuthPort {
  /**
   * Sign in with email and password
   */
  signIn(credentials: UserCredentials): Promise<User>;

  /**
   * Sign up with email and password
   */
  signUp(credentials: UserCredentials): Promise<User>;

  /**
   * Sign out the current user
   */
  signOut(): Promise<void>;

  /**
   * Get the current authenticated user
   */
  getCurrentUser(): Promise<User | null>;

  /**
   * Subscribe to authentication state changes
   * @returns Unsubscribe function
   */
  onAuthStateChanged(callback: (user: User | null) => void): () => void;

  /**
   * Send password reset email
   */
  sendPasswordResetEmail(email: string): Promise<void>;

  /**
   * Update user profile
   */
  updateProfile(
    userId: string,
    profile: { displayName?: string; photoURL?: string }
  ): Promise<void>;

  /**
   * Delete user account
   */
  deleteAccount(userId: string): Promise<void>;
}

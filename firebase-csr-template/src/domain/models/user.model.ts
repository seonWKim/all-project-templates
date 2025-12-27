/**
 * Domain Model: User
 *
 * Pure business entity representing a user in the system.
 * No dependencies on any BAAS provider or framework.
 */
export interface User {
  id: string;
  email: string;
  displayName?: string;
  photoURL?: string;
  createdAt: Date;
  updatedAt: Date;
  emailVerified?: boolean;
}

/**
 * Credentials for authentication
 */
export interface UserCredentials {
  email: string;
  password: string;
}

/**
 * User profile data
 */
export interface UserProfile {
  displayName?: string;
  photoURL?: string;
}

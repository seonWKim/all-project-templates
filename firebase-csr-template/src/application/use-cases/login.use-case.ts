/**
 * Use Case: Login
 * 
 * Handles user authentication with email and password.
 */

import { AuthPort } from '@/domain/ports';
import { User, UserCredentials } from '@/domain/models/user.model';

export class LoginUseCase {
  constructor(private readonly authPort: AuthPort) {}

  async execute(credentials: UserCredentials): Promise<User> {
    // Validate input
    if (!credentials.email || !credentials.password) {
      throw new Error('Email and password are required');
    }

    // Validate email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(credentials.email)) {
      throw new Error('Invalid email format');
    }

    // Delegate to auth port
    return await this.authPort.signIn(credentials);
  }
}

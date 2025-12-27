/**
 * Use Case: Sign Up
 *
 * Handles user registration with email and password.
 */

import { AuthPort } from "@/domain/ports";
import { User, UserCredentials } from "@/domain/models/user.model";

export class SignUpUseCase {
  constructor(private readonly authPort: AuthPort) {}

  async execute(credentials: UserCredentials): Promise<User> {
    // Validate input
    if (!credentials.email || !credentials.password) {
      throw new Error("Email and password are required");
    }

    // Validate email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(credentials.email)) {
      throw new Error("Invalid email format");
    }

    // Validate password strength
    if (credentials.password.length < 6) {
      throw new Error("Password must be at least 6 characters");
    }

    // Delegate to auth port
    return await this.authPort.signUp(credentials);
  }
}

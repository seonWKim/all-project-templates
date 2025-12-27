/**
 * Use Case: Logout
 *
 * Handles user sign out.
 */

import { AuthPort } from "@/domain/ports";

export class LogoutUseCase {
  constructor(private readonly authPort: AuthPort) {}

  async execute(): Promise<void> {
    await this.authPort.signOut();
  }
}

/**
 * BAAS Adapter Factory (SSR-Compatible)
 *
 * Creates appropriate adapter instances based on:
 * 1. BAAS provider configuration (Firebase, AWS, Supabase, etc.)
 * 2. Execution context (client vs server)
 *
 * IMPORTANT: This factory automatically detects if code is running
 * on the server or client and returns the appropriate adapter.
 *
 * Server components → Server adapters (Firebase Admin SDK)
 * Client components → Client adapters (Firebase Client SDK)
 */

import {
  AuthPort,
  DatabasePort,
  StoragePort,
  MessagingPort,
} from "@/domain/ports";

// Client adapters
import { FirebaseAuthClientAdapter } from "./firebase/client/firebase-auth-client.adapter";
import { FirebaseDatabaseClientAdapter } from "./firebase/client/firebase-database-client.adapter";
import { FirebaseStorageClientAdapter } from "./firebase/client/firebase-storage-client.adapter";
import { FirebaseMessagingClientAdapter } from "./firebase/client/firebase-messaging-client.adapter";

// Server adapters
import { FirebaseAuthServerAdapter } from "./firebase/server/firebase-auth-server.adapter";
import { FirebaseDatabaseServerAdapter } from "./firebase/server/firebase-database-server.adapter";
import { FirebaseStorageServerAdapter } from "./firebase/server/firebase-storage-server.adapter";

/**
 * BAAS provider types
 */
export type BaasProvider = "firebase" | "aws" | "supabase";

/**
 * Execution context types
 */
export type ExecutionContext = "client" | "server";

/**
 * Configuration for BAAS provider
 */
export interface BaasConfig {
  provider: BaasProvider;
  context?: ExecutionContext; // Optional override
}

/**
 * Detect execution context
 * Returns 'server' if running on Node.js, 'client' if in browser
 */
export function getExecutionContext(): ExecutionContext {
  return typeof window === "undefined" ? "server" : "client";
}

/**
 * Get BAAS configuration from environment
 */
export function getBaasConfig(): BaasConfig {
  const provider = (process.env.NEXT_PUBLIC_BAAS_PROVIDER ||
    "firebase") as BaasProvider;
  const context = getExecutionContext();

  return {
    provider,
    context,
  };
}

/**
 * Create authentication adapter based on context
 * Returns server adapter on server, client adapter in browser
 */
export function createAuthAdapter(config?: BaasConfig): AuthPort {
  const baasConfig = config || getBaasConfig();
  const context = baasConfig.context || getExecutionContext();

  switch (baasConfig.provider) {
    case "firebase":
      return context === "server"
        ? new FirebaseAuthServerAdapter()
        : new FirebaseAuthClientAdapter();
    case "aws":
      throw new Error("AWS adapter not yet implemented");
    case "supabase":
      throw new Error("Supabase adapter not yet implemented");
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create database adapter based on context
 * Returns server adapter on server, client adapter in browser
 */
export function createDatabaseAdapter<T = Record<string, unknown>>(
  config?: BaasConfig
): DatabasePort<T> {
  const baasConfig = config || getBaasConfig();
  const context = baasConfig.context || getExecutionContext();

  switch (baasConfig.provider) {
    case "firebase":
      return context === "server"
        ? new FirebaseDatabaseServerAdapter<T>()
        : new FirebaseDatabaseClientAdapter<T>();
    case "aws":
      throw new Error("AWS adapter not yet implemented");
    case "supabase":
      throw new Error("Supabase adapter not yet implemented");
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create storage adapter based on context
 * Returns server adapter on server, client adapter in browser
 */
export function createStorageAdapter(config?: BaasConfig): StoragePort {
  const baasConfig = config || getBaasConfig();
  const context = baasConfig.context || getExecutionContext();

  switch (baasConfig.provider) {
    case "firebase":
      return context === "server"
        ? new FirebaseStorageServerAdapter()
        : new FirebaseStorageClientAdapter();
    case "aws":
      throw new Error("AWS adapter not yet implemented");
    case "supabase":
      throw new Error("Supabase adapter not yet implemented");
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create messaging adapter (CLIENT-ONLY)
 * Messaging is a browser feature, not available server-side
 */
export function createMessagingAdapter(config?: BaasConfig): MessagingPort {
  const context = getExecutionContext();

  if (context === "server") {
    throw new Error("Messaging is only available on client-side");
  }

  const baasConfig = config || getBaasConfig();

  switch (baasConfig.provider) {
    case "firebase":
      return new FirebaseMessagingClientAdapter();
    case "aws":
      throw new Error("AWS adapter not yet implemented");
    case "supabase":
      throw new Error("Supabase adapter not yet implemented");
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Singleton instances (context-aware)
 * Separate instances for client and server
 */
let clientAuthAdapter: AuthPort | null = null;
let serverAuthAdapter: AuthPort | null = null;
let clientStorageAdapter: StoragePort | null = null;
let serverStorageAdapter: StoragePort | null = null;
let messagingAdapter: MessagingPort | null = null;

/**
 * Get singleton auth adapter instance (context-aware)
 * Automatically returns server adapter on server, client adapter in browser
 */
export function getAuthAdapter(): AuthPort {
  const context = getExecutionContext();

  if (context === "server") {
    if (!serverAuthAdapter) {
      serverAuthAdapter = createAuthAdapter({
        provider: "firebase",
        context: "server",
      });
    }
    return serverAuthAdapter;
  } else {
    if (!clientAuthAdapter) {
      clientAuthAdapter = createAuthAdapter({
        provider: "firebase",
        context: "client",
      });
    }
    return clientAuthAdapter;
  }
}

/**
 * Get database adapter instance (not singleton to support multiple types)
 * Automatically returns server adapter on server, client adapter in browser
 */
export function getDatabaseAdapter<
  T = Record<string, unknown>,
>(): DatabasePort<T> {
  return createDatabaseAdapter<T>();
}

/**
 * Get singleton storage adapter instance (context-aware)
 * Automatically returns server adapter on server, client adapter in browser
 */
export function getStorageAdapter(): StoragePort {
  const context = getExecutionContext();

  if (context === "server") {
    if (!serverStorageAdapter) {
      serverStorageAdapter = createStorageAdapter({
        provider: "firebase",
        context: "server",
      });
    }
    return serverStorageAdapter;
  } else {
    if (!clientStorageAdapter) {
      clientStorageAdapter = createStorageAdapter({
        provider: "firebase",
        context: "client",
      });
    }
    return clientStorageAdapter;
  }
}

/**
 * Get singleton messaging adapter instance (CLIENT-ONLY)
 * Throws error if called on server
 */
export function getMessagingAdapter(): MessagingPort {
  if (getExecutionContext() === "server") {
    throw new Error("Messaging is only available on client-side");
  }

  if (!messagingAdapter) {
    messagingAdapter = createMessagingAdapter();
  }
  return messagingAdapter;
}

/**
 * BAAS Adapter Factory
 * 
 * Creates appropriate adapter instances based on configuration.
 * This enables switching between BAAS providers (Firebase, AWS, Supabase, etc.)
 */

import { AuthPort, DatabasePort, StoragePort, MessagingPort } from '@/domain/ports';
import { FirebaseAuthAdapter } from './firebase/firebase-auth.adapter';
import { FirebaseDatabaseAdapter } from './firebase/firebase-database.adapter';
import { FirebaseStorageAdapter } from './firebase/firebase-storage.adapter';
import { FirebaseMessagingAdapter } from './firebase/firebase-messaging.adapter';

/**
 * BAAS provider types
 */
export type BaasProvider = 'firebase' | 'aws' | 'supabase';

/**
 * Configuration for BAAS provider
 */
export interface BaasConfig {
  provider: BaasProvider;
}

/**
 * Get BAAS configuration from environment
 */
export function getBaasConfig(): BaasConfig {
  const provider = (process.env.NEXT_PUBLIC_BAAS_PROVIDER || 'firebase') as BaasProvider;
  
  return {
    provider,
  };
}

/**
 * Create authentication adapter based on configuration
 */
export function createAuthAdapter(config?: BaasConfig): AuthPort {
  const baasConfig = config || getBaasConfig();
  
  switch (baasConfig.provider) {
    case 'firebase':
      return new FirebaseAuthAdapter();
    case 'aws':
      throw new Error('AWS adapter not yet implemented');
    case 'supabase':
      throw new Error('Supabase adapter not yet implemented');
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create database adapter based on configuration
 */
export function createDatabaseAdapter<T = Record<string, unknown>>(config?: BaasConfig): DatabasePort<T> {
  const baasConfig = config || getBaasConfig();
  
  switch (baasConfig.provider) {
    case 'firebase':
      return new FirebaseDatabaseAdapter<T>();
    case 'aws':
      throw new Error('AWS adapter not yet implemented');
    case 'supabase':
      throw new Error('Supabase adapter not yet implemented');
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create storage adapter based on configuration
 */
export function createStorageAdapter(config?: BaasConfig): StoragePort {
  const baasConfig = config || getBaasConfig();
  
  switch (baasConfig.provider) {
    case 'firebase':
      return new FirebaseStorageAdapter();
    case 'aws':
      throw new Error('AWS adapter not yet implemented');
    case 'supabase':
      throw new Error('Supabase adapter not yet implemented');
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Create messaging adapter based on configuration
 */
export function createMessagingAdapter(config?: BaasConfig): MessagingPort {
  const baasConfig = config || getBaasConfig();
  
  switch (baasConfig.provider) {
    case 'firebase':
      return new FirebaseMessagingAdapter();
    case 'aws':
      throw new Error('AWS adapter not yet implemented');
    case 'supabase':
      throw new Error('Supabase adapter not yet implemented');
    default:
      throw new Error(`Unknown BAAS provider: ${baasConfig.provider}`);
  }
}

/**
 * Singleton instances for adapters
 */
let authAdapterInstance: AuthPort | null = null;
let storageAdapterInstance: StoragePort | null = null;
let messagingAdapterInstance: MessagingPort | null = null;

/**
 * Get singleton auth adapter instance
 */
export function getAuthAdapter(): AuthPort {
  if (!authAdapterInstance) {
    authAdapterInstance = createAuthAdapter();
  }
  return authAdapterInstance;
}

/**
 * Get database adapter instance (not singleton to support multiple types)
 */
export function getDatabaseAdapter<T = Record<string, unknown>>(): DatabasePort<T> {
  return createDatabaseAdapter<T>();
}

/**
 * Get singleton storage adapter instance
 */
export function getStorageAdapter(): StoragePort {
  if (!storageAdapterInstance) {
    storageAdapterInstance = createStorageAdapter();
  }
  return storageAdapterInstance;
}

/**
 * Get singleton messaging adapter instance
 */
export function getMessagingAdapter(): MessagingPort {
  if (!messagingAdapterInstance) {
    messagingAdapterInstance = createMessagingAdapter();
  }
  return messagingAdapterInstance;
}

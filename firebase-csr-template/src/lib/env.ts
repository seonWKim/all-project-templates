/**
 * Environment Variable Validation
 *
 * This file validates required environment variables at build time
 * to prevent runtime errors from missing configuration.
 */

// Required Firebase environment variables
const requiredEnvVars = [
  "NEXT_PUBLIC_FIREBASE_API_KEY",
  "NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN",
  "NEXT_PUBLIC_FIREBASE_PROJECT_ID",
  "NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET",
  "NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID",
  "NEXT_PUBLIC_FIREBASE_APP_ID",
] as const;

// Optional environment variables (for type checking)
const optionalEnvVarsList = [
  "NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID",
  "NEXT_FIREBASE_MESSAGING_VAPID",
] as const;

type RequiredEnvVar = (typeof requiredEnvVars)[number];
type OptionalEnvVar = (typeof optionalEnvVarsList)[number];
type EnvVar = RequiredEnvVar | OptionalEnvVar;

/**
 * Validates that all required environment variables are set
 * @throws Error if any required environment variable is missing
 */
export function validateEnv(): void {
  const missingVars: string[] = [];

  for (const envVar of requiredEnvVars) {
    if (!process.env[envVar]) {
      missingVars.push(envVar);
    }
  }

  if (missingVars.length > 0) {
    throw new Error(
      `Missing required environment variables:\n${missingVars.join("\n")}\n\n` +
        `Please check your .env.development or .env.production file.`
    );
  }
}

/**
 * Gets an environment variable value
 * @param key - The environment variable key
 * @param defaultValue - Optional default value if the env var is not set
 * @returns The environment variable value
 */
export function getEnv(key: EnvVar, defaultValue?: string): string {
  const value = process.env[key];

  if (
    !value &&
    !defaultValue &&
    requiredEnvVars.includes(key as RequiredEnvVar)
  ) {
    throw new Error(
      `Required environment variable ${key} is not set. ` +
        `Please check your .env.development or .env.production file.`
    );
  }

  return value || defaultValue || "";
}

/**
 * Checks if an environment variable is set
 * @param key - The environment variable key
 * @returns True if the environment variable is set
 */
export function hasEnv(key: string): boolean {
  return Boolean(process.env[key]);
}

/**
 * Gets the current environment phase
 * @returns The current phase (development, production, or unknown)
 */
export function getPhase(): "development" | "production" | "unknown" {
  const phase = process.env.PHASE || process.env.NODE_ENV;

  if (phase === "development") return "development";
  if (phase === "production") return "production";

  return "unknown";
}

/**
 * Checks if the app is running in development mode
 */
export function isDevelopment(): boolean {
  return getPhase() === "development";
}

/**
 * Checks if the app is running in production mode
 */
export function isProduction(): boolean {
  return getPhase() === "production";
}

// Validate environment variables at module load time (build time)
if (typeof window === "undefined") {
  // Only validate on the server side
  try {
    validateEnv();
  } catch (error) {
    if (error instanceof Error) {
      console.error("❌ Environment validation failed:");
      console.error(error.message);
      process.exit(1);
    }
  }
}

// Export environment variable accessors for type safety
export const env = {
  firebase: {
    apiKey: process.env.NEXT_PUBLIC_FIREBASE_API_KEY,
    authDomain: process.env.NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN,
    projectId: process.env.NEXT_PUBLIC_FIREBASE_PROJECT_ID,
    storageBucket: process.env.NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET,
    messagingSenderId: process.env.NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID,
    appId: process.env.NEXT_PUBLIC_FIREBASE_APP_ID,
    measurementId: process.env.NEXT_PUBLIC_FIREBASE_MEASUREMENT_ID,
  },
  phase: getPhase(),
  isDevelopment: isDevelopment(),
  isProduction: isProduction(),
};

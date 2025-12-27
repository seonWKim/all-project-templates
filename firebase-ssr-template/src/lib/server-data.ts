/**
 * Server-side data fetching utilities
 *
 * These functions are used in server components to fetch data
 * using the adapter pattern.
 *
 * IMPORTANT: These are server-side only utilities.
 * Client components should use hooks (useFirestore, useAuth, etc.)
 */

import { getDatabaseAdapter, getAuthAdapter } from "@/adapters/baas/factory";
import { Query } from "@/domain/ports";
import { User } from "@/domain/models/user.model";

/**
 * Fetch collection data on server
 * Use this in server components for data fetching
 *
 * @example
 * ```tsx
 * export async function PostsList() {
 *   const posts = await fetchCollection<Post>("posts");
 *   return <div>{posts.map(...)}</div>;
 * }
 * ```
 */
export async function fetchCollection<T>(
  collection: string,
  queries?: Query[]
): Promise<T[]> {
  const dbAdapter = getDatabaseAdapter<T>();
  return await dbAdapter.findMany(collection, queries);
}

/**
 * Fetch document by ID on server
 * Use this in server components for single document fetching
 *
 * @example
 * ```tsx
 * export async function PostDetail({ id }: { id: string }) {
 *   const post = await fetchDocument<Post>("posts", id);
 *   if (!post) return <div>Not found</div>;
 *   return <div>{post.title}</div>;
 * }
 * ```
 */
export async function fetchDocument<T>(
  collection: string,
  id: string
): Promise<T | null> {
  const dbAdapter = getDatabaseAdapter<T>();
  return await dbAdapter.findById(collection, id);
}

/**
 * Verify auth token on server (for middleware/API routes)
 *
 * Note: This uses a server-specific method that's not in the standard AuthPort interface.
 * The server auth adapter extends the interface with verifyIdToken().
 *
 * @example
 * ```tsx
 * // In middleware or API route
 * const token = request.cookies.get("authToken");
 * if (token) {
 *   const user = await verifyAuthToken(token.value);
 * }
 * ```
 */
export async function verifyAuthToken(idToken: string): Promise<User> {
  const authAdapter = getAuthAdapter() as any; // Server adapter has verifyIdToken
  return await authAdapter.verifyIdToken(idToken);
}

/**
 * Get user by ID on server
 *
 * Note: This uses a server-specific method that's not in the standard AuthPort interface.
 * The server auth adapter extends the interface with getUserById().
 *
 * @example
 * ```tsx
 * export async function UserProfile({ userId }: { userId: string }) {
 *   const user = await getUserById(userId);
 *   if (!user) return <div>User not found</div>;
 *   return <div>{user.displayName}</div>;
 * }
 * ```
 */
export async function getUserById(userId: string): Promise<User | null> {
  const authAdapter = getAuthAdapter() as any; // Server adapter has getUserById
  return await authAdapter.getUserById(userId);
}

"use client";

import { useEffect, useState } from "react";
import { Query } from "@/domain/ports";
import { getDatabaseAdapter } from "@/adapters/baas/factory";

/**
 * Hook for real-time Firestore queries using adapter pattern
 *
 * NOTE: This is client-side only. Server components should
 * use getDatabaseAdapter() directly without hooks or use
 * the server-data.ts utilities.
 */
export function useFirestore<T>(collection: string, queries?: Query[]) {
  const [data, setData] = useState<T[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<Error | null>(null);

  useEffect(() => {
    const dbAdapter = getDatabaseAdapter<T>();

    try {
      setLoading(true);
      setError(null);

      const unsubscribe = dbAdapter.subscribe(
        collection,
        queries,
        newData => {
          setData(newData);
          setLoading(false);
        }
      );

      return unsubscribe;
    } catch (err) {
      setError(err instanceof Error ? err : new Error("Unknown error"));
      setLoading(false);
      return () => {};
    }
  }, [collection, queries]);

  return { data, loading, error };
}

/**
 * Hook for Firestore CRUD operations using adapter pattern
 */
export function useFirestoreMutations<T = Record<string, unknown>>(
  collection: string
) {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<Error | null>(null);

  const add = async (data: Omit<T, "id">) => {
    setLoading(true);
    setError(null);

    try {
      const dbAdapter = getDatabaseAdapter<T>();
      const id = await dbAdapter.create(collection, data);
      return id;
    } catch (err) {
      const error = err instanceof Error ? err : new Error("Unknown error");
      setError(error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  const update = async (id: string, data: Partial<T>) => {
    setLoading(true);
    setError(null);

    try {
      const dbAdapter = getDatabaseAdapter<T>();
      await dbAdapter.update(collection, id, data);
    } catch (err) {
      const error = err instanceof Error ? err : new Error("Unknown error");
      setError(error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  const remove = async (id: string) => {
    setLoading(true);
    setError(null);

    try {
      const dbAdapter = getDatabaseAdapter<T>();
      await dbAdapter.delete(collection, id);
    } catch (err) {
      const error = err instanceof Error ? err : new Error("Unknown error");
      setError(error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  return { add, update, remove, loading, error };
}

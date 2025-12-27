"use client";

import { useEffect, useState } from "react";
import { User } from "@/domain/models/user.model";
import { getAuthAdapter } from "@/adapters/baas/factory";

/**
 * Hook to get the current authenticated user
 * Uses the AuthPort interface via adapter factory
 */
export function useAuth() {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const authAdapter = getAuthAdapter();

    const unsubscribe = authAdapter.onAuthStateChanged(user => {
      setUser(user);
      setLoading(false);
    });

    return unsubscribe;
  }, []);

  return { user, loading };
}

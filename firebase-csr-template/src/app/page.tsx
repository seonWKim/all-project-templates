"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { useAuth } from "@/hooks/useAuth";
import { SignInForm } from "@/components/auth/sign-in-form";
import { SignUpForm } from "@/components/auth/sign-up-form";
import { Button } from "@/components/ui/button";

export default function Home() {
  const [authMode, setAuthMode] = useState<"signin" | "signup" | null>(null);
  const { user, loading } = useAuth();
  const router = useRouter();

  useEffect(() => {
    if (!loading && user) {
      router.push("/dashboard");
    }
  }, [user, loading, router]);

  if (loading) {
    return (
      <div className="flex min-h-screen items-center justify-center">
        <div className="flex flex-col items-center gap-4">
          <div className="h-12 w-12 animate-spin rounded-full border-4 border-blue-600 border-t-transparent" />
          <p className="text-gray-600">Loading...</p>
        </div>
      </div>
    );
  }

  if (user) {
    return null; // Will redirect to dashboard
  }

  return (
    <div className="flex min-h-screen flex-col">
      {/* Hero Section */}
      <main className="flex flex-1 flex-col items-center justify-center p-8">
        {authMode === null ? (
          <div className="flex w-full max-w-4xl flex-col items-center gap-8 text-center">
            <h1 className="text-5xl font-bold tracking-tight text-gray-900 sm:text-6xl">
              Welcome to Your Project
            </h1>
            <p className="max-w-2xl text-lg text-gray-600">
              A modern, production-ready template built with Next.js, Firebase,
              and TypeScript. Get started by signing in or creating an account.
            </p>

            <div className="flex flex-col items-center gap-4 sm:flex-row">
              <Button
                size="lg"
                onClick={() => setAuthMode("signup")}
                className="w-full sm:w-auto"
              >
                Get Started
              </Button>
              <Button
                size="lg"
                variant="outline"
                onClick={() => setAuthMode("signin")}
                className="w-full sm:w-auto"
              >
                Sign In
              </Button>
            </div>

            {/* Features */}
            <div className="mt-16 grid w-full gap-8 sm:grid-cols-3">
              <div className="flex flex-col items-center gap-2">
                <div className="flex h-12 w-12 items-center justify-center rounded-lg bg-blue-100">
                  <svg
                    className="h-6 w-6 text-blue-600"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                  >
                    <path
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth={2}
                      d="M13 10V3L4 14h7v7l9-11h-7z"
                    />
                  </svg>
                </div>
                <h3 className="font-semibold">Fast & Modern</h3>
                <p className="text-sm text-gray-600">
                  Built with Next.js 15 and React 19
                </p>
              </div>

              <div className="flex flex-col items-center gap-2">
                <div className="flex h-12 w-12 items-center justify-center rounded-lg bg-green-100">
                  <svg
                    className="h-6 w-6 text-green-600"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                  >
                    <path
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth={2}
                      d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z"
                    />
                  </svg>
                </div>
                <h3 className="font-semibold">Secure</h3>
                <p className="text-sm text-gray-600">
                  Firebase Authentication & Security Rules
                </p>
              </div>

              <div className="flex flex-col items-center gap-2">
                <div className="flex h-12 w-12 items-center justify-center rounded-lg bg-purple-100">
                  <svg
                    className="h-6 w-6 text-purple-600"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                  >
                    <path
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth={2}
                      d="M10 20l4-16m4 4l4 4-4 4M6 16l-4-4 4-4"
                    />
                  </svg>
                </div>
                <h3 className="font-semibold">Type-Safe</h3>
                <p className="text-sm text-gray-600">
                  Full TypeScript support throughout
                </p>
              </div>
            </div>
          </div>
        ) : authMode === "signin" ? (
          <div className="w-full max-w-md">
            <button
              onClick={() => setAuthMode(null)}
              className="mb-4 text-sm text-gray-600 hover:text-gray-900"
            >
              ← Back
            </button>
            <SignInForm
              onSuccess={() => router.push("/dashboard")}
              onSignUpClick={() => setAuthMode("signup")}
            />
          </div>
        ) : (
          <div className="w-full max-w-md">
            <button
              onClick={() => setAuthMode(null)}
              className="mb-4 text-sm text-gray-600 hover:text-gray-900"
            >
              ← Back
            </button>
            <SignUpForm
              onSuccess={() => router.push("/dashboard")}
              onSignInClick={() => setAuthMode("signin")}
            />
          </div>
        )}
      </main>

      {/* Footer */}
      <footer className="border-t border-gray-200 py-6">
        <div className="mx-auto max-w-7xl px-4 text-center text-sm text-gray-600">
          Built with Next.js, Firebase, and TypeScript
        </div>
      </footer>
    </div>
  );
}

"use client";

import { useState, FormEvent } from "react";
import { signInWithEmailAndPassword } from "firebase/auth";
import { auth } from "@/lib/firebase";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { useToast } from "@/components/ui/toast";

interface SignInFormProps {
  onSuccess?: () => void;
  onSignUpClick?: () => void;
}

export function SignInForm({ onSuccess, onSignUpClick }: SignInFormProps) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [errors, setErrors] = useState<{ email?: string; password?: string }>({});
  const { showToast } = useToast();

  const validateForm = () => {
    const newErrors: { email?: string; password?: string } = {};

    if (!email) {
      newErrors.email = "Email is required";
    } else if (!/\S+@\S+\.\S+/.test(email)) {
      newErrors.email = "Email is invalid";
    }

    if (!password) {
      newErrors.password = "Password is required";
    } else if (password.length < 6) {
      newErrors.password = "Password must be at least 6 characters";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (!validateForm()) {
      return;
    }

    setIsLoading(true);

    try {
      await signInWithEmailAndPassword(auth, email, password);
      showToast("Successfully signed in!", "success");
      onSuccess?.();
    } catch (error: unknown) {
      console.error("Sign in error:", error);
      let errorMessage = "Failed to sign in. Please try again.";

      if (error && typeof error === "object" && "code" in error) {
        const firebaseError = error as { code: string };
        switch (firebaseError.code) {
          case "auth/user-not-found":
          case "auth/wrong-password":
          case "auth/invalid-credential":
            errorMessage = "Invalid email or password";
            break;
          case "auth/too-many-requests":
            errorMessage = "Too many failed attempts. Please try again later.";
            break;
          case "auth/user-disabled":
            errorMessage = "This account has been disabled";
            break;
          default:
            errorMessage = "An error occurred during sign in";
        }
      }

      showToast(errorMessage, "error");
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Card className="w-full max-w-md">
      <CardHeader>
        <CardTitle>Sign In</CardTitle>
      </CardHeader>
      <CardContent>
        <form onSubmit={handleSubmit} className="space-y-4">
          <Input
            label="Email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="your@email.com"
            error={errors.email}
            disabled={isLoading}
            autoComplete="email"
          />

          <Input
            label="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="••••••••"
            error={errors.password}
            disabled={isLoading}
            autoComplete="current-password"
          />

          <Button type="submit" className="w-full" isLoading={isLoading}>
            Sign In
          </Button>

          {onSignUpClick && (
            <div className="text-center text-sm">
              <span className="text-gray-600">Don&apos;t have an account? </span>
              <button
                type="button"
                onClick={onSignUpClick}
                className="font-medium text-blue-600 hover:text-blue-700"
                disabled={isLoading}
              >
                Sign up
              </button>
            </div>
          )}
        </form>
      </CardContent>
    </Card>
  );
}

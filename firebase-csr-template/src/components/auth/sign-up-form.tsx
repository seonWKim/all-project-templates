"use client";

import { useState, FormEvent } from "react";
import { createUserWithEmailAndPassword, updateProfile } from "firebase/auth";
import { auth } from "@/lib/firebase";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardHeader, CardTitle, CardContent } from "@/components/ui/card";
import { useToast } from "@/components/ui/toast";

interface SignUpFormProps {
  onSuccess?: () => void;
  onSignInClick?: () => void;
}

export function SignUpForm({ onSuccess, onSignInClick }: SignUpFormProps) {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [errors, setErrors] = useState<{
    name?: string;
    email?: string;
    password?: string;
    confirmPassword?: string;
  }>({});
  const { showToast } = useToast();

  const validateForm = () => {
    const newErrors: {
      name?: string;
      email?: string;
      password?: string;
      confirmPassword?: string;
    } = {};

    if (!name) {
      newErrors.name = "Name is required";
    }

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

    if (!confirmPassword) {
      newErrors.confirmPassword = "Please confirm your password";
    } else if (password !== confirmPassword) {
      newErrors.confirmPassword = "Passwords do not match";
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
      const userCredential = await createUserWithEmailAndPassword(
        auth,
        email,
        password
      );

      // Update user profile with name
      await updateProfile(userCredential.user, {
        displayName: name,
      });

      showToast("Account created successfully!", "success");
      onSuccess?.();
    } catch (error: unknown) {
      console.error("Sign up error:", error);
      let errorMessage = "Failed to create account. Please try again.";

      if (error && typeof error === "object" && "code" in error) {
        const firebaseError = error as { code: string };
        switch (firebaseError.code) {
          case "auth/email-already-in-use":
            errorMessage = "An account with this email already exists";
            break;
          case "auth/invalid-email":
            errorMessage = "Invalid email address";
            break;
          case "auth/weak-password":
            errorMessage = "Password is too weak";
            break;
          default:
            errorMessage = "An error occurred during sign up";
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
        <CardTitle>Sign Up</CardTitle>
      </CardHeader>
      <CardContent>
        <form onSubmit={handleSubmit} className="space-y-4">
          <Input
            label="Name"
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="John Doe"
            error={errors.name}
            disabled={isLoading}
            autoComplete="name"
          />

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
            autoComplete="new-password"
          />

          <Input
            label="Confirm Password"
            type="password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="••••••••"
            error={errors.confirmPassword}
            disabled={isLoading}
            autoComplete="new-password"
          />

          <Button type="submit" className="w-full" isLoading={isLoading}>
            Sign Up
          </Button>

          {onSignInClick && (
            <div className="text-center text-sm">
              <span className="text-gray-600">Already have an account? </span>
              <button
                type="button"
                onClick={onSignInClick}
                className="font-medium text-blue-600 hover:text-blue-700"
                disabled={isLoading}
              >
                Sign in
              </button>
            </div>
          )}
        </form>
      </CardContent>
    </Card>
  );
}

"use client";

import { ProtectedRoute } from "@/components/auth/protected-route";
import { Navbar } from "@/components/layout/navbar";
import { useAuth } from "@/hooks/useAuth";
import {
  Card,
  CardHeader,
  CardTitle,
  CardContent,
  CardDescription,
} from "@/components/ui/card";

export default function DashboardPage() {
  const { user } = useAuth();

  return (
    <ProtectedRoute>
      <div className="min-h-screen bg-gray-50">
        <Navbar />

        <main className="mx-auto max-w-7xl px-4 py-8 sm:px-6 lg:px-8">
          <div className="mb-8">
            <h1 className="text-3xl font-bold text-gray-900">
              Welcome back, {user?.displayName || "User"}!
            </h1>
            <p className="mt-2 text-gray-600">
              You&apos;re now logged in to your dashboard
            </p>
          </div>

          <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
            <Card>
              <CardHeader>
                <CardTitle>Profile</CardTitle>
                <CardDescription>Your account information</CardDescription>
              </CardHeader>
              <CardContent>
                <dl className="space-y-2">
                  <div>
                    <dt className="text-sm font-medium text-gray-500">Email</dt>
                    <dd className="text-sm text-gray-900">{user?.email}</dd>
                  </div>
                  <div>
                    <dt className="text-sm font-medium text-gray-500">Name</dt>
                    <dd className="text-sm text-gray-900">
                      {user?.displayName || "Not set"}
                    </dd>
                  </div>
                  <div>
                    <dt className="text-sm font-medium text-gray-500">
                      User ID
                    </dt>
                    <dd className="text-sm text-gray-900 truncate">
                      {user?.id}
                    </dd>
                  </div>
                </dl>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <CardTitle>Getting Started</CardTitle>
                <CardDescription>Build your application</CardDescription>
              </CardHeader>
              <CardContent>
                <ul className="space-y-2 text-sm text-gray-600">
                  <li>✓ Authentication setup complete</li>
                  <li>✓ Firebase initialized</li>
                  <li>✓ TypeScript configured</li>
                  <li>• Add your first Firestore collection</li>
                  <li>• Create custom components</li>
                  <li>• Deploy to Firebase Hosting</li>
                </ul>
              </CardContent>
            </Card>

            <Card>
              <CardHeader>
                <CardTitle>Quick Actions</CardTitle>
                <CardDescription>Common tasks</CardDescription>
              </CardHeader>
              <CardContent>
                <div className="space-y-2">
                  <button className="w-full rounded-lg border border-gray-300 px-4 py-2 text-left text-sm hover:bg-gray-50">
                    Update Profile
                  </button>
                  <button className="w-full rounded-lg border border-gray-300 px-4 py-2 text-left text-sm hover:bg-gray-50">
                    View Settings
                  </button>
                  <button className="w-full rounded-lg border border-gray-300 px-4 py-2 text-left text-sm hover:bg-gray-50">
                    Help & Support
                  </button>
                </div>
              </CardContent>
            </Card>
          </div>

          <div className="mt-8">
            <Card>
              <CardHeader>
                <CardTitle>Next Steps</CardTitle>
                <CardDescription>
                  Continue building your application with these resources
                </CardDescription>
              </CardHeader>
              <CardContent>
                <div className="grid gap-4 sm:grid-cols-2">
                  <div>
                    <h4 className="mb-2 font-medium">Documentation</h4>
                    <ul className="space-y-1 text-sm text-gray-600">
                      <li>
                        <a
                          href="https://nextjs.org/docs"
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-blue-600 hover:underline"
                        >
                          Next.js Documentation
                        </a>
                      </li>
                      <li>
                        <a
                          href="https://firebase.google.com/docs"
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-blue-600 hover:underline"
                        >
                          Firebase Documentation
                        </a>
                      </li>
                      <li>
                        <a
                          href="https://tailwindcss.com/docs"
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-blue-600 hover:underline"
                        >
                          Tailwind CSS Documentation
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div>
                    <h4 className="mb-2 font-medium">Project Structure</h4>
                    <ul className="space-y-1 text-sm text-gray-600">
                      <li>
                        <code className="rounded bg-gray-100 px-1">
                          src/app
                        </code>{" "}
                        - Pages and routes
                      </li>
                      <li>
                        <code className="rounded bg-gray-100 px-1">
                          src/components
                        </code>{" "}
                        - React components
                      </li>
                      <li>
                        <code className="rounded bg-gray-100 px-1">
                          src/lib
                        </code>{" "}
                        - Utilities and services
                      </li>
                      <li>
                        <code className="rounded bg-gray-100 px-1">
                          functions
                        </code>{" "}
                        - Cloud Functions
                      </li>
                    </ul>
                  </div>
                </div>
              </CardContent>
            </Card>
          </div>
        </main>
      </div>
    </ProtectedRoute>
  );
}

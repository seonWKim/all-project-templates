import { Suspense } from "react";
import { UserProfile } from "@/components/UserProfile";
import { PostsList } from "@/components/PostsList";

export default function HomePage() {
  return (
    <main className="min-h-screen bg-gray-50">
      <div className="container mx-auto px-4 py-8">
        <h1 className="text-4xl font-bold text-center mb-8 text-gray-900">
          Firebase SSR Template
        </h1>
        
        <div className="grid gap-8 md:grid-cols-2">
          <section className="bg-white rounded-lg shadow-md p-6">
            <h2 className="text-2xl font-semibold mb-4 text-gray-800">
              User Authentication
            </h2>
            <Suspense fallback={<div className="animate-pulse">Loading user...</div>}>
              <UserProfile />
            </Suspense>
          </section>

          <section className="bg-white rounded-lg shadow-md p-6">
            <h2 className="text-2xl font-semibold mb-4 text-gray-800">
              Recent Posts
            </h2>
            <Suspense fallback={<div className="animate-pulse">Loading posts...</div>}>
              <PostsList />
            </Suspense>
          </section>
        </div>
      </div>
    </main>
  );
}
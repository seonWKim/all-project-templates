import { collection, query, orderBy, limit, getDocs } from "firebase/firestore";
import { adminDb } from "@/lib/firebase-admin";

interface Post {
  id: string;
  title: string;
  content: string;
  createdAt: Date;
  author: string;
}

async function getPosts(): Promise<Post[]> {
  try {
    // Use admin SDK for server-side data fetching
    const postsRef = adminDb.collection("posts");
    const q = postsRef.orderBy("createdAt", "desc").limit(5);
    const snapshot = await q.get();
    
    return snapshot.docs.map((doc) => ({
      id: doc.id,
      ...doc.data(),
      createdAt: doc.data().createdAt?.toDate() || new Date(),
    })) as Post[];
  } catch (error) {
    console.error("Error fetching posts:", error);
    return [];
  }
}

export async function PostsList() {
  const posts = await getPosts();

  if (posts.length === 0) {
    return (
      <div className="text-center text-gray-500">
        <p>No posts found.</p>
        <p className="text-sm mt-2">Create some posts in your Firestore database to see them here.</p>
      </div>
    );
  }

  return (
    <div className="space-y-4">
      {posts.map((post) => (
        <article key={post.id} className="border-b border-gray-200 pb-4 last:border-b-0">
          <h3 className="font-semibold text-lg text-gray-900">{post.title}</h3>
          <p className="text-gray-600 mt-1 line-clamp-2">{post.content}</p>
          <div className="flex justify-between items-center mt-2 text-sm text-gray-500">
            <span>By {post.author}</span>
            <time dateTime={post.createdAt.toISOString()}>
              {post.createdAt.toLocaleDateString()}
            </time>
          </div>
        </article>
      ))}
    </div>
  );
}
import { initializeApp, getApps, cert, ServiceAccount } from "firebase-admin/app";
import { getAuth } from "firebase-admin/auth";
import { getFirestore } from "firebase-admin/firestore";
import { env } from "./env";

// Server-side Firebase Admin configuration
const serviceAccount: ServiceAccount = {
  projectId: env.firebase.projectId(),
  clientEmail: env.firebase.clientEmail(),
  privateKey: env.firebase.privateKey()?.replace(/\\n/g, "\n"),
};

// Initialize Firebase Admin (server-side)
if (!getApps().length) {
  initializeApp({
    credential: cert(serviceAccount),
    projectId: env.firebase.projectId(),
  });
}

// Export admin services
export const adminAuth = getAuth();
export const adminDb = getFirestore();
/**
 * Firebase Database Server Adapter
 *
 * Implements DatabasePort interface using Firebase Admin SDK Firestore.
 * Runs on the server (Node.js).
 */

import { adminDb } from "@/lib/firebase-admin";
import { DatabasePort, Query } from "@/domain/ports";
import * as admin from "firebase-admin";

export class FirebaseDatabaseServerAdapter<T = Record<string, unknown>>
  implements DatabasePort<T>
{
  async create(collectionName: string, data: Omit<T, "id">): Promise<string> {
    const docRef = await adminDb.collection(collectionName).add(data as any);
    return docRef.id;
  }

  async findById(collectionName: string, id: string): Promise<T | null> {
    const docSnap = await adminDb.collection(collectionName).doc(id).get();

    if (!docSnap.exists) {
      return null;
    }

    return {
      id: docSnap.id,
      ...this.mapFirestoreData(docSnap.data()),
    } as T;
  }

  async findMany(collectionName: string, queries?: Query[]): Promise<T[]> {
    let query: admin.firestore.Query = adminDb.collection(collectionName);

    if (queries && queries.length > 0) {
      queries.forEach(q => {
        query = query.where(q.field, q.operator as any, q.value);
      });
    }

    const snapshot = await query.get();

    return snapshot.docs.map(doc => ({
      id: doc.id,
      ...this.mapFirestoreData(doc.data()),
    })) as T[];
  }

  async update(
    collectionName: string,
    id: string,
    data: Partial<T>
  ): Promise<void> {
    await adminDb.collection(collectionName).doc(id).update(data as any);
  }

  async delete(collectionName: string, id: string): Promise<void> {
    await adminDb.collection(collectionName).doc(id).delete();
  }

  subscribe(
    _collectionName: string,
    _queries: Query[] | undefined,
    _callback: (data: T[]) => void
  ): () => void {
    // Real-time subscriptions are primarily a client-side feature
    // Server components typically fetch data once, not subscribe
    throw new Error(
      "Real-time subscriptions should use client-side adapter. Server components should fetch data directly with findMany()."
    );
  }

  async batchWrite(
    operations: Array<{
      type: "create" | "update" | "delete";
      collection: string;
      id?: string;
      data?: Partial<T>;
    }>
  ): Promise<void> {
    const batch = adminDb.batch();

    operations.forEach(operation => {
      if (operation.type === "create") {
        const docRef = adminDb.collection(operation.collection).doc();
        batch.set(docRef, operation.data as any);
      } else if (operation.type === "update" && operation.id) {
        const docRef = adminDb
          .collection(operation.collection)
          .doc(operation.id);
        batch.update(docRef, operation.data as any);
      } else if (operation.type === "delete" && operation.id) {
        const docRef = adminDb
          .collection(operation.collection)
          .doc(operation.id);
        batch.delete(docRef);
      }
    });

    await batch.commit();
  }

  /**
   * Map Firestore Admin SDK types to domain types
   * Admin SDK Timestamp needs to be converted to Date
   */
  private mapFirestoreData(data: any): any {
    if (!data) return data;

    const mapped: any = {};

    for (const [key, value] of Object.entries(data)) {
      if (value instanceof admin.firestore.Timestamp) {
        // Convert Firestore Timestamp to Date
        mapped[key] = value.toDate();
      } else if (value && typeof value === "object" && !Array.isArray(value)) {
        // Recursively map nested objects
        mapped[key] = this.mapFirestoreData(value);
      } else {
        mapped[key] = value;
      }
    }

    return mapped;
  }
}

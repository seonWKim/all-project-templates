/**
 * Firebase Database Adapter
 * 
 * Implements DatabasePort interface using Firebase Firestore SDK.
 */

import {
  collection,
  doc,
  addDoc,
  getDoc,
  getDocs,
  updateDoc,
  deleteDoc,
  query,
  where,
  onSnapshot,
  writeBatch,
  WhereFilterOp,
} from 'firebase/firestore';
import { DatabasePort, Query } from '@/domain/ports';
import { db } from '@/lib/firebase';

export class FirebaseDatabaseAdapter<T = any> implements DatabasePort<T> {
  async create(collectionName: string, data: Omit<T, 'id'>): Promise<string> {
    const docRef = await addDoc(collection(db, collectionName), data);
    return docRef.id;
  }

  async findById(collectionName: string, id: string): Promise<T | null> {
    const docRef = doc(db, collectionName, id);
    const docSnap = await getDoc(docRef);
    
    if (!docSnap.exists()) {
      return null;
    }
    
    return {
      id: docSnap.id,
      ...docSnap.data(),
    } as T;
  }

  async findMany(collectionName: string, queries?: Query[]): Promise<T[]> {
    const collectionRef = collection(db, collectionName);
    
    let q = query(collectionRef);
    
    if (queries && queries.length > 0) {
      queries.forEach((queryItem) => {
        q = query(
          q,
          where(queryItem.field, queryItem.operator as WhereFilterOp, queryItem.value)
        );
      });
    }
    
    const querySnapshot = await getDocs(q);
    
    return querySnapshot.docs.map((doc) => ({
      id: doc.id,
      ...doc.data(),
    })) as T[];
  }

  async update(collectionName: string, id: string, data: Partial<T>): Promise<void> {
    const docRef = doc(db, collectionName, id);
    await updateDoc(docRef, data as any);
  }

  async delete(collectionName: string, id: string): Promise<void> {
    const docRef = doc(db, collectionName, id);
    await deleteDoc(docRef);
  }

  subscribe(
    collectionName: string,
    queries: Query[] | undefined,
    callback: (data: T[]) => void
  ): () => void {
    const collectionRef = collection(db, collectionName);
    
    let q = query(collectionRef);
    
    if (queries && queries.length > 0) {
      queries.forEach((queryItem) => {
        q = query(
          q,
          where(queryItem.field, queryItem.operator as WhereFilterOp, queryItem.value)
        );
      });
    }
    
    const unsubscribe = onSnapshot(q, (querySnapshot) => {
      const data = querySnapshot.docs.map((doc) => ({
        id: doc.id,
        ...doc.data(),
      })) as T[];
      callback(data);
    });
    
    return unsubscribe;
  }

  async batchWrite(
    operations: Array<{
      type: 'create' | 'update' | 'delete';
      collection: string;
      id?: string;
      data?: any;
    }>
  ): Promise<void> {
    const batch = writeBatch(db);
    
    operations.forEach((operation) => {
      if (operation.type === 'create') {
        const docRef = doc(collection(db, operation.collection));
        batch.set(docRef, operation.data);
      } else if (operation.type === 'update' && operation.id) {
        const docRef = doc(db, operation.collection, operation.id);
        batch.update(docRef, operation.data);
      } else if (operation.type === 'delete' && operation.id) {
        const docRef = doc(db, operation.collection, operation.id);
        batch.delete(docRef);
      }
    });
    
    await batch.commit();
  }
}

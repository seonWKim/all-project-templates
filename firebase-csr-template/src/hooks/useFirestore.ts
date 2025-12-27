"use client";

import { useState, useEffect } from "react";
import {
  collection,
  doc,
  getDoc,
  getDocs,
  addDoc,
  updateDoc,
  deleteDoc,
  query,
  where,
  orderBy,
  limit,
  QueryConstraint,
  DocumentData,
  FirestoreError,
} from "firebase/firestore";
import { db } from "@/lib/firebase";

/**
 * Hook for fetching a single document from Firestore
 */
export function useFirestoreDoc<T = DocumentData>(
  collectionName: string,
  docId: string | null
) {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<FirestoreError | null>(null);

  useEffect(() => {
    if (!docId) {
      setData(null);
      setLoading(false);
      return;
    }

    const fetchDoc = async () => {
      setLoading(true);
      setError(null);
      
      try {
        const docRef = doc(db, collectionName, docId);
        const docSnap = await getDoc(docRef);
        
        if (docSnap.exists()) {
          setData({ id: docSnap.id, ...docSnap.data() } as T);
        } else {
          setData(null);
        }
      } catch (err) {
        setError(err as FirestoreError);
      } finally {
        setLoading(false);
      }
    };

    fetchDoc();
  }, [collectionName, docId]);

  return { data, loading, error };
}

/**
 * Hook for fetching a collection from Firestore
 */
export function useFirestoreCollection<T = DocumentData>(
  collectionName: string,
  constraints: QueryConstraint[] = []
) {
  const [data, setData] = useState<T[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<FirestoreError | null>(null);

  useEffect(() => {
    const fetchCollection = async () => {
      setLoading(true);
      setError(null);
      
      try {
        const collectionRef = collection(db, collectionName);
        const q = constraints.length > 0 
          ? query(collectionRef, ...constraints) 
          : collectionRef;
        
        const querySnapshot = await getDocs(q);
        const docs = querySnapshot.docs.map((doc) => ({
          id: doc.id,
          ...doc.data(),
        })) as T[];
        
        setData(docs);
      } catch (err) {
        setError(err as FirestoreError);
      } finally {
        setLoading(false);
      }
    };

    fetchCollection();
  }, [collectionName, constraints]);

  return { data, loading, error };
}

/**
 * Hook for Firestore CRUD operations
 */
export function useFirestore<T = DocumentData>(collectionName: string) {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<FirestoreError | null>(null);

  const add = async (data: Partial<T>) => {
    setLoading(true);
    setError(null);
    
    try {
      const collectionRef = collection(db, collectionName);
      const docRef = await addDoc(collectionRef, {
        ...data,
        createdAt: new Date().toISOString(),
      });
      return docRef.id;
    } catch (err) {
      setError(err as FirestoreError);
      throw err;
    } finally {
      setLoading(false);
    }
  };

  const update = async (docId: string, data: Partial<T>) => {
    setLoading(true);
    setError(null);
    
    try {
      const docRef = doc(db, collectionName, docId);
      await updateDoc(docRef, {
        ...data,
        updatedAt: new Date().toISOString(),
      });
    } catch (err) {
      setError(err as FirestoreError);
      throw err;
    } finally {
      setLoading(false);
    }
  };

  const remove = async (docId: string) => {
    setLoading(true);
    setError(null);
    
    try {
      const docRef = doc(db, collectionName, docId);
      await deleteDoc(docRef);
    } catch (err) {
      setError(err as FirestoreError);
      throw err;
    } finally {
      setLoading(false);
    }
  };

  return { add, update, remove, loading, error };
}

// Re-export Firestore query utilities for convenience
export { where, orderBy, limit };

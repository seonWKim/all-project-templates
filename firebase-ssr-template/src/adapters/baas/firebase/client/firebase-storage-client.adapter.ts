/**
 * Firebase Storage Client Adapter
 *
 * Implements StoragePort interface using Firebase Storage Client SDK.
 * Runs in the browser.
 */

import {
  ref,
  uploadBytes,
  getDownloadURL as firebaseGetDownloadURL,
  deleteObject,
  listAll,
  getMetadata,
  getBlob,
  UploadMetadata,
} from "firebase/storage";
import { StoragePort } from "@/domain/ports";
import { storage } from "@/lib/firebase-client";

export class FirebaseStorageClientAdapter implements StoragePort {
  async upload(
    path: string,
    file: File,
    metadata?: Record<string, string>
  ): Promise<string> {
    const storageRef = ref(storage, path);
    const uploadMetadata: UploadMetadata | undefined = metadata
      ? { customMetadata: metadata }
      : undefined;

    await uploadBytes(storageRef, file, uploadMetadata);
    return await this.getDownloadURL(path);
  }

  async download(path: string): Promise<Blob> {
    const storageRef = ref(storage, path);
    return await getBlob(storageRef);
  }

  async delete(path: string): Promise<void> {
    const storageRef = ref(storage, path);
    await deleteObject(storageRef);
  }

  async getDownloadURL(path: string): Promise<string> {
    const storageRef = ref(storage, path);
    return await firebaseGetDownloadURL(storageRef);
  }

  async listFiles(
    path: string
  ): Promise<Array<{ name: string; fullPath: string; size: number }>> {
    const storageRef = ref(storage, path);
    const result = await listAll(storageRef);

    const filesWithMetadata = await Promise.all(
      result.items.map(async itemRef => {
        const metadata = await getMetadata(itemRef);
        return {
          name: itemRef.name,
          fullPath: itemRef.fullPath,
          size: metadata.size,
        };
      })
    );

    return filesWithMetadata;
  }
}

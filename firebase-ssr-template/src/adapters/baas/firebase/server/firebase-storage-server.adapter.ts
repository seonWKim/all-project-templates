/**
 * Firebase Storage Server Adapter
 *
 * Implements StoragePort interface using Firebase Admin SDK Storage.
 * Runs on the server (Node.js).
 */

import { adminStorage } from "@/lib/firebase-admin";
import { StoragePort } from "@/domain/ports";

export class FirebaseStorageServerAdapter implements StoragePort {
  async upload(
    path: string,
    file: File,
    metadata?: Record<string, string>
  ): Promise<string> {
    const bucket = adminStorage.bucket();
    const fileBuffer = Buffer.from(await file.arrayBuffer());

    const fileUpload = bucket.file(path);

    await fileUpload.save(fileBuffer, {
      metadata: {
        contentType: file.type,
        metadata: metadata || {},
      },
    });

    return await this.getDownloadURL(path);
  }

  async download(path: string): Promise<Blob> {
    const bucket = adminStorage.bucket();
    const file = bucket.file(path);

    const [buffer] = await file.download();
    return new Blob([buffer]);
  }

  async delete(path: string): Promise<void> {
    const bucket = adminStorage.bucket();
    const file = bucket.file(path);
    await file.delete();
  }

  async getDownloadURL(path: string): Promise<string> {
    const bucket = adminStorage.bucket();
    const file = bucket.file(path);

    // Generate a signed URL (Admin SDK doesn't have public URLs like client SDK)
    const [url] = await file.getSignedUrl({
      action: "read",
      expires: Date.now() + 7 * 24 * 60 * 60 * 1000, // 7 days
    });

    return url;
  }

  async listFiles(
    path: string
  ): Promise<Array<{ name: string; fullPath: string; size: number }>> {
    const bucket = adminStorage.bucket();
    const [files] = await bucket.getFiles({ prefix: path });

    return files.map(file => ({
      name: file.name.split("/").pop() || file.name,
      fullPath: file.name,
      size: parseInt(file.metadata.size || "0", 10),
    }));
  }
}

/**
 * Port Interface: Storage
 * 
 * Defines the contract for file storage operations.
 */

export interface StoragePort {
  /**
   * Upload a file
   * @returns Download URL of uploaded file
   */
  upload(path: string, file: File, metadata?: Record<string, string>): Promise<string>;

  /**
   * Download a file
   */
  download(path: string): Promise<Blob>;

  /**
   * Delete a file
   */
  delete(path: string): Promise<void>;

  /**
   * Get download URL for a file
   */
  getDownloadURL(path: string): Promise<string>;

  /**
   * List files in a directory
   */
  listFiles(path: string): Promise<Array<{ name: string; fullPath: string; size: number }>>;
}

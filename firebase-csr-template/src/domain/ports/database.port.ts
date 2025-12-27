/**
 * Port Interface: Database
 *
 * Defines the contract for database operations.
 * Generic interface that works with any document/object database.
 */

export interface Query {
  field: string;
  operator: "==" | "!=" | ">" | ">=" | "<" | "<=" | "in" | "array-contains";
  value: unknown;
}

export interface DatabasePort<T = Record<string, unknown>> {
  /**
   * Create a new document in a collection
   */
  create(collection: string, data: Omit<T, "id">): Promise<string>;

  /**
   * Find a document by ID
   */
  findById(collection: string, id: string): Promise<T | null>;

  /**
   * Find multiple documents matching a query
   */
  findMany(collection: string, queries?: Query[]): Promise<T[]>;

  /**
   * Update a document
   */
  update(collection: string, id: string, data: Partial<T>): Promise<void>;

  /**
   * Delete a document
   */
  delete(collection: string, id: string): Promise<void>;

  /**
   * Subscribe to real-time updates
   * @returns Unsubscribe function
   */
  subscribe(
    collection: string,
    queries: Query[] | undefined,
    callback: (data: T[]) => void
  ): () => void;

  /**
   * Batch write operations
   */
  batchWrite(
    operations: Array<{
      type: "create" | "update" | "delete";
      collection: string;
      id?: string;
      data?: Partial<T>;
    }>
  ): Promise<void>;
}

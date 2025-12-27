/**
 * Global type definitions and re-exports
 */

// Re-export domain models
export type * from "@/domain/models/user.model";

// Re-export port types for convenience
export type { Query } from "@/domain/ports";

// Application-specific types
export interface Post {
  id: string;
  title: string;
  content: string;
  author: string;
  authorId: string;
  createdAt: Date;
  updatedAt: Date;
}

export interface PaginationParams {
  page: number;
  limit: number;
}

export interface PaginatedResponse<T> {
  data: T[];
  pagination: {
    page: number;
    limit: number;
    total: number;
    totalPages: number;
  };
}
/**
 * Architectural Tests: Adapter Interchangeability (SSR Edition)
 *
 * These tests validate that adapters correctly implement port interfaces
 * and can be swapped without breaking the system.
 *
 * SSR-specific: Tests context-aware adapter factory.
 */

import {
  AuthPort,
  DatabasePort,
  StoragePort,
  MessagingPort,
} from "@/domain/ports";

describe("Hexagonal Architecture: Adapter Interchangeability", () => {
  describe("Port Interface Contracts", () => {
    it("AuthPort contract is correctly defined", () => {
      // This test ensures the port interface has the right shape
      const mockAuthPort: AuthPort = {
        signIn: jest.fn(),
        signUp: jest.fn(),
        signOut: jest.fn(),
        getCurrentUser: jest.fn(),
        onAuthStateChanged: jest.fn(),
        sendPasswordResetEmail: jest.fn(),
        updateProfile: jest.fn(),
        deleteAccount: jest.fn(),
      };

      expect(mockAuthPort).toBeDefined();
      expect(Object.keys(mockAuthPort).length).toBeGreaterThanOrEqual(8);
    });

    it("DatabasePort contract is correctly defined", () => {
      const mockDatabasePort: DatabasePort = {
        create: jest.fn(),
        findById: jest.fn(),
        findMany: jest.fn(),
        update: jest.fn(),
        delete: jest.fn(),
        subscribe: jest.fn(),
        batchWrite: jest.fn(),
      };

      expect(mockDatabasePort).toBeDefined();
      expect(Object.keys(mockDatabasePort).length).toBeGreaterThanOrEqual(7);
    });

    it("StoragePort contract is correctly defined", () => {
      const mockStoragePort: StoragePort = {
        upload: jest.fn(),
        download: jest.fn(),
        delete: jest.fn(),
        getDownloadURL: jest.fn(),
        listFiles: jest.fn(),
      };

      expect(mockStoragePort).toBeDefined();
      expect(Object.keys(mockStoragePort).length).toBeGreaterThanOrEqual(5);
    });

    it("MessagingPort contract is correctly defined", () => {
      const mockMessagingPort: MessagingPort = {
        requestPermission: jest.fn(),
        getToken: jest.fn(),
        onMessage: jest.fn(),
        subscribeToTopic: jest.fn(),
        unsubscribeFromTopic: jest.fn(),
      };

      expect(mockMessagingPort).toBeDefined();
      expect(Object.keys(mockMessagingPort).length).toBeGreaterThanOrEqual(5);
    });
  });

  describe("Adapter Factory (SSR Context-Aware)", () => {
    it("factory exports correct functions", async () => {
      const factory = await import("@/adapters/baas/factory");

      expect(typeof factory.createAuthAdapter).toBe("function");
      expect(typeof factory.createDatabaseAdapter).toBe("function");
      expect(typeof factory.createStorageAdapter).toBe("function");
      expect(typeof factory.createMessagingAdapter).toBe("function");
      expect(typeof factory.getAuthAdapter).toBe("function");
      expect(typeof factory.getDatabaseAdapter).toBe("function");
      expect(typeof factory.getStorageAdapter).toBe("function");
      expect(typeof factory.getMessagingAdapter).toBe("function");
      expect(typeof factory.getBaasConfig).toBe("function");
      expect(typeof factory.getExecutionContext).toBe("function");
    });

    it("getBaasConfig returns valid configuration", async () => {
      const { getBaasConfig } = await import("@/adapters/baas/factory");

      const config = getBaasConfig();

      expect(config).toBeDefined();
      expect(config.provider).toBeDefined();
      expect(["firebase", "aws", "supabase"]).toContain(config.provider);
      expect(config.context).toBeDefined();
      expect(["client", "server"]).toContain(config.context);
    });

    it("getExecutionContext detects server environment in tests", async () => {
      const { getExecutionContext } = await import("@/adapters/baas/factory");

      const context = getExecutionContext();

      // In Jest tests (Node.js), should detect server context
      expect(context).toBe("server");
    });

    it("createAuthAdapter returns server adapter in server context", async () => {
      const { createAuthAdapter } = await import("@/adapters/baas/factory");
      const { FirebaseAuthServerAdapter } = await import(
        "@/adapters/baas/firebase/server/firebase-auth-server.adapter"
      );

      const adapter = createAuthAdapter({
        provider: "firebase",
        context: "server",
      });

      expect(adapter).toBeInstanceOf(FirebaseAuthServerAdapter);
    });

    it("createDatabaseAdapter returns server adapter in server context", async () => {
      const { createDatabaseAdapter } = await import(
        "@/adapters/baas/factory"
      );
      const { FirebaseDatabaseServerAdapter } = await import(
        "@/adapters/baas/firebase/server/firebase-database-server.adapter"
      );

      const adapter = createDatabaseAdapter({
        provider: "firebase",
        context: "server",
      });

      expect(adapter).toBeInstanceOf(FirebaseDatabaseServerAdapter);
    });

    it("messaging adapter throws error in server context", async () => {
      const { createMessagingAdapter, getExecutionContext } = await import(
        "@/adapters/baas/factory"
      );

      // Verify we're in server context
      expect(getExecutionContext()).toBe("server");

      // Should throw because messaging is client-only
      expect(() => createMessagingAdapter()).toThrow(
        "Messaging is only available on client-side"
      );
    });
  });

  describe("Use Case Dependencies", () => {
    it("LoginUseCase depends on AuthPort, not concrete implementation", async () => {
      const { LoginUseCase } = await import(
        "@/application/use-cases/login.use-case"
      );

      const mockAuthPort: AuthPort = {
        signIn: jest.fn().mockResolvedValue({
          id: "123",
          email: "test@example.com",
          createdAt: new Date(),
          updatedAt: new Date(),
        }),
        signUp: jest.fn(),
        signOut: jest.fn(),
        getCurrentUser: jest.fn(),
        onAuthStateChanged: jest.fn(),
        sendPasswordResetEmail: jest.fn(),
        updateProfile: jest.fn(),
        deleteAccount: jest.fn(),
      };

      const useCase = new LoginUseCase(mockAuthPort);
      expect(useCase).toBeDefined();

      // Test that use case can work with mock (interface-based)
      await useCase.execute({
        email: "test@example.com",
        password: "password123",
      });
      expect(mockAuthPort.signIn).toHaveBeenCalled();
    });

    it("SignUpUseCase depends on AuthPort, not concrete implementation", async () => {
      const { SignUpUseCase } = await import(
        "@/application/use-cases/signup.use-case"
      );

      const mockAuthPort: AuthPort = {
        signIn: jest.fn(),
        signUp: jest.fn().mockResolvedValue({
          id: "123",
          email: "test@example.com",
          createdAt: new Date(),
          updatedAt: new Date(),
        }),
        signOut: jest.fn(),
        getCurrentUser: jest.fn(),
        onAuthStateChanged: jest.fn(),
        sendPasswordResetEmail: jest.fn(),
        updateProfile: jest.fn(),
        deleteAccount: jest.fn(),
      };

      const useCase = new SignUpUseCase(mockAuthPort);
      expect(useCase).toBeDefined();

      // Test that use case can work with mock (interface-based)
      await useCase.execute({
        email: "test@example.com",
        password: "password123",
      });
      expect(mockAuthPort.signUp).toHaveBeenCalled();
    });
  });

  describe("SSR Adapter Behavior", () => {
    it("server auth adapter throws error for client-only operations", async () => {
      const { FirebaseAuthServerAdapter } = await import(
        "@/adapters/baas/firebase/server/firebase-auth-server.adapter"
      );

      const adapter = new FirebaseAuthServerAdapter();

      // These should throw because they're client-only
      await expect(
        adapter.signIn({ email: "test@test.com", password: "password" })
      ).rejects.toThrow("client-side adapter");

      await expect(
        adapter.signUp({ email: "test@test.com", password: "password" })
      ).rejects.toThrow("client-side adapter");

      await expect(adapter.signOut()).rejects.toThrow("client-side adapter");

      await expect(adapter.getCurrentUser()).rejects.toThrow(
        "client-side adapter"
      );

      expect(() => adapter.onAuthStateChanged(() => {})).toThrow(
        "client-side adapter"
      );
    });

    it("server database adapter throws error for real-time subscriptions", async () => {
      const { FirebaseDatabaseServerAdapter } = await import(
        "@/adapters/baas/firebase/server/firebase-database-server.adapter"
      );

      const adapter = new FirebaseDatabaseServerAdapter();

      // Real-time subscriptions are client-only
      expect(() =>
        adapter.subscribe("posts", [], () => {})
      ).toThrow("client-side adapter");
    });
  });
});

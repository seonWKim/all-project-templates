// Jest setup file - runs before each test

// Mock fetch and Response for Firebase in Node environment
global.fetch = jest.fn();
global.Response = class Response {};
global.Request = class Request {};
global.Headers = class Headers {};

// Set up test environment variables
process.env.NEXT_PUBLIC_FIREBASE_API_KEY = 'test-api-key';
process.env.NEXT_PUBLIC_FIREBASE_AUTH_DOMAIN = 'test.firebaseapp.com';
process.env.NEXT_PUBLIC_FIREBASE_PROJECT_ID = 'test-project';
process.env.NEXT_PUBLIC_FIREBASE_STORAGE_BUCKET = 'test-project.appspot.com';
process.env.NEXT_PUBLIC_FIREBASE_MESSAGING_SENDER_ID = '123456789';
process.env.NEXT_PUBLIC_FIREBASE_APP_ID = '1:123456789:web:abcdef';
process.env.NEXT_PUBLIC_BAAS_PROVIDER = 'firebase';

// Suppress console.error during tests unless testing error handling specifically
beforeEach(() => {
  jest.spyOn(console, "error").mockImplementation(() => {});
});

afterEach(() => {
  if (console.error.mockRestore) {
    console.error.mockRestore();
  }
});

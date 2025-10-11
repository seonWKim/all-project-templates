// Jest setup file - runs before each test

// Suppress console.error during tests unless testing error handling specifically
beforeEach(() => {
  jest.spyOn(console, "error").mockImplementation(() => {});
});

afterEach(() => {
  if (console.error.mockRestore) {
    console.error.mockRestore();
  }
});

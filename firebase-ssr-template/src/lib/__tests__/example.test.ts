import { cn, formatDate, generateId } from "../utils";

describe("Utils", () => {
  describe("cn", () => {
    it("should merge class names correctly", () => {
      expect(cn("text-red-500", "text-blue-500")).toBe("text-blue-500");
      expect(cn("p-4", "p-2")).toBe("p-2");
      expect(cn("text-sm", "font-bold")).toBe("text-sm font-bold");
    });
  });

  describe("formatDate", () => {
    it("should format dates correctly", () => {
      const date = new Date("2023-01-01");
      const formatted = formatDate(date);
      expect(formatted).toContain("2023");
      expect(formatted).toContain("January");
    });

    it("should handle string dates", () => {
      const formatted = formatDate("2023-01-01");
      expect(formatted).toContain("2023");
    });
  });

  describe("generateId", () => {
    it("should generate random ids", () => {
      const id1 = generateId();
      const id2 = generateId();
      expect(id1).not.toBe(id2);
      expect(id1).toHaveLength(16);
    });

    it("should respect custom length", () => {
      const id = generateId(10);
      expect(id).toHaveLength(10);
    });
  });
});
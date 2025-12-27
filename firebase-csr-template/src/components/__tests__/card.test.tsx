import React from "react";
import { render, screen } from "@testing-library/react";
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from "../ui/card";
import "@testing-library/jest-dom";

describe("Card components", () => {
  it("renders Card component", () => {
    render(<Card data-testid="card">Card content</Card>);
    expect(screen.getByTestId("card")).toBeInTheDocument();
  });

  it("renders CardHeader component", () => {
    render(<CardHeader data-testid="card-header">Header</CardHeader>);
    expect(screen.getByTestId("card-header")).toBeInTheDocument();
  });

  it("renders CardTitle component", () => {
    render(<CardTitle>Title</CardTitle>);
    expect(screen.getByText("Title")).toBeInTheDocument();
  });

  it("renders CardDescription component", () => {
    render(<CardDescription>Description</CardDescription>);
    expect(screen.getByText("Description")).toBeInTheDocument();
  });

  it("renders CardContent component", () => {
    render(<CardContent data-testid="card-content">Content</CardContent>);
    expect(screen.getByTestId("card-content")).toBeInTheDocument();
  });

  it("renders CardFooter component", () => {
    render(<CardFooter data-testid="card-footer">Footer</CardFooter>);
    expect(screen.getByTestId("card-footer")).toBeInTheDocument();
  });

  it("renders a complete card with all components", () => {
    render(
      <Card>
        <CardHeader>
          <CardTitle>Test Card</CardTitle>
          <CardDescription>Test Description</CardDescription>
        </CardHeader>
        <CardContent>Test Content</CardContent>
        <CardFooter>Test Footer</CardFooter>
      </Card>
    );

    expect(screen.getByText("Test Card")).toBeInTheDocument();
    expect(screen.getByText("Test Description")).toBeInTheDocument();
    expect(screen.getByText("Test Content")).toBeInTheDocument();
    expect(screen.getByText("Test Footer")).toBeInTheDocument();
  });
});

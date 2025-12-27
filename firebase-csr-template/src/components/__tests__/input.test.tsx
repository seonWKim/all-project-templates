import React from "react";
import { render, screen } from "@testing-library/react";
import { Input } from "../ui/input";
import "@testing-library/jest-dom";

describe("Input", () => {
  it("renders input field", () => {
    render(<Input placeholder="Enter text" />);
    expect(screen.getByPlaceholderText("Enter text")).toBeInTheDocument();
  });

  it("renders with label", () => {
    render(<Input label="Email" />);
    expect(screen.getByLabelText("Email")).toBeInTheDocument();
  });

  it("renders with error message", () => {
    render(<Input error="This field is required" />);
    expect(screen.getByText("This field is required")).toBeInTheDocument();
  });

  it("applies error styles when error is present", () => {
    render(<Input error="Error" />);
    const input = screen.getByRole("textbox");
    expect(input).toHaveClass("border-red-500");
  });

  it("renders different input types", () => {
    const { rerender } = render(<Input type="email" />);
    expect(screen.getByRole("textbox")).toHaveAttribute("type", "email");

    rerender(<Input type="password" />);
    const passwordInput = document.querySelector('input[type="password"]');
    expect(passwordInput).toBeInTheDocument();
  });

  it("can be disabled", () => {
    render(<Input disabled />);
    const input = screen.getByRole("textbox");
    expect(input).toBeDisabled();
  });

  it("links label to input with correct id", () => {
    render(<Input label="Username" />);
    const input = screen.getByLabelText("Username");
    expect(input).toHaveAttribute("id", "username");
  });
});

import "./globals.css";
import type { Metadata } from "next";

export const metadata: Metadata = {
  title: "Firebase SSR Template",
  description: "A Next.js SSR app powered by Firebase App Hosting",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
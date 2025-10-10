"use client";

import "./globals.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <head>
        <title>my-awesome-project</title>
        <meta name="description" content="A Next.js app powered by Firebase" />
      </head>
      <body>{children}</body>
    </html>
  );
}

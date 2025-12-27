/**
 * Architectural Tests: Dependency Rules
 * 
 * These tests validate that the hexagonal architecture is maintained.
 * They ensure proper dependency direction and separation of concerns.
 */

import * as fs from 'fs';
import * as path from 'path';

/**
 * Get all TypeScript files in a directory recursively
 */
function getTypeScriptFiles(dir: string, fileList: string[] = []): string[] {
  const files = fs.readdirSync(dir);

  files.forEach((file) => {
    const filePath = path.join(dir, file);
    const stat = fs.statSync(filePath);

    if (stat.isDirectory()) {
      if (!file.startsWith('.') && file !== 'node_modules' && file !== 'out') {
        getTypeScriptFiles(filePath, fileList);
      }
    } else if (file.endsWith('.ts') || file.endsWith('.tsx')) {
      fileList.push(filePath);
    }
  });

  return fileList;
}

/**
 * Get imports from a TypeScript file
 */
function getImports(filePath: string): string[] {
  const content = fs.readFileSync(filePath, 'utf-8');
  const importRegex = /import\s+.*?\s+from\s+['"](.+?)['"]/g;
  const imports: string[] = [];
  let match;

  while ((match = importRegex.exec(content)) !== null) {
    imports.push(match[1]);
  }

  return imports;
}

/**
 * Check if a file imports from a forbidden path
 */
function importsFromPath(filePath: string, forbiddenPath: string): boolean {
  const imports = getImports(filePath);
  return imports.some((imp) => imp.includes(forbiddenPath));
}

describe('Hexagonal Architecture: Dependency Rules', () => {
  const srcDir = path.join(process.cwd(), 'src');

  describe('Domain Layer Independence', () => {
    it('domain layer should not import from adapters', () => {
      const domainDir = path.join(srcDir, 'domain');
      if (!fs.existsSync(domainDir)) {
        console.warn('Domain directory does not exist yet');
        return;
      }

      const domainFiles = getTypeScriptFiles(domainDir);
      const violations: string[] = [];

      domainFiles.forEach((file) => {
        if (importsFromPath(file, 'adapters')) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Domain layer files importing from adapters:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });

    it('domain layer should not import from application', () => {
      const domainDir = path.join(srcDir, 'domain');
      if (!fs.existsSync(domainDir)) {
        console.warn('Domain directory does not exist yet');
        return;
      }

      const domainFiles = getTypeScriptFiles(domainDir);
      const violations: string[] = [];

      domainFiles.forEach((file) => {
        if (importsFromPath(file, 'application')) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Domain layer files importing from application:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });

    it('domain layer should not import from components or app', () => {
      const domainDir = path.join(srcDir, 'domain');
      if (!fs.existsSync(domainDir)) {
        console.warn('Domain directory does not exist yet');
        return;
      }

      const domainFiles = getTypeScriptFiles(domainDir);
      const violations: string[] = [];

      domainFiles.forEach((file) => {
        if (importsFromPath(file, 'components') || importsFromPath(file, 'app')) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Domain layer files importing from components/app:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });

    it('domain layer should not import framework-specific code', () => {
      const domainDir = path.join(srcDir, 'domain');
      if (!fs.existsSync(domainDir)) {
        console.warn('Domain directory does not exist yet');
        return;
      }

      const domainFiles = getTypeScriptFiles(domainDir);
      const violations: string[] = [];

      domainFiles.forEach((file) => {
        const imports = getImports(file);
        const hasFrameworkImports = imports.some(
          (imp) =>
            imp.includes('react') ||
            imp.includes('next') ||
            imp.includes('firebase') ||
            imp.includes('aws-sdk')
        );

        if (hasFrameworkImports) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Domain layer files importing framework-specific code:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });
  });

  describe('Application Layer Independence', () => {
    it('application layer should not import from adapters', () => {
      const applicationDir = path.join(srcDir, 'application');
      if (!fs.existsSync(applicationDir)) {
        console.warn('Application directory does not exist yet');
        return;
      }

      const applicationFiles = getTypeScriptFiles(applicationDir);
      const violations: string[] = [];

      applicationFiles.forEach((file) => {
        if (importsFromPath(file, 'adapters')) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Application layer files importing from adapters:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });

    it('application layer should not import from components or app', () => {
      const applicationDir = path.join(srcDir, 'application');
      if (!fs.existsSync(applicationDir)) {
        console.warn('Application directory does not exist yet');
        return;
      }

      const applicationFiles = getTypeScriptFiles(applicationDir);
      const violations: string[] = [];

      applicationFiles.forEach((file) => {
        if (importsFromPath(file, 'components') || importsFromPath(file, 'app')) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Application layer files importing from components/app:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });
  });

  describe('Adapter Layer Compliance', () => {
    it('adapters should implement port interfaces', () => {
      const adaptersDir = path.join(srcDir, 'adapters');
      if (!fs.existsSync(adaptersDir)) {
        console.warn('Adapters directory does not exist yet');
        return;
      }

      const adapterFiles = getTypeScriptFiles(adaptersDir).filter((f) =>
        f.includes('.adapter.')
      );
      const violations: string[] = [];

      adapterFiles.forEach((file) => {
        const imports = getImports(file);
        const importsPorts = imports.some((imp) => imp.includes('domain/ports'));

        if (!importsPorts) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Adapter files not importing port interfaces:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });
  });

  describe('Component Layer Compliance', () => {
    it('components should not import adapters directly', () => {
      const componentsDir = path.join(srcDir, 'components');
      const appDir = path.join(srcDir, 'app');
      
      const componentFiles: string[] = [];
      if (fs.existsSync(componentsDir)) {
        componentFiles.push(...getTypeScriptFiles(componentsDir));
      }
      if (fs.existsSync(appDir)) {
        componentFiles.push(...getTypeScriptFiles(appDir));
      }

      if (componentFiles.length === 0) {
        console.warn('No component files found');
        return;
      }

      const violations: string[] = [];

      componentFiles.forEach((file) => {
        const imports = getImports(file);
        const importsAdapters = imports.some(
          (imp) => imp.includes('adapters') && !imp.includes('factory')
        );

        if (importsAdapters) {
          violations.push(file);
        }
      });

      if (violations.length > 0) {
        console.error('Component files importing adapters directly:');
        violations.forEach((v) => console.error(`  - ${v}`));
      }

      expect(violations).toHaveLength(0);
    });
  });
});

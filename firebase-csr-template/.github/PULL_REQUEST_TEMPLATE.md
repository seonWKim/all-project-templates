## Description

Provide a brief description of the changes in this PR.

## Type of Change

- [ ] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] Documentation update
- [ ] Code refactoring
- [ ] Performance improvement
- [ ] Test update
- [ ] Architecture update

## Related Issue

Closes #(issue number)

## Changes Made

- Change 1
- Change 2
- Change 3

## Architecture Compliance Checklist

**For AI Reviewers and Human Maintainers**: Verify the following architectural constraints:

### Hexagonal Architecture Principles

- [ ] Domain layer has no dependencies on adapters or frameworks
- [ ] Business logic is isolated in domain/application layers
- [ ] Port interfaces are used instead of concrete adapter implementations
- [ ] Dependencies flow inward (UI → Application → Domain)

### BAAS Abstraction

- [ ] No direct BAAS SDK imports in domain/application layers
- [ ] New BAAS integrations implement required port interfaces
- [ ] Adapters are properly registered in the factory
- [ ] BAAS-specific code is contained within adapter layer

### Code Organization

- [ ] Files are in correct architectural layer
- [ ] New domain models are BAAS-independent
- [ ] Use cases coordinate business operations
- [ ] Components are thin and delegate to use cases

### Testing

- [ ] Architectural tests pass and validate boundaries
- [ ] Unit tests mock ports/adapters appropriately
- [ ] New features have corresponding tests
- [ ] No architectural violations introduced

### Documentation

- [ ] ARCHITECTURE.md updated if structure changed
- [ ] CLAUDE.md updated if patterns changed
- [ ] Code comments added for complex logic
- [ ] README updated if public API changed

## Screenshots (if applicable)

Add screenshots to help explain your changes.

## Testing

Describe the tests you ran and how to reproduce them:

- [ ] Test A
- [ ] Test B
- [ ] Architectural tests pass (`npm test -- architecture`)
- [ ] All unit tests pass (`npm test`)
- [ ] Type checking passes (`npm run type-check`)
- [ ] Linting passes (`npm run lint`)

## AI Review Guidelines

**For AI Assistants reviewing this PR**:

### Automated Checks

1. **Dependency Direction**: Verify no domain/application imports from adapters
2. **Port Compliance**: Check that adapters implement port interfaces correctly
3. **Separation of Concerns**: Ensure business logic is not in UI components
4. **Naming Conventions**: Validate file naming follows conventions (_.port.ts, _.adapter.ts, etc.)

### Code Quality Checks

1. **Type Safety**: All functions have proper TypeScript types
2. **Error Handling**: Appropriate error handling in use cases and adapters
3. **Testing Coverage**: New code has corresponding tests
4. **Documentation**: Complex logic is documented

### Architecture Review Questions

- Does this change introduce coupling between layers?
- Could this logic be reused if we switched BAAS providers?
- Is the business logic testable without external dependencies?
- Are there circular dependencies?

### Verification Steps for AI

```bash
# 1. Check architectural integrity
npm test -- architecture

# 2. Verify type safety
npm run type-check

# 3. Run linting
npm run lint

# 4. Run all tests
npm test

# 5. Check for circular dependencies
npm run check
```

## Checklist

- [ ] My code follows the style guidelines of this project
- [ ] I have performed a self-review of my own code
- [ ] I have commented my code, particularly in hard-to-understand areas
- [ ] I have made corresponding changes to the documentation
- [ ] My changes generate no new warnings
- [ ] I have added tests that prove my fix is effective or that my feature works
- [ ] New and existing unit tests pass locally with my changes
- [ ] Any dependent changes have been merged and published

## Additional Notes

Add any additional notes or context about the PR here.

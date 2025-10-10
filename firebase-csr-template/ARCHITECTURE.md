# Architecture Overview

This document describes the architecture of the project template.

## Tech Stack

- **Frontend**: Next.js 15 (App Router) + React + TypeScript (CSR/Static Export Only)
- **Styling**: Tailwind CSS
- **Backend**: Firebase
  - Authentication (client-side SDK)
  - Firestore Database (client-side SDK)
  - Cloud Functions (backend services)
  - Storage (client-side SDK)
  - Cloud Messaging (client-side SDK)
  - Hosting (static files)
- **Testing**: Jest
- **Code Quality**: ESLint + Prettier
- **AI Assistance**: Claude Code with specialized agents

## Rendering Strategy

This template uses **Client-Side Rendering (CSR)** exclusively with Next.js static export:
- All pages are pre-built as static HTML/CSS/JS
- No server-side rendering (SSR) or API routes
- All dynamic functionality runs in the browser
- Firebase client SDKs handle all backend communication
- Deployed as static files to Firebase Hosting

## Directory Structure

```
├── .claude/                  # Claude Code configuration
│   ├── agents/              # Specialized AI agents
│   └── settings.local.json  # Local settings
├── .github/                 # GitHub configuration
│   └── workflows/           # CI/CD workflows
├── functions/               # Firebase Cloud Functions
│   └── src/
│       └── index.ts        # Functions entry point
├── public/                  # Static assets
├── src/
│   ├── app/                # Next.js App Router
│   │   ├── layout.tsx      # Root layout
│   │   ├── page.tsx        # Home page
│   │   ├── globals.css     # Global styles
│   │   ├── api/            # API routes
│   │   ├── robots.ts       # Robots.txt
│   │   └── sitemap.ts      # Sitemap
│   ├── components/         # React components
│   │   └── providers/      # Context providers
│   ├── contexts/           # React contexts
│   ├── hooks/              # Custom hooks
│   ├── lib/                # Utilities and services
│   │   ├── firebase.ts     # Firebase initialization
│   │   ├── utils.ts        # Utility functions
│   │   └── __tests__/      # Test files
│   └── types/              # TypeScript types
├── firebase.json           # Firebase configuration
├── .firebaserc             # Firebase projects
├── firestore.rules         # Firestore security rules
├── firestore.indexes.json  # Firestore indexes
└── package.json            # Dependencies and scripts
```

## Data Flow

### Authentication Flow (Client-Side)

```
User → Browser (React) → Firebase Auth SDK → Firebase Auth Service
                                           ↓
                                    Cloud Functions (triggers)
```

1. User interacts with the UI in the browser
2. React app calls Firebase Auth SDK methods (client-side)
3. Firebase Auth SDK communicates with Firebase Auth Service
4. User state updates in React app
5. Protected routes check auth state in React
6. Optional: Cloud Functions triggered on auth events (server-side)

### Data Access Flow (Client-Side)

```
User → Browser (React) → Firestore SDK → Security Rules → Firestore Database
                                                        ↓
                                                 Cloud Functions (triggers)
```

1. User requests data through the UI
2. React app queries Firestore SDK directly (client-side)
3. Firestore security rules validate access (server-side)
4. Data returned to browser
5. React app updates UI
6. Optional: Cloud Functions triggered on data changes (server-side)

### Cloud Functions Communication

```
Browser (React) → Firebase Callable Functions → Cloud Function
                                              ↓
                                       Firebase Services
```

1. React app calls Firebase callable function
2. Cloud Function processes request with backend logic
3. Cloud Function accesses Firebase services with admin privileges
4. Response returned to browser
5. React app handles response

## Firebase Services

### Authentication

- Email/Password authentication
- Google Sign-In
- OAuth providers
- Anonymous auth
- Custom tokens

### Firestore Database

- NoSQL document database
- Real-time updates
- Offline support
- Security rules for access control
- Composite indexes for complex queries

### Cloud Functions

- HTTP functions for APIs
- Firestore triggers for data events
- Scheduled functions for cron jobs
- Callable functions for client calls
- Auth triggers for user events

### Storage

- File uploads and downloads
- Secure access rules
- CDN-backed delivery
- Image optimization (optional)

### Cloud Messaging

- Push notifications
- Topic-based messaging
- Device group messaging
- Message scheduling

### Hosting

- Static site hosting
- Automatic SSL
- CDN distribution
- URL rewrites
- Custom domains

## Environment Management

### Development Environment

- `.env.development` for local development
- Firebase dev project
- Local emulators (optional)
- Development Firebase credentials

### Production Environment

- `.env.production` for production builds
- Firebase prod project
- Production Firebase credentials
- Stricter security rules

## Security

### Client-Side Security

- Firebase Auth for user authentication
- Firestore security rules for data access
- Input validation and sanitization
- HTTPS-only communication

### Server-Side Security

- Firebase Admin SDK with elevated permissions
- API route authentication
- Rate limiting (implement as needed)
- CORS configuration

### Best Practices

- Never expose admin credentials
- Use security rules for all Firestore collections
- Validate all user inputs
- Implement proper error handling
- Use environment variables for secrets
- Enable Firebase App Check

## Performance

### Optimization Strategies

- Static generation where possible
- Dynamic imports for code splitting
- Image optimization
- Lazy loading components
- Caching strategies
- Firebase query optimization

### Monitoring

- Firebase Performance Monitoring
- Firebase Analytics
- Error tracking
- Cloud Functions monitoring
- Hosting metrics

## Testing Strategy

### Unit Tests

- Test utility functions
- Test custom hooks
- Test Firebase service wrappers
- Mock Firebase SDK in tests

### Integration Tests

- Test API routes
- Test Firebase interactions
- Test auth flows
- Test data operations

### End-to-End Tests

- Test user flows
- Test authentication
- Test CRUD operations
- Test error scenarios

## Deployment

### Build Process

1. Install dependencies
2. Run type checking
3. Run linting
4. Run tests
5. Build Next.js app
6. Build Cloud Functions

### Deployment Process

1. Deploy security rules
2. Deploy indexes
3. Deploy Cloud Functions
4. Deploy hosting (static export)
5. Verify deployment

### CI/CD

- GitHub Actions for automated testing
- Automated deployments on merge
- Environment-specific deployments
- Rollback capability

## Scalability Considerations

### Database

- Denormalize data where appropriate
- Use subcollections for nested data
- Implement pagination
- Cache frequently accessed data
- Use composite indexes wisely

### Functions

- Keep functions small and focused
- Use connection pooling
- Implement retry logic
- Monitor cold starts
- Optimize bundle size

### Frontend

- Code splitting by route
- Lazy load heavy components
- Implement virtual scrolling
- Optimize images and assets
- Use service workers (PWA)

## Future Enhancements

- PWA support
- Internationalization (i18n)
- Advanced caching strategies
- Background sync
- Offline-first architecture
- GraphQL layer (optional)
- Server-side rendering (optional)
- Edge functions (optional)

## References

- [Next.js Documentation](https://nextjs.org/docs)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)
- [TypeScript Documentation](https://www.typescriptlang.org/docs)

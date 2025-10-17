# Claude Code Setup Template

A reusable template for configuring Claude Code in your projects.

## What's Included

```
claude-setup/
├── .claude/
│   ├── settings.json              # Project-wide permissions and hooks
│   ├── settings.local.json        # Personal settings (git-ignored)
│   ├── agents/                    # Specialized AI agents
│   │   ├── code-reviewer.md       # Code review specialist
│   │   └── feature-developer.md   # Feature implementation specialist
│   └── commands/                  # Custom slash commands
│       ├── review.md              # /review - Code review
│       ├── test.md                # /test - Run tests
│       └── setup.md               # /setup - Project setup
├── .mcp.json                      # MCP servers configuration
├── CLAUDE.md                      # Project context and guidelines
└── README.md                      # This file
```

## How to Use

### Option 1: Copy to Existing Project

```bash
# From your project root
cp -r /path/to/claude-setup/.claude .
cp /path/to/claude-setup/.mcp.json .
cp /path/to/claude-setup/CLAUDE.md .
```

### Option 2: Copy Individual Components

Copy only what you need:

```bash
# Just agents
cp -r /path/to/claude-setup/.claude/agents .claude/

# Just commands
cp -r /path/to/claude-setup/.claude/commands .claude/

# Just settings
cp /path/to/claude-setup/.claude/settings.json .claude/
```

### Option 3: Start New Project with Template

```bash
# Create new project with template
mkdir my-new-project
cd my-new-project
cp -r /path/to/claude-setup/.claude .
cp /path/to/claude-setup/.mcp.json .
cp /path/to/claude-setup/CLAUDE.md .
```

## Customization

### 1. Update CLAUDE.md

Edit `CLAUDE.md` with your project-specific information:
- Project overview and goals
- Architecture and tech stack
- Coding standards and conventions
- Common workflows
- Team preferences

### 2. Configure settings.json

Adjust permissions in `.claude/settings.json`:
- `autoApproveTools`: Tools that don't require approval
- `permissions.allow`: Allowed bash commands
- `permissions.deny`: Blocked commands
- `hooks`: Custom hooks for automation

### 3. Customize Agents

Modify or create new agents in `.claude/agents/`:
- Edit frontmatter (name, description, tools, color)
- Customize system prompts
- Add project-specific expertise

### 4. Add Custom Commands

Create slash commands in `.claude/commands/`:
- Add `.md` files (filename becomes command name)
- Use frontmatter for description and allowed_tools
- Write command prompt in markdown body

### 5. Configure MCP Servers (Optional)

If you use MCP servers, edit `.mcp.json`:
- Add server configurations
- Set environment variables
- Enable/disable servers

## File Descriptions

### .claude/settings.json
Project-wide settings shared with your team. Commit this to version control.

**Key sections:**
- `autoApproveTools`: Tools that execute without approval
- `permissions`: Granular control over bash commands
- `hooks`: Automation triggers (e.g., pre-commit checks)

### .claude/settings.local.json
Personal overrides not committed to git. Add to `.gitignore`:

```bash
echo ".claude/settings.local.json" >> .gitignore
```

### .claude/agents/
Specialized AI assistants with focused expertise. Each agent:
- Has a specific role and capabilities
- Can access limited or full tools
- Follows custom instructions
- Can be invoked via Task tool

### .claude/commands/
Custom slash commands for common tasks. Each command:
- Is a markdown file with optional frontmatter
- Can restrict tool access
- Can accept arguments
- Provides reusable prompts

### CLAUDE.md
Project memory that Claude reads for context. Include:
- Architecture overview
- Coding standards
- Common workflows
- Project-specific conventions
- Important gotchas

### .mcp.json
Model Context Protocol servers for extended capabilities. Configure:
- External tool servers
- API integrations
- Custom data sources

## Best Practices

### 1. Start Simple
Begin with the basic template and add complexity as needed.

### 2. Document Everything
Keep CLAUDE.md up to date with project evolution.

### 3. Version Control
Commit `.claude/` to git (except `settings.local.json`).

### 4. Team Alignment
Discuss and agree on settings and agents with your team.

### 5. Regular Updates
Review and update agents and commands as project needs change.

## Git Configuration

Add to `.gitignore`:

```gitignore
# Claude Code personal settings
.claude/settings.local.json
```

Keep these committed:
```gitignore
# Claude Code shared configuration (commit these)
.claude/settings.json
.claude/agents/
.claude/commands/
.mcp.json
CLAUDE.md
```

## Examples

### Using Agents

```bash
# In Claude Code conversation
"Use the code-reviewer agent to review the auth module"
"Use the feature-developer agent to implement user profile feature"
```

### Using Commands

```bash
# In Claude Code
/review              # Review recent changes
/test                # Run test suite
/setup               # Set up project from scratch
```

### Namespaced Commands

Create subdirectories for organized commands:

```bash
mkdir -p .claude/commands/backend
mkdir -p .claude/commands/frontend

# Then create commands like:
# .claude/commands/backend/migrate.md → /backend/migrate
# .claude/commands/frontend/component.md → /frontend/component
```

## Resources

- [Claude Code Documentation](https://docs.claude.com/en/docs/claude-code)
- [Settings Guide](https://docs.claude.com/en/docs/claude-code/settings.md)
- [Slash Commands](https://docs.claude.com/en/docs/claude-code/slash-commands.md)
- [MCP Configuration](https://docs.claude.com/en/docs/claude-code/mcp.md)

## Troubleshooting

### Claude doesn't recognize my settings
- Ensure files are at project root, not in subdirectories
- Check JSON syntax with a validator
- Restart Claude Code CLI

### Agents not appearing
- Verify YAML frontmatter is valid
- Check that files are in `.claude/agents/`
- Ensure proper file extension (`.md`)

### Commands not working
- Verify file is in `.claude/commands/`
- Check frontmatter syntax
- Ensure command name doesn't conflict with built-in commands

## Contributing

Feel free to customize this template for your organization's needs!

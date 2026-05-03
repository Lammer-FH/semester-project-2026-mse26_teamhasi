
# AI Usage Guidance

Document AI-assisted work in [AI_USAGE_LOG.md](AI_USAGE_LOG.md).

Guidelines:
- Record every meaningful AI use, including code, design, documentation, tests, and analysis.
- Keep each entry short and factual.
- Add a new entry for each separate AI interaction that influenced the project.
- Undocumented AI use may be treated as academic dishonesty under the assignment rules.

Format for entries in [AI_USAGE_LOG.md](AI_USAGE_LOG.md):
- Date: YYYY-MM-DD HH:MM
- Tool: tool or model used
- Prompt / Task: full prompt or a concise task description
- Purpose: why AI was used
- Output Summary: what the AI produced
- Acceptance: accepted, modified, or rejected
- Files Changed: affected files
- Notes: anything important about the result or follow-up

Example entry:
- Date: 2026-05-03 10:12
- Tool: ChatGPT
- Prompt / Task: Create a concise `Agents.md` summarizing project scope and AI documentation requirements based on the provided PDFs.
- Purpose: Add project onboarding context and AI policy documentation.
- Output Summary: Created `Agents.md` with project context, technical scope, goals, and AI documentation rules.
- Acceptance: Accepted with minor edits
- Files Changed: [Agents.md](Agents.md)
- Notes: This log is the place to record future AI-assisted work.

Use [AI_USAGE_LOG.md](AI_USAGE_LOG.md) as the working log; keep this file as the policy summary.

## Process Documentation: Requirements and Issue Creation

This section documents the workflow used to derive project requirements and create milestone issues.

### 1) Requirements Extraction Workflow

- Source material was reviewed from the project specification and assignment documents.
- Requirements were extracted from user stories U1-U5.
- Each requirement was normalized into a structured row with:
	- ID (e.g., REQ-001)
	- User story reference (U1-U5)
	- Type (Functional / Non-Functional)
	- Category (e.g., API, UX, State Management)
	- Requirement text
	- Domain object mapping (Hotel, Room, Booking, User, Availability, Extra, System)
	- Implementation label hint (frontend / backend / planning)
- Output artifact: [deliverables/ms1/REQUIREMENTS.csv](deliverables/ms1/REQUIREMENTS.csv)

### 2) Backlog Creation Workflow (MS1 and MS2)

- The requirements table was used as the traceability baseline.
- Backlog items were split into small-to-medium implementation chunks.
- Each backlog item includes:
	- Milestone and scope
	- Description
	- Requirements addressed (REQ IDs)
	- Acceptance criteria (checkbox format)
	- Dependencies and implementation hints
- Output artifacts:
	- MS1 backlog files in [deliverables/ms1/backlog](deliverables/ms1/backlog)
	- MS2 backlog files in [deliverables/ms2/backlog](deliverables/ms2/backlog)

### 3) GitHub Issue Creation Workflow

- Backlog markdown files were converted into GitHub issues using `gh issue create`.
- Issue titles mirror backlog item titles (MS1-xx / MS2-xx).
- Issue body content was copied from backlog files to preserve acceptance criteria and requirement traceability.
- For MS2 creation, issues were explicitly created without labels as requested.
- Duplicate issues created during interrupted CLI runs were cleaned up to keep one canonical issue per backlog item.

### 4) Traceability Rule

- Every issue should reference requirement IDs from [deliverables/ms1/REQUIREMENTS.csv](deliverables/ms1/REQUIREMENTS.csv).
- Any new requirement discovered during implementation should first be added to the requirements table, then linked in issue updates.
- All meaningful AI assistance steps in this workflow must be recorded in [AI_USAGE_LOG.md](AI_USAGE_LOG.md).

# AI Usage Log

Record each meaningful AI-assisted action here.

Entry format:
- Date: YYYY-MM-DD HH:MM
- Tool: tool or model used
- Prompt / Task: full prompt or a concise task description
- Purpose: why AI was used
- Output Summary: what the AI produced
- Acceptance: accepted, modified, or rejected
- Files Changed: affected files
- Notes: anything important about the result or follow-up

Entries:
- Date: 2026-05-03 10:12
- Tool: GitHub Copilot (Claude Haiku)
- Prompt / Task: Create a concise `Agents.md` summarizing project scope and AI documentation requirements based on the provided PDFs.
- Purpose: Add project onboarding context and AI policy documentation.
- Output Summary: Created `Agents.md` with project context, technical scope, goals, and AI documentation rules.
- Acceptance: Accepted with minor edits
- Files Changed: [Agents.md](Agents.md)
- Notes: Initial AI-assisted project context document.

- Date: 2026-05-03 10:24
- Tool: GitHub Copilot (Claude Haiku)
- Prompt / Task: Split AI usage policy from the working log, simplify the policy file, and create a separate AI usage log file.
- Purpose: Separate policy guidance from actual AI activity records.
- Output Summary: Updated `AI_USAGE.md`, `Agents.md`, and created `AI_USAGE_LOG.md`.
- Acceptance: Accepted
- Files Changed: [AI_USAGE.md](AI_USAGE.md), [Agents.md](Agents.md), [AI_USAGE_LOG.md](AI_USAGE_LOG.md)
- Notes: Created the dedicated log file requested by the user.

- Date: 2026-05-03 10:31
- Tool: GitHub Copilot (Claude Haiku)
- Prompt / Task: Restore the example and format in `AI_USAGE.md` and add actual log entries for the AI work already done.
- Purpose: Make the policy file self-contained while keeping the working log separate.
- Output Summary: Reintroduced the entry format and example in `AI_USAGE.md` and appended concrete log entries in this file.
- Acceptance: Accepted
- Files Changed: [AI_USAGE.md](AI_USAGE.md), [AI_USAGE_LOG.md](AI_USAGE_LOG.md)
- Notes: This entry documents the current clarification request and update.

- Date: 2026-05-03 22:02
- Tool: GitHub Copilot (Claude Haiku)
- Prompt / Task: Extract all requirements from user stories U1-U5 into a structured CSV mapping functional and non-functional requirements to domain objects and user stories. Then create MS1 planning backlog items (API spec, database model, UI prototypes, engineering standards) as individual markdown files for GitHub issue creation.
- Purpose: Establish clear requirements baseline and create actionable MS1 planning backlog.
- Output Summary: Created `REQUIREMENTS.csv` (73 rows) mapping all requirements to domain objects (Hotel, Room, Booking, User, Availability, Extra), and created 4 MS1 planning backlog markdown files: MS1-01-api-specification.md, MS1-02-database-model.md, MS1-03-ui-prototypes.md, MS1-04-engineering-standards.md
- Acceptance: Accepted
- Files Changed: [deliverables/ms1/REQUIREMENTS.csv](deliverables/ms1/REQUIREMENTS.csv), [deliverables/ms1/backlog/MS1-01-api-specification.md](deliverables/ms1/backlog/MS1-01-api-specification.md), [deliverables/ms1/backlog/MS1-02-database-model.md](deliverables/ms1/backlog/MS1-02-database-model.md), [deliverables/ms1/backlog/MS1-03-ui-prototypes.md](deliverables/ms1/backlog/MS1-03-ui-prototypes.md), [deliverables/ms1/backlog/MS1-04-engineering-standards.md](deliverables/ms1/backlog/MS1-04-engineering-standards.md)
- Notes: All MS1 planning items use consistent markdown format with title, milestone, type, labels, requirements addressed, acceptance criteria, dependencies, implementation hints, and affected user stories. Each item directly convertible to GitHub issue via gh CLI.

- Date: 2026-05-03 22:15
- Tool: GitHub Copilot (Claude Haiku) + gh CLI
- Prompt / Task: Create GitHub issues from the 4 MS1 planning markdown files, then mark all issues as in-progress by applying "in-progress" label.
- Purpose: Establish GitHub-based tracking for MS1 foundation work and set initial workflow state.
- Output Summary: Successfully created 4 GitHub issues (#1-#4) from MS1 backlog items, created "in-progress" label, and applied it to all issues. Issues now visible in GitHub project with full descriptions from markdown files.
- Acceptance: Accepted
- Files Changed: None (GitHub repository operation)
- Notes: GitHub issues #1-#4 created and labeled with "in-progress"; all issues now visible at https://github.com/Lammer-FH/semester-project-2026-mse26_teamhasi/issues with full body text from markdown files. Ready for team assignment and development work.

- Date: 2026-05-27 19:06
- Tool: GitHub Copilot (GPT-5.4 mini)
- Prompt / Task: Review the frontend hotel application and suggest how to split it into more reusable components.
- Purpose: Document AI-assisted review work in the project log.
- Output Summary: Analyzed the main Vue pages and existing shared components, then prepared a component-splitting review with concrete reuse suggestions.
- Acceptance: Accepted
- Files Changed: [AI_USAGE_LOG.md](AI_USAGE_LOG.md)
- Notes: This log entry records the review-only assistance for the frontend component structure.

- Date: 2026-05-27 19:30
- Tool: GitHub Copilot (GPT-5.4 mini)
- Prompt / Task: Replace the home-page map placeholder with an OpenStreetMap iframe and update all frontend address occurrences to Höchstädtplatz 1, 1200 Wien.
- Purpose: Keep the hotel contact/location copy consistent and use a lightweight embedded map.
- Output Summary: Updated the home page with an OpenStreetMap embed and replaced visible address strings in the home, about, imprint, and footer components.
- Acceptance: Accepted
- Files Changed: [frontend/src/views/HomePage.vue](frontend/src/views/HomePage.vue), [frontend/src/views/AboutPage.vue](frontend/src/views/AboutPage.vue), [frontend/src/views/ImprintPage.vue](frontend/src/views/ImprintPage.vue), [frontend/src/components/organisms/SiteFooter.vue](frontend/src/components/organisms/SiteFooter.vue)
- Notes: The map uses an embedded OpenStreetMap view centered on Höchstädtplatz 1.

- Date: 2026-06-06 00:00
- Tool: Claude Code (claude-sonnet-4-6)
- Prompt / Task: Review implementation of U4 booking flow (BookingPage, BookingForm, BookingReview, BookingConfirmation, bookingStore, router route, AvailabilityModal book button, RoomsPage navigation). Run a clean code review with --fix on all new/modified files.
- Purpose: Implement user story U4 (hotel room booking) and review the resulting code for clean code issues.
- Output Summary: Code review surfaced 2 confirmed issues: (1) duplicate nights calculation in BookingForm and BookingReview — fixed by extracting to src/utils/nightsBetween.ts; (2) room lookup after fetchFeatured() only searched featured array — fixed to also fall back to roomStore.rooms.
- Acceptance: Accepted
- Files Changed: [frontend/src/views/BookingPage.vue](frontend/src/views/BookingPage.vue), [frontend/src/components/organisms/BookingForm.vue](frontend/src/components/organisms/BookingForm.vue), [frontend/src/components/organisms/BookingReview.vue](frontend/src/components/organisms/BookingReview.vue), [frontend/src/utils/nightsBetween.ts](frontend/src/utils/nightsBetween.ts)
- Notes: This entry logs Claudes AI code review for altered and new files.
**Agents — Project Context & AI Usage**

This document summarizes the project context, technical scope, goals, and how AI should be documented and used for the semester project. It draws on the project specification and assignment documents provided in `docs/ProjektSpezifikation2026.pdf` and `docs/project-assignment2026.pdf`.

**Project Context**:
- **Project**: Hotel Booking Interface for the Boutique Hotel Technikum.
- **Purpose**: Provide a mobile-first booking Single Page Application (SPA) enabling guests to view rooms, check availability, and make bookings; includes static marketing pages.
- **Users**: Hotel guests on mobile devices and desktops; internal staff may use exported booking information.

**Technical Scope**:
- **Frontend**: Ionic + Vue 3, mobile-first, modular design (Atomic Design recommended), Pinia for state management, Axios (or fetch) for API calls.
- **Backend**: Java + Spring Boot (>= 3); RESTful API following resource-oriented design and Richardson Maturity Model level 2.
- **Database**: MySQL (ER schema required).
- **Other**: Optional Figma prototypes, use GitHub Classroom + Kanban for project management.

**Goals & Deliverables**:
- Milestone 1: API specification, database model, backlog/Kanban, paper/mobile UI prototype.
- Milestone 2: Partial implementation (user stories U1–U3), backend + frontend integration, tests, updated docs.
- Final Delivery: Full implementation (U1–U5), UI/UX quality, clean code, README, presentation.

**Key Functional Requirements (summary)**
- U1: Static hotel pages (landing, imprint, about) and presentation content.
- U2: Room listing with images, extras (icons), pagination (5 rooms/page on first load).
- U3: Check availability for selected period with clear feedback and error handling.
- U4: Booking flow with form validation, review step, booking creation.
- U5: Rich booking confirmation (print-friendly, directions/contact info).

**Engineering Standards & Best Practices**
- Clean Code and Clean Architecture (per course guidance).
- Atomic Design for frontend componentization.
- Pinia for state management.
- Follow the course's best practices, including code reviews, branch-per-feature, and proper PRs.

**Team & Process**
- Team collaboration using GitHub Classroom: issues, branches, PRs, and Kanban board.
- Peer reviews are mandatory for milestones.
- Keep commits meaningful and frequent.

**AI Usage (MANDATORY DOCUMENTATION)**
- All meaningful uses of AI tools must be documented in [AI_USAGE_LOG.md](AI_USAGE_LOG.md).
- Keep [AI_USAGE.md](AI_USAGE.md) as the policy summary and [AI_USAGE_LOG.md](AI_USAGE_LOG.md) as the working log.
- Undocumented AI use that appears in code/reviews/presentation may be considered academic dishonesty per the assignment.

**Where to Find the Source Documents**
- See the original assignment/spec files in `docs/ProjektSpezifikation2026.pdf` and `docs/project-assignment2026.pdf` for full details.

**Quick Links**
- AI usage policy: [AI_USAGE.md](AI_USAGE.md)
- AI usage log: [AI_USAGE_LOG.md](AI_USAGE_LOG.md)

**How to use this file**
- Use this as a quick onboarding summary for any team member or reviewer.
- Keep it updated if the project scope, tech stack, or milestones change.

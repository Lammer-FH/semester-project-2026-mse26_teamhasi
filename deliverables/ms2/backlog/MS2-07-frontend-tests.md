# MS2-07: Testing - Frontend Unit & Component Tests

## Milestone
MS2

## Type
Testing / Quality Assurance

## Description
Create comprehensive unit tests for frontend components (rooms, pagination, availability) and store logic using Jest/Vitest and Vue Test Utils.

## User Story
U1, U2, U3: Ensure component and store functionality through automated tests.

## Requirements Addressed
- Clean Code principles (testability)
- REQ-060: Vue.js 3 framework
- REQ-061: Ionic framework
- REQ-063: Pinia for state management

## Acceptance Criteria
- [ ] Unit tests for all Pinia stores (rooms, availability, hotel)
- [ ] Component tests for RoomCard, RoomList, PaginationControls
- [ ] Component tests for DateDialog, AvailabilityDisplay
- [ ] Navigation component tests
- [ ] Test coverage minimum 80% for all custom components
- [ ] Tests for error scenarios (API failures, validation)
- [ ] Tests pass consistently on CI/CD
- [ ] Snapshot tests for components (where appropriate)
- [ ] Mock Axios responses in tests

## Implementation Hints
- Framework: Jest (or Vitest for faster execution)
- Tool: Vue Test Utils for component testing
- Mock external APIs with jest.mock() or msw (Mock Service Worker)
- Test Pinia stores with createPinia() in test setup
- Organized by feature: __tests__/components/, __tests__/stores/
- CI/CD integration: Run tests on PR
- Coverage report generation

## Dependencies
- MS2-02, MS2-04: Components to test
- MS2-06: Pinia integration
- MS1-04: Engineering standards

# MS2-06: Frontend-Backend Integration & Axios Setup

## Milestone
MS2

## Type
Implementation / Integration

## Description
Set up Axios API client, configure Pinia stores for rooms and availability, and integrate frontend components with backend API endpoints.

## User Story
U2 & U3: Complete integration of room listing and availability checking.

## Requirements Addressed
- REQ-062: Axios for API calls
- REQ-063: Pinia for state management
- REQ-021: API endpoint integration for room retrieval
- REQ-029: API endpoint integration for availability

## Acceptance Criteria
- [ ] Axios instance configured with base URL, interceptors
- [ ] Error handling in Axios (401, 404, 500, etc.)
- [ ] Pinia store(s) created: roomStore, availabilityStore
- [ ] Room store fetches paginated room data
- [ ] Availability store manages check state and results
- [ ] Loading, error, and success states in stores
- [ ] Components consume store data correctly
- [ ] API calls tested end-to-end
- [ ] No hardcoded API URLs in components
- [ ] Error messages propagated to UI

## Implementation Hints
- Create api/axios.js for Axios configuration
- Use Axios interceptors for auth/error handling
- Pinia stores in stores/rooms.js, stores/availability.js
- Actions for API calls, getters for computed state
- Handle race conditions in pagination loading
- Mock API during frontend development if backend not ready

## Dependencies
- MS2-02: Room display components
- MS2-04: Availability UI
- MS2-05: Backend API endpoints

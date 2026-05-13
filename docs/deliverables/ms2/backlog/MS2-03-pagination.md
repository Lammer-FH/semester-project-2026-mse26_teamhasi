# MS2-03: U2 Frontend - Room Pagination

## Milestone
MS2

## Type
Implementation / Frontend

## Description
Implement pagination logic for room display, showing 5 rooms on first load with ability to navigate to additional pages.

## User Story
U2: Room listing with pagination (5 rooms/page on first load).

## Requirements Addressed
- REQ-017: Display maximum 5 rooms on first load
- REQ-018: Support pagination to page 2 and beyond
- REQ-019: Attractive layout for odd number of rooms

## Acceptance Criteria
- [ ] Room listing page displays maximum 5 rooms on first load
- [ ] Pagination controls implemented (Previous/Next buttons)
- [ ] Page indicator showing current page and total pages
- [ ] Odd number of rooms handled attractively in layout
- [ ] URL or state reflects current page
- [ ] Loading state shown while fetching next page
- [ ] Smooth transition between pages
- [ ] Mobile and desktop pagination UX tested

## Implementation Hints
- Integrate with Pinia store for room list state
- Use Ionic Pagination or custom button controls
- REST API endpoint: GET /api/rooms?page=1&limit=5
- Consider infinite scroll as alternative
- State management: currentPage, totalRooms, roomsPerPage

## Dependencies
- MS2-02: Room display components
- MS2-04: Backend room pagination API endpoint
- MS1-04: Engineering standards

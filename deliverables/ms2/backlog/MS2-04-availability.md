# MS2-04: U3 Frontend - Availability Check & Date Selection

## Milestone
MS2

## Type
Implementation / Frontend

## Description
Implement availability check functionality with date period selection dialog, clear user feedback, and error handling.

## User Story
U3: Check availability for selected period with clear feedback and error handling.

## Requirements Addressed
- REQ-024: Check room availability for date period
- REQ-025: Date dialog for period selection
- REQ-026: Clear availability feedback to user
- REQ-027: Error case handling for availability checks
- REQ-028: Support innovative period definition UI
- REQ-030: Pinia store for availability state
- REQ-031: Mobile-first responsive design
- REQ-032: Desktop usability

## Acceptance Criteria
- [ ] Date selection dialog implemented
- [ ] User can select arrival and departure dates
- [ ] Date validation (departure > arrival, future dates)
- [ ] Availability check API called with selected dates
- [ ] Clear success/failure feedback to user
- [ ] No availability message displays available alternatives
- [ ] Error messages user-friendly and actionable
- [ ] Loading state displayed during API call
- [ ] Dialog responsive on mobile and desktop
- [ ] Pinia store manages availability state

## Implementation Hints
- Use Ionic Modal for date dialog
- Ionic DateTime picker component for date selection
- State: selectedRoom, arrivalDate, departureDate, availabilityStatus
- UX: Show calendar with unavailable dates grayed out
- Consider multi-day selection UI patterns (date range picker)
- Error scenarios: Invalid dates, room unavailable, API errors

## Dependencies
- MS2-02: Room display components
- MS2-05: Backend availability API endpoint
- MS1-03: UI prototypes from MS1
- Pinia state management setup

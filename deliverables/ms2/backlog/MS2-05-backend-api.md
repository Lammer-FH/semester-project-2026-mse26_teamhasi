# MS2-05: Backend - Room & Availability API Endpoints

## Milestone
MS2

## Type
Implementation / Backend

## Description
Implement Spring Boot REST API endpoints for room retrieval and availability checking, following Richardson Maturity Model Level 2.

## User Story
U2 & U3: Room listing with pagination and availability checking via API.

## Requirements Addressed
- REQ-021: API endpoint integration for room retrieval
- REQ-029: API endpoint integration for availability
- REQ-064: Spring Boot 3+ for backend
- REQ-065: MySQL database
- REQ-068: Richardson Maturity Model Level 2

## Acceptance Criteria
- [ ] GET /api/rooms endpoint implemented with pagination
- [ ] GET /api/rooms?page=1&limit=5 returns paginated results
- [ ] GET /api/availability endpoint implemented
- [ ] POST /api/availability with room_id, arrival_date, departure_date
- [ ] Endpoints follow REST conventions (proper HTTP methods, status codes)
- [ ] Response JSON includes all required fields (id, title, description, image, extras, price)
- [ ] Error responses include meaningful error messages
- [ ] Database queries optimized (no N+1 problems)
- [ ] API documented in Swagger/OpenAPI format
- [ ] Unit tests for endpoints (min 80% coverage)

## Implementation Hints
- Repository pattern for database access
- Service layer for business logic
- Spring Data JPA for database queries
- Pagination using Spring Data PagingAndSorting Repository
- Availability logic: check Booking table for conflicts
- Exception handling with @ControllerAdvice
- Swagger annotations for API documentation

## Dependencies
- MS1-02: Database schema
- MS1-01: API specification
- Database setup (MySQL with schema)

# MS1-02: Database Model & ER Diagram

**Milestone:** MS1  
**Type:** Planning & Documentation  
**Labels:** `backlog` `MS1` `planning` `documentation` `backend`

## Description

Design and document the database schema including all entities, relationships, constraints, and indexes. Create an ER diagram showing domain objects and their interactions.

## Requirements Addressed

- REQ-065: MySQL database
- REQ-070: Handle 100 visitors per day (performance indexing)
- Functional requirements for Hotel, Room, Availability, Booking, User, Extra

## Acceptance Criteria

- [ ] ER diagram created with all domain entities (Hotel, Room, RoomType, Extra, User, Booking, Availability, Media)
- [ ] Relationships and cardinality clearly marked (1:1, 1:N, M:N)
- [ ] Primary and foreign keys identified
- [ ] Constraints defined (NOT NULL, UNIQUE, CHECK)
- [ ] Performance indexes specified for frequently queried fields
- [ ] SQL schema aligns with API specification
- [ ] ER diagram saved as ER_Diagram.png
- [ ] Database designer reviewed for normalization

## Dependencies

Should complete in parallel with or before MS1-01 (API Specification).

## Implementation Hints

- Start from existing Database_v1.sql and ER_Diagram.png
- Normalize to 3NF
- Index on: room_id, booking_period, user_email, availability dates
- Consider query patterns from U1-U5

## Domain Objects

Hotel, Room, RoomType, Extra, RoomExtraHasRoom, User, Booking, Availability, Media, RoomTypeHasMedia

## Notes

Key MS1 deliverable. Unblocks backend implementation in MS2.

# MS2-08: Testing - Backend API Integration Tests

## Milestone
MS2

## Type
Testing / Quality Assurance

## Description
Create comprehensive integration tests for Spring Boot API endpoints using JUnit 5, Mockito, and TestContainer for database testing.

## User Story
U2 & U3: Ensure API reliability and correctness through automated tests.

## Requirements Addressed
- Clean Code principles (testability)
- REQ-064: Spring Boot 3+ for backend
- REQ-065: MySQL database

## Acceptance Criteria
- [ ] Integration tests for all REST endpoints
- [ ] Tests cover success cases (HTTP 200, 201)
- [ ] Tests cover error cases (400, 404, 500)
- [ ] Database tests with TestContainer (MySQL in Docker)
- [ ] Test coverage minimum 80% for service layer
- [ ] Mock external services where needed
- [ ] Parameterized tests for multiple scenarios
- [ ] Load testing for pagination (1000+ rooms)
- [ ] Tests pass consistently

## Implementation Hints
- Framework: JUnit 5 + Spring Boot Test
- Mocking: Mockito for dependencies
- Database: TestContainer for MySQL isolation
- Test data: SQL scripts or JPA seeding
- Organized: test/resources/schema.sql, test/integration/, test/unit/
- Each test should be independent and repeatable
- Use @DataJpaTest, @WebMvcTest annotations

## Dependencies
- MS2-05: API implementation
- Database schema and seed data

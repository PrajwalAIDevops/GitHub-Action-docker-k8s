# School Website (Java)

This project is a simple “school website” implemented as a **Spring Boot** web application with server-rendered UI (Thymeleaf) and includes both **unit tests** and **integration tests**.

## Tech Stack
- Java 17+
- Spring Boot (Web + Thymeleaf)
- Spring Boot Test + JUnit 5
- H2 (for integration tests)

## Prerequisites
- Java 17 installed
- Maven installed

## Build & Run

### 1) Run tests (unit + integration)
```bash
mvn test
```

### 2) Run the application
```bash
mvn spring-boot:run
```

### 3) Open UI in browser
- Home: http://localhost:8080/
- Students: http://localhost:8080/students
- Courses: http://localhost:8080/courses

## Project Structure
- `src/main/java/...` contains controllers, services, and in-memory repositories.
- `src/test/java/...` contains:
  - unit tests (service layer)
  - integration tests (controller + HTTP via MockMvc)

## Notes
This app is intentionally simple and focused on development/test handover.


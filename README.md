# Student Management System API 🎓

A professional, production-ready REST API built with Java 17 and Spring Boot, featuring a clean, N-tier layered architecture. This repository implements a Student Management System by separating concerns across Controller, Service, Repository, DTO, and Entity layers, ensuring scalability and maintainability. It provides robust endpoints for CRUD operations, integrated with a PostgreSQL database for persistent storage.

---

## 🚀 Key Features
- **Full CRUD Support**: Create, Read, Update, and Delete student profiles.
- **Layered Architecture**: Organized into Controller, Service, and Repository layers for high maintainability.
- **DTO Pattern**: Uses Data Transfer Objects (DTOs) to secure and abstract the database layer.
- **Object Mapping**: Seamless conversion between Entities and DTOs using **ModelMapper**.
- **Database Persistence**: Powered by **Spring Data JPA** with a **PostgreSQL** backend.

---

## 🛠️ Tech Stack
- **Language:** Java 17 (LTS)
- **Framework:** Spring Boot 4.0.1
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA
- **Mapping Tool:** ModelMapper
- **Build Tool:** Maven
- **Libraries:** Lombok (for boilerplate-free code)

---



## Project Structure

- `src/main/java/com/learning/DispatcherServlet/` — application root package
  - `StudentServiceAPI.java` — application entry/servlet bootstrap
  - `config/MapperConfig.java` — object mapping configuration
  - `controller/StudentController.java` — HTTP request handling and routing
  - `dto/` — request/response DTOs (`AddStudentRequestDto`, `StudentDto`)
  - `entity/Student.java` — data model for Student
  - `repository/StudentRepository.java` — data access layer (in-memory or persistence)
  - `service/` — service interfaces and implementations (`StudentService`, `impl/StudentServiceImpl`)

## Requirements

- Java 11+ (or compatible JDK)
- Maven 3.6+

## Build & Run

Build the project using Maven:

```bash
mvnw clean package
```

Run the application (example using the packaged artifact):

```bash
java -jar target/student-management-api.jar
```

If the project uses an embedded servlet container or is deployed to a servlet container, follow the container's deployment steps instead.

## Configuration

Application configuration lives in `src/main/resources/application.properties`.

## API Endpoints

The `StudentController` exposes the primary endpoints. Example endpoints (adjust base path as implemented):

- `POST /students` — add a new student. Accepts `AddStudentRequestDto` JSON.
- `GET /students/{id}` — get student by ID. Returns `StudentDto` JSON.
- `GET /students` — list all students. Returns array of `StudentDto`.

Example `curl` to add a student:

```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Pranshu","email":"pranshu@pranshu.io"}'
```

Example `curl` to list students:

```bash
curl http://localhost:8080/students
```

## Tests

Run unit tests with Maven:

```bash
mvnw test
```

The tests are located under `src/test/java/com/learning/DispatcherServlet/StudentServiceAPITests.java`.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make changes and add tests
4. Open a pull request with a description of your changes


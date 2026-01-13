# Student Management System API 🎓

A professional, production-ready REST API built with **Java 17** and **Spring Boot**. This project demonstrates a clean, layered architecture for managing student records with **PostgreSQL** integration.

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

## 📂 Project Structure
Following the standard N-Tier architecture:
```text
src/main/java/com/learning/DispatcherServlet/
├── config/          # Configuration beans (e.g., ModelMapper)
├── controller/      # REST Endpoints (StudentController)
├── service/         # Business Logic Interface
│   └── impl/        # Service Implementation (StudentServiceImpl)
├── repository/      # Data Access Layer (StudentRepository)
├── entity/          # Database Entities (Student)
└── dto/             # Data Transfer Objects (StudentDto, AddRequestDto)
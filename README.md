# Student Management System - Backend

A robust and scalable RESTful backend application built with **Spring Boot** to manage student records efficiently. This project was developed as part of my practical learning journey to master enterprise backend development, clean architecture, and best practices in Java.

---

## 🚀 Key Learning Objectives & Highlights

* **Enterprise Architecture:** Implemented a clean separation of concerns using Controller, Service, Repository, and DTO layers.
* **Data Transfer & Validation:** Used Data Transfer Objects (DTOs) to decouple internal database entities from external API contracts, complete with input validation.
* **Robust Error Handling:** Built a centralized global exception handler to catch custom errors (like duplicate emails or missing records) and return structured, user-friendly HTTP responses.
* **Database Persistence:** Managed relational data mapping and operations using Spring Data JPA and Hibernate.

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot, Spring Data JPA, Hibernate
* **Database:** MySQL
* **Build Tool:** Apache Maven
* **Testing & Tools:** Postman, Git/GitHub, Intelij Idea

---

## 📂 Project Architecture

```text
src/main/java/com/example/student_management_backend/
│
├── controller/     # Exposes REST endpoints (StudentController)
├── dto/            # Request and Response payload models (StudentRequest, StudentResponse)
├── entity/         # JPA database entities (Student)
├── exception/      # Custom exceptions and GlobalExceptionHandler for error management
├── repository/     # Spring Data JPA interfaces for database interaction (StudentRepository)
└── service/        # Business logic implementation (StudentService)

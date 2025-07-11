# 📓 Journal Entry Web App

A simple and secure web application for writing and managing personal journal entries, built using **Spring Boot**, **MongoDB**, and **Redis**.  
✅ Now fully deployed on Render using Docker.

---

## 🚀 Features

- ✅ User Registration & Login (Spring Security)
- ✅ Create, Read, Update, Delete (CRUD) journal entries
- ✅ Secure password hashing (BCrypt)
- ✅ RESTful APIs using Spring Boot
- ✅ MongoDB document-based storage
- ✅ Timestamped entries
- ✅ Redis Caching for performance
- ✅ Email verification & password recovery
- ✅ API testing with Postman
- ✅ Dockerized for cloud deployment

---

## 🌐 Live Public Endpoint

👉 **Base URL:** [`https://restapi-s6gb.onrender.com`](https://restapi-s6gb.onrender.com)

### 📌 Public API Endpoints

| Method | Endpoint                       | Description                       |
|--------|--------------------------------|-----------------------------------|
| POST   | `/api/auth/register`           | Register a new user               |
| POST   | `/api/auth/login`              | Authenticate user & get token     |
| POST   | `/api/journals`                | Create a new journal entry        |
| GET    | `/api/journals`                | List all entries for user         |
| GET    | `/api/journals/{id}`           | Get a specific entry              |
| PUT    | `/api/journals/{id}`           | Update an entry                   |
| DELETE | `/api/journals/{id}`           | Delete an entry                   |

> ⚠️ Most journal routes require JWT token in the `Authorization: Bearer <token>` header.

---

## 🧑‍💻 Tech Stack

| Layer           | Technology               |
|-----------------|--------------------------|
| Backend         | Java, Spring Boot        |
| Database        | MongoDB Atlas            |
| Security        | Spring Security + JWT    |
| Build Tool      | Gradle                   |
| Caching         | Redis                    |
| Mail Service    | Gmail SMTP (TLS)         |
| Deployment      | Docker + Render          |
| API Testing     | Postman                  |
| Version Control | Git                      |

---

## 🐳 Docker Deployment (Used in Render)

> Render automatically builds using this Dockerfile

### ✅ Dockerfile Overview

```dockerfile
# Build stage
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/build/libs/restAPI-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

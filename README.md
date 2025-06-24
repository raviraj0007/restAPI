# 📓 Journal Entry Web App

A simple and secure web application for writing and managing personal journal entries, built using **Spring Boot** and **MongoDB**.

---

## 🚀 Features

- ✅ User Registration & Login (Spring Security)
- ✅ Create, Read, Update, Delete (CRUD) journal entries
- ✅ Secure password hashing (BCrypt)
- ✅ RESTful APIs using Spring Boot
- ✅ MongoDB document-based storage
- ✅ Timestamped entries
- ✅ Clean and modular code structure

---

## 🧑‍💻 Tech Stack

| Layer        | Technology         |
|--------------|--------------------|
| Backend      | Java, Spring Boot  |
| Database     | MongoDB            |
| Security     | Spring Security + BCrypt |
| API Testing  | Postman            |
| Build Tool   | Maven / Gradle     |

---

## 📌 API Endpoints

| Method | Endpoint             | Description                  |
|--------|----------------------|------------------------------|
| POST   | `/api/auth/register` | Register a new user          |
| POST   | `/api/auth/login`    | Authenticate user & get token|
| POST   | `/api/journals`      | Create a new journal entry   |
| GET    | `/api/journals`      | List all entries             |
| GET    | `/api/journals/{id}` | Get a specific entry         |
| PUT    | `/api/journals/{id}` | Update an entry              |
| DELETE | `/api/journals/{id}` | Delete an entry              |

---

## 🧪 Getting Started

### 🛠 Prerequisites

- Java 17+
- Maven or Gradle
- MongoDB installed locally or use MongoDB Atlas

### 📦 Build and Run

```bash
# Clone the repository
git clone https://github.com/your-username/journal-app.git
cd journal-app

# Run the application (Maven)
./mvnw spring-boot:run

---


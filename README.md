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

## 📁 Project Structure
journal-app/
├── src/
│ ├── main/
│ │ ├── java/com/example/journal/
│ │ │ ├── controller/
│ │ │ ├── service/
│ │ │ ├── repository/
│ │ │ ├── model/
│ │ │ └── config/
│ │ └── resources/
│ │ └── application.properties
├── pom.xml
└── README.md


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

🔧 Configuration
Edit src/main/resources/application.properties:

properties
Copy
Edit
spring.data.mongodb.uri=mongodb://localhost:27017/journaldb
spring.security.user.name=admin
spring.security.user.password=admin123

🔐 Authentication
You can secure endpoints using Spring Security and use tools like Postman to pass login credentials.

For example, log in and get a JWT (if using token auth) or manage session cookies.


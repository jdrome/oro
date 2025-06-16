# Oro 💰

**Oro** is a personal finance tracking application built with **Java Spring Boot**. It allows users to manage budgets, categorize transactions, and track spending habits over time.

> ⚠️ This project is currently under active development. Some features may be incomplete or undergoing refactoring.

---

## 🚀 Technologies Used

- **Java 17**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
- **MySQL** (local development database)
- **Maven** (build tool)
- **Postman** (API testing)

---

## 📁 Project Structure
oro/
├── src/
│ ├── main/
│ │ └── java/com/oroapp/oro/
│ │ ├── controller/ # REST Controllers (User, Budget, etc.)
│ │ ├── entity/ # JPA Entities (User, Budget, Transaction, Category)
│ │ ├── repository/ # Spring Data JPA Repositories
│ │ ├── service/ # Service Interfaces and Implementations
│ │ └── bootstrap/ # Test data loader (for dev profile)
│ └── resources/
│ └── application-dev.properties
├── pom.xml
└── README.md 👈

---

## 🧪 API Endpoints (In Progress)

> These endpoints are available under the `/api` path.

### ✅ Users
- `POST /api/users` — Create a new user
- `GET /api/users/{id}` — Get user by ID
- `GET /api/users/username/{username}` — Get user by username

### ✅ Budgets
- `POST /api/budgets` — Create a new budget
- `GET /api/budgets/user/{userId}` — Get budgets for a user
- `GET /api/budgets/user/{userId}/category/{categoryId}` — Get a specific budget

_Transactions and categories are coming soon..._

---

## 🧰 Local Development Setup

### 1. Clone the repository
```bash
git clone https://github.com/jdrome/oro.git
cd oro
```

### 2. Set up MySQL
Ensure you have a local MySQL instance running and a database created (e.g. oro_db).

### 3. Configure application properties

Edit src/main/resources/application-dev.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/oro_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.profiles.active=dev
```

### 4. Run the app
```bash
./mvnw spring-boot:run
```

## 🔄 Seed Test Data (Dev Profile Only)
When running the app with the `dev` profile, test data will be loaded automatically (e.g. a sample user, category, budget, and transactions).

## 📌 Roadmap
- [ ] Build out `TransactionController` and `CategoryController`
- [ ] Add authentication (Spring Security)
- [ ] Implement data validation & error handling
- [ ] Add support for recurring budgets/transactions
- [ ] Build frontend (possible Angular, React, or Vue)

## 📄 License
MIT License
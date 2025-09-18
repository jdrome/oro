# Oro 💰

**Oro** is a personal finance application built with Spring Boot. 

Oro helps users track their income, expenses, budgets, and categories.
The project is currently in development and serves as a learning project in building a layered backend architecture with Spring Boot, DTOs, Mappers, and unit tests.

> ⚠️ This project is currently under active development. Some features may be incomplete or undergoing refactoring.

---

## 💻 Technologies Used

- **Java 17**
- **Spring Boot**
    - Spring Web
    - Spring Data JPA
- **MySQL** (local development database)
- **Maven** (build tool)
- **Postman** (API testing)

---

## 🚀 Features
- Entities:
  - `User` (tracks first name, last name, username, email, password)
  - `Category` (expense/income categories)
  - `Budget` (linked to users and categories)
  - `Transaction` (linked to users and categories)
- DTOs (Data Transfer Objects):
  - `UserDTO` (exposes safe user info without password)
  - `CategoryDTO`
- Mappers:
  - `UserMapper` (converts between `User` and `UserDTO`)
  - `CategoryMapper` (converts between `Category` and `CategoryDTO`)
- Controllers
  - `UserController`
    - `POST /api/users` — Create a new user
    - `GET /api/users/{id}` — Get user by ID
    - `GET /api/users/username/{username}` — Get user by username
  - `CategoryController`
    - `POST /api/categories` - Create new category
    - `GET /api/categories/id/{id}` - Fetch category by ID
    - `GET /api/categories/name/{name}` - Fetch category by name
    - `GET /api/categories` - List all categories 
  - Tests
    - `UserControllerTest` (using MockMvc & JUnit)
    - `CategoryControllerTest`
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

# 🚀 Company Profitability API

A **Spring Boot** application built using **Hexagonal Architecture (Ports & Adapters)** and **Contract-First API design** with OpenAPI.

This project demonstrates clean architecture principles, separation of concerns, and maintainability in a modern Java backend.

---

## 📌 Features

* ✅ Contract-first API using OpenAPI
* ✅ Hexagonal Architecture (Ports & Adapters)
* ✅ Spring Boot (Java 21)
* ✅ Spring Data JPA
* ✅ H2 in-memory database (for development/testing)
* ✅ MapStruct for type-safe mapping
* ✅ Validation with Jakarta Bean Validation
* ✅ Swagger UI for API documentation
* ✅ Actuator for monitoring

---

## 🏗️ Architecture

This project follows **Hexagonal Architecture**, ensuring clear separation between business logic and external systems.

```
               ┌──────────────────────────┐
               │      External World      │
               │ (HTTP, DB, UI, etc.)    │
               └──────────┬───────────────┘
                          │
        ┌─────────────────▼─────────────────┐
        │        Adapters (Inbound)         │
        │ Controllers (OpenAPI generated)  │
        └─────────────────┬─────────────────┘
                          │
        ┌─────────────────▼─────────────────┐
        │        Application Layer          │
        │        (Use Cases / Services)     │
        └─────────────────┬─────────────────┘
                          │
        ┌─────────────────▼─────────────────┐
        │        Domain Layer               │
        │ (Entities, Business Logic)        │
        └─────────────────┬─────────────────┘
                          │
        ┌─────────────────▼─────────────────┐
        │     Adapters (Outbound)           │
        │ (JPA Repositories, DB access)     │
        └───────────────────────────────────┘
```

---

## 📂 Project Structure

```
org.almb
├── domain                # Core business models (Not implemented) 
├── application           # Use cases / services
├── adapter
│   ├── in
│   │   └── web           # REST controllers (OpenAPI generated)
│   ├── mapper            # MapStruct mappers
│   └── out
│   │   └── persistence   # JPA repositories
              
```
---

## Getting Started

### Prerequisites

- Java 21
- Maven 3.8+
- Git (optional)

### Build the Project

---

## 📜 API Contract (OpenAPI)

* OpenAPI spec is located at:

```
src/main/resources/openapi/company-profitablity.yaml
```

* API interfaces and DTOs are **generated automatically** using the OpenAPI Generator.

---

## ⚙️ Build & Run

### 🔧 Build project

```bash
mvn clean install
```

### ▶️ Run application

```bash
mvn spring-boot:run
```



---

## 🌐 API Documentation

Swagger UI available at:

```
http://localhost:8080/swagger-ui.html
```

---

## 🗄️ Database

* Uses **H2 in-memory database**
* Console (if enabled):

```
http://localhost:8080/h2-console
```

---

## 🧪 Testing

Run tests:

```bash
mvn test
```

---
## Actuator for monitoring

Health check:
```
http://localhost:8080/actuator/health
```
Metrics:
```
http://localhost:8080/actuator/metrics
```
Info:
```
http://localhost:8080/actuator/info 
```
---
## 🔄 Mapping Strategy

The project uses **MapStruct** for mapping between layers:

* API DTO → Domain Model
* Domain Model → Entity
* Entity → Domain Model

This ensures:

* Type safety
* Compile-time validation
* Clean separation between layers

---

## 📌 Design Decisions

### ✅ Contract-First Approach

* API defined using OpenAPI
* Code is generated → reduces inconsistencies

### ✅ Hexagonal Architecture

* Business logic is independent of frameworks
* Easy to swap database or API layer

### ✅ MapStruct

* Avoids manual mapping boilerplate
* Improves performance vs reflection-based mappers

---

## 🚧 Improvements & Future Enhancements

### 🧱 Architecture

* [ ] Introduce **Domain Events**
* [ ] Add **CQRS (Command Query Responsibility Segregation)**
* [ ] Split into **multi-module project** (domain, application, adapters)
* [ ] Introduce **clean boundaries with interfaces for all ports**

---

### ⚡ Performance & Scalability

* [ ] Migrate to **Spring WebFlux (Reactive stack)**
* [ ] Replace JPA with **R2DBC for non-blocking DB access**
* [ ] Add caching (Redis)

---

### 🔐 Security

* [ ] Enable **Spring Security**
* [ ] Add OAuth2 / JWT authentication
* [ ] Role-based access control

---

### 🧪 Testing

* [ ] Add **Testcontainers** for real DB integration tests
* [ ] Increase unit test coverage
* [ ] Add contract testing (e.g. Pact)

---

### 📊 Observability

* [ ] Add **Micrometer + Prometheus**
* [ ] Integrate distributed tracing (OpenTelemetry)

---

### 🐳 DevOps

* [ ] Add Docker support
* [ ] Add CI/CD pipeline (GitHub Actions / GitLab CI)
* [ ] Kubernetes deployment

---

### 📦 API Improvements

* [ ] Versioning strategy (v1, v2)
* [ ] Pagination & filtering
* [ ] Error handling standardization (RFC7807)

---

## ⚠️ Notes

* Current implementation uses **Spring MVC (blocking)**
* Reactive stack (**WebFlux + R2DBC**) is recommended for high scalability

---

## 👨‍💻 Author

Developed as a demonstration of:

* Clean architecture
* Contract-first API design
* Modern Spring Boot practices

---

### Suggestions of improvements for production:
- Implement all parts in the API(Owner)
- Hexagonal architecture, not complete
  - Implement domain model and mappers for all layers
- Add missing unit test
- Add reactive design(WebFlux), for better performance 

---

## 📄 License

This project is provided for demonstration and educational purposes.
Some parts in the project have been generated by ChatGPT






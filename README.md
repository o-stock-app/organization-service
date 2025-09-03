# Organization Service

The **Organization Service** is part of the o-stock microservices app.  
It manages organizational records (create, read, update, delete) and provides endpoints for bootstrap data.

---

## 🚀 Endpoints

Base path: `/optima/v1/organization`

- `GET /test`  
  Health-check. Returns `"Hello, Organization service is up and running."`

- `GET /{organizationId}`  
  Fetch a single organization by ID (UUID).

- `GET /all`  
  Fetch all organizations.

- `GET /bootstrap`  
  Fetch bootstrapped organization data.

- `POST /`  
  Create a new organization.  
  **Body**: `Organization` JSON

- `PUT /{organizationId}`  
  Update an existing organization.  
  **Body**: `Organization` JSON

- `DELETE /{organizationId}`  
  Delete an organization by ID.  

---

## ⚙️ Tech Stack

- **Language**: Java 21  
- **Framework**: Spring Boot 3.x  
- **Build Tool**: Maven  
- **Database**: PostgreSQL  
- **Containerization**: Docker  

---

## 🏗️ Setup & Run

### Prerequisites
- JDK 21
- Maven
- PostgreSQL (local or containerized)

### Build & Run
```bash
./mvnw clean install
./mvnw spring-boot:run

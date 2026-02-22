# 🏥 Intelligent Clinic Assistant (Backend)

[![Java](https://img.shields.io/badge/Java-17+-red)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0+-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue)](https://www.postgresql.org)
[![Docker](https://img.shields.io/badge/Docker-Supported-blue)](https://www.docker.com)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

Backend application built with **Java + Spring Boot** that manages patients, appointments, and medical consultations, using **Artificial Intelligence as a decision-support tool** for clinical triage and consultation summaries.

> ⚠️ **Disclaimer**  
> This system **does NOT provide medical diagnoses**.  
> Artificial Intelligence is used **only as a support tool**, following responsible and ethical software design principles.

---

## 📋 Table of Contents

- [🎯 Project Purpose](#project-purpose)
- [🧠 Core Features](#core-features)
- [🏗️ Architecture](#architecture)
- [🤖 AI Integration](#artificial-intelligence-integration)
- [🔐 Security](#security)
- [🛠️ Technologies](#technologies--tools)
- [⚡ Quick Start](#quick-start)
- [📚 API Endpoints](#api-endpoints)
- [🧪 Testing](#testing)
- [📝 Project Structure](#project-structure)
- [🤝 Contributing](#contributing)

---

## 🎯 Project Purpose

This project was created to simulate a **real-world healthcare backend system**, focusing on:

- ✅ Clean Architecture and DDD-inspired design
- ✅ Clear business rules and domain modeling
- ✅ Secure and decoupled integration with AI services
- ✅ Scalable and maintainable backend structure
- ✅ Professional software engineering practices

It is mainly intended for **learning purposes and professional portfolio demonstration**.

---

## 🧠 Core Features

### 👤 Patient Management
- ✅ Register new patients with validation
- ✅ Update patient information
- ✅ Retrieve patient details
- ✅ Maintain immutable medical history

### 🩺 Intelligent Triage
- ✅ Register patient symptoms
- ✅ AI-assisted urgency classification (`LOW`, `MEDIUM`, `HIGH`)
- ✅ AI-based medical specialty suggestion
- ✅ Full persistence and audit of AI interactions
- ✅ Fallback rules when AI service fails
- ✅ Retrieve triage history for patients

### 📅 Appointment Management
- ✅ Schedule medical appointments
- ✅ Prevent scheduling conflicts (doctor availability)
- ✅ Associate patients with doctors
- ✅ List all scheduled appointments
- ✅ Support for appointment status tracking

### 🧑‍⚕️ Doctor Management
- ✅ List available doctors
- ✅ Filter doctors by specialty
- ✅ View doctor availability

### 📄 AI-generated Consultation Summary
- ✅ Automatically generate consultation summaries using AI
- ✅ Context-aware summaries based on patient history
- ✅ Fallback templates when AI fails
- ✅ Manual reprocessing when needed

---

## 🏗️ Architecture

The project follows **Clean Architecture principles**, with clear separation of concerns:

```
┌─────────────────────────────────────────────┐
│           API Layer (Controllers)           │
│    (REST Endpoints & Request Handling)      │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│     Application Layer (Use Cases)           │
│    (Business Logic Orchestration)           │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│       Domain Layer (Entities & Rules)       │
│        (Core Business Logic)                │
└────────────────┬────────────────────────────┘
                 │
┌────────────────▼────────────────────────────┐
│      Infrastructure Layer (Adapters)        │
│   (Database, AI APIs, External Services)    │
└─────────────────────────────────────────────┘
```

### Layer Responsibilities

| Layer | Responsibility |
|-------|-----------------|
| **Domain** | Core business entities, value objects, and business rules |
| **Application** | Use cases, service orchestration, input/output formatting |
| **Infrastructure** | Database repositories, external API clients, persistence |
| **API** | HTTP endpoints, request/response handling, validation |

---

## 🤖 Artificial Intelligence Integration

### Design Principles

- 🔌 **Pluggable**: AI providers can be replaced without impacting core logic
- 🛡️ **Isolated**: AI failures don't crash the system (fallback mechanisms)
- 📊 **Auditable**: All AI interactions are logged and traceable
- ✔️ **Validated**: AI responses are strictly validated before use
- 🔒 **Secure**: API keys stored as environment variables

### Supported AI Providers

- **Groq** (llama-3.1, mixtral, gemma2)
- Extensible for OpenAI, Anthropic, etc.

### Fallback Mechanism

When AI service fails:
1. System captures the error
2. Applies rule-based fallback logic
3. Returns safe default response
4. Logs incident for monitoring

---

## 🔐 Security

- 🔑 **Authentication**: JWT token-based (ready for implementation)
- 👥 **Authorization**: Role-based access control (RBAC)
  - `ADMIN` - Full system access
  - `DOCTOR` - Schedule appointments, view patient info
  - `PATIENT` - View own health records
- 🔒 **Data Protection**: Sensitive data encrypted at rest
- 🛡️ **API Key Management**: Environment variables, never hardcoded
- ✅ **Input Validation**: All requests validated before processing

---

## 🛠️ Technologies & Tools

### Backend
- **Java 17+** - Language
- **Spring Boot 3.0+** - Framework
- **Spring Web** - REST API
- **Spring Data JPA** - ORM & Persistence
- **Spring Security** - Authentication & Authorization
- **Spring Validation** - Input validation
- **Lombok** - Boilerplate reduction
- **Maven** - Build tool

### Database
- **PostgreSQL 15** - Primary database

### AI & Integration
- **WebClient** - Reactive HTTP client for AI APIs
- **Groq API** - LLM provider for triage & summaries

### Testing & Quality
- **JUnit 5** - Unit testing framework
- **Mockito** - Mocking library
- **AssertJ** - Fluent assertions

### DevOps
- **Docker** - Containerization
- **Docker Compose** - Orchestration
- **Maven** - Build automation

---

## ⚡ Quick Start

### Prerequisites

Ensure you have installed:

- **Java 17+** ([download](https://www.oracle.com/java/technologies/downloads/))
- **Maven 3.8+** ([download](https://maven.apache.org/download.cgi))
- **Docker & Docker Compose** ([download](https://www.docker.com/products/docker-desktop))
- **Git** ([download](https://git-scm.com/))

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/AI-API.git
cd AI-API
```

### Step 2: Configure Environment Variables

Copy the `.env.example` file and update with your Groq API key:

```bash
cp .env.example .env
```

Edit `.env`:

```env
# AI Configuration
AI_PROVIDER=groq
GROQ_API_KEY=your_groq_api_key_here
AI_BASE_URL=https://api.groq.com/openai/v1
GROQ_MODEL=llama-3.1-8b-instant
AI_TIMEOUT_MS=30000
AI_MAX_RETRIES=3
```

**Get your Groq API Key**: https://console.groq.com/keys

### Step 3: Start with Docker Compose (Recommended)

```bash
docker-compose up --build
```

This will:
- ✅ Build the Java application
- ✅ Start PostgreSQL database
- ✅ Create all tables automatically
- ✅ Start the API on port 8080

### Step 4: Verify Everything is Running

```bash
# Check containers
docker-compose ps

# Check API health
curl http://localhost:8080/actuator/health
```

### Alternative: Run Locally (Without Docker)

```bash
# Build
mvn clean package

# Run
java -jar target/app.jar
```

### Step 5: Stop the Application

```bash
# Stop containers
docker-compose down

# Stop and remove data
docker-compose down -v
```

---

## 📚 API Endpoints

### Authentication

Currently JWT authentication is under development. All endpoints below should include:

```
Authorization: Bearer <YOUR_JWT_TOKEN>
```

### 👤 Patient Management

#### Register a New Patient

```http
POST /users
Content-Type: application/json

{
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "11987654321",
  "userType": "PATIENT"
}
```

**Response (201 Created)**
```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "11987654321",
  "userType": "PATIENT"
}
```

#### List All Doctors

```http
GET /users/doctors
Accept: application/json

```

**Response (200 OK)**
```json
[
  {
    "id": 2,
    "name": "Dr. Ana Costa",
    "email": "ana@hospital.com",
    "phone": "11988888888",
    "userType": "DOCTOR"
  },
  {
    "id": 3,
    "name": "Dr. Carlos Silva",
    "email": "carlos@hospital.com",
    "phone": "11989999999",
    "userType": "DOCTOR"
  }
]
```

#### Get Patient Triages

```http
GET /users/{patientId}/triages
Accept: application/json

```

**Response (200 OK)**
```json
{
  "user": {
    "id": 1,
    "name": "João Silva",
    "email": "joao@example.com",
    "phone": "11987654321",
    "userType": "PATIENT"
  },
  "triages": [
    {
      "id": 1,
      "patientId": 1,
      "urgency": "MEDIUM",
      "specialty": "Cardiology",
      "reason": "Chest discomfort and shortness of breath",
      "createdAt": "2026-02-22T10:30:00Z"
    }
  ]
}
```

---

### 🩺 Triage Management

#### Register Patient Triage (AI-Assisted)

```http
POST /triage
Content-Type: application/json

{
  "patientId": 1,
  "age": 45,
  "symptoms": ["dor no peito", "falta de ar", "taquicardia"],
  "medicalHistorySummary": "History of hypertension for 5 years. Uses losartan 50mg daily. No known drug allergies. Last check-up 6 months ago."
}
```

**Response (200 OK)** - Success with AI Response
```json
{
  "urgency": "HIGH",
  "specialty": "Cardiology",
  "reason": "Patient presents with chest discomfort and shortness of breath, concerning for cardiac etiology. Urgent evaluation recommended.",
  "trace": {
    "provider": "groq",
    "model": "llama-3.1-8b-instant",
    "prompt": "[Full prompt sent to AI]",
    "rawResponse": "{...}",
    "latencyMs": 1250
  }
}
```

**Response (200 OK)** - With Fallback (When AI Fails)
```json
{
  "urgency": "MEDIUM",
  "specialty": "General Practice",
  "reason": "Fallback applied due to AI failure: TimeoutException",
  "trace": {
    "provider": "fallback",
    "model": "rule-based",
    "prompt": "N/A",
    "rawResponse": "AI service timeout",
    "latencyMs": 0
  }
}
```

#### Expected Urgency Levels
- `LOW` - Non-urgent, routine consultation
- `MEDIUM` - Standard priority, should see doctor soon
- `HIGH` - Urgent, requires immediate attention

---

### 📅 Appointment Management

#### Schedule an Appointment

```http
POST /appointments
Content-Type: application/json

{
  "patientId": 1,
  "doctorId": 2,
  "startAt": "2026-03-01T14:30:00Z"
}
```

**Response (200 OK)**
```json
{
  "id": 1,
  "patientId": 1,
  "doctorId": 2,
  "startAt": "2026-03-01T14:30:00Z",
  "status": "SCHEDULED",
  "createdAt": "2026-02-22T10:00:00Z"
}
```

**Response (409 Conflict)** - Doctor Not Available
```json
{
  "error": "Doctor is not available at the requested time"
}
```

#### List All Appointments

```http
GET /appointments
Accept: application/json

```

**Response (200 OK)**
```json
[
  {
    "id": 1,
    "patientId": 1,
    "doctorId": 2,
    "startAt": "2026-03-01T14:30:00Z",
    "status": "SCHEDULED",
    "createdAt": "2026-02-22T10:00:00Z"
  },
  {
    "id": 2,
    "patientId": 3,
    "doctorId": 2,
    "startAt": "2026-03-01T15:00:00Z",
    "status": "COMPLETED",
    "createdAt": "2026-02-21T14:00:00Z"
  }
]
```

---

## 🧪 Testing

### Run All Tests

```bash
mvn test
```

### Run Tests for Specific Class

```bash
mvn test -Dtest=UserControllerTest
```

### Run Tests with Coverage

```bash
mvn test jacoco:report
# Coverage report: target/site/jacoco/index.html
```

### Run Tests in Watch Mode (Docker)

```bash
docker-compose exec app mvn test
```

---

## 📝 Project Structure

```
AI-API/
├── src/
│   ├── main/
│   │   ├── java/com/felipe/dev/api/
│   │   │   ├── application/          # Application layer (use cases)
│   │   │   │   ├── gateways/         # Interface definitions
│   │   │   │   └── usecases/         # Business logic orchestration
│   │   │   │       ├── appointment/
│   │   │   │       ├── triage/
│   │   │   │       └── user/
│   │   │   ├── domain/               # Domain layer (entities, rules)
│   │   │   │   ├── entities/
│   │   │   │   │   ├── appointment/
│   │   │   │   │   ├── triage/
│   │   │   │   │   └── user/
│   │   │   │   └── UserType.java
│   │   │   ├── infra/                # Infrastructure layer
│   │   │   │   ├── AI/               # AI integration
│   │   │   │   │   ├── groq/         # Groq provider
│   │   │   │   │   ├── config/       # AI configuration
│   │   │   │   │   ├── fallback/     # Fallback policies
│   │   │   │   │   ├── parsing/      # Response parsing
│   │   │   │   │   └── prompts/      # Prompt templates
│   │   │   │   ├── controller/       # REST endpoints
│   │   │   │   ├── gateways/         # Repository implementations
│   │   │   │   │   ├── appointment/
│   │   │   │   │   ├── triage/
│   │   │   │   │   └── user/
│   │   │   │   ├── persistence/      # JPA entities
│   │   │   │   │   ├── appointment/
│   │   │   │   │   ├── triage/
│   │   │   │   │   └── user/
│   │   │   │   └── config/           # Spring configuration
│   │   │   └── IaApiApplication.java # Main class
│   │   └── resources/
│   │       └── application.yml        # Configuration (if not in docker-compose)
│   └── test/
│       └── java/com/felipe/dev/api/  # Unit & integration tests
├── docker-compose.yml                # Docker setup
├── Dockerfile                        # Container definition
├── pom.xml                           # Maven configuration
├── .env                              # Environment variables
└── README.md                         # This file
```

---

## 🚀 Common Tasks

### View Application Logs

```bash
# All logs
docker-compose logs -f app

# Logs from specific service
docker-compose logs -f db

# Last 50 lines
docker-compose logs --tail=50 app
```

### Access Database

```bash
# Connect to PostgreSQL
docker-compose exec db psql -U postgres -d ia_api

# Common SQL queries
\dt                    # List tables
\d users              # Describe users table
SELECT * FROM users;  # Query data
\q                    # Exit
```

### Rebuild Application

```bash
# Full rebuild
docker-compose up --build

# Rebuild without cache
docker-compose up --build --no-cache
```

### Clean Build

```bash
# Remove all containers and volumes
docker-compose down -v

# Rebuild from scratch
docker-compose up --build
```

---

## 📊 Performance Considerations

- **Timeout Configuration**: AI requests timeout after configurable milliseconds
- **Fallback Mechanism**: Automatic fallback prevents cascading failures
- **Database Indexing**: Key columns are indexed for fast queries
- **Connection Pooling**: HikariCP manages database connections efficiently

---

## 🗺️ Roadmap

### Phase 1 ✅ (Current)
- ✅ Patient management
- ✅ Triage with AI
- ✅ Appointment scheduling
- ✅ AI integration with fallback

### Phase 2 📅 (Upcoming)
- 🔲 JWT authentication
- 🔲 Role-based authorization
- 🔲 Medical consultation records
- 🔲 Appointment status tracking

### Phase 3 🎯 (Future)
- 🔲 Real-time notifications
- 🔲 Advanced analytics
- 🔲 Mobile app support
- 🔲 Telemedicine integration

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the MIT License - see [LICENSE](LICENSE) file for details.

---

## 📞 Support

For questions or issues:

1. **Check existing issues** on GitHub
2. **Create a new issue** with detailed description
3. **Contact the maintainer** for urgent matters

---

## 👨‍💻 Author

**Felipe Froes**

- GitHub: [@felipefroes](https://github.com/felipefroes)
- Email: felipe@example.com

---

**Last Updated**: February 22, 2026



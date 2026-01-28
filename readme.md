# 🏥 Intelligent Clinic Assistant (Backend)

Backend project built with **Java + Spring Boot** that manages patients, appointments, and medical consultations, using **Artificial Intelligence as a decision-support tool** for clinical triage and consultation summaries.

> ⚠️ Disclaimer  
> This system **does NOT provide medical diagnoses**.  
> Artificial Intelligence is used **only as a support tool**, following responsible and ethical software design principles.

---

## 🎯 Project Purpose

This project was created to simulate a **real-world healthcare backend system**, focusing on:

- Clean Architecture and DDD-inspired design
- Clear business rules and domain modeling
- Secure and decoupled integration with AI services
- Scalable and maintainable backend structure

It is mainly intended for **learning purposes and professional portfolio demonstration**.

---

## 🧠 Core Features

### 👤 Patient Management
- Register and update patients
- Maintain immutable medical history

### 🩺 Intelligent Triage
- Register patient symptoms
- AI-assisted urgency classification (`LOW`, `MEDIUM`, `HIGH`)
- AI-based specialty suggestion
- Full persistence and audit of AI interactions

### 📅 Appointments
- Schedule medical appointments
- Prevent scheduling conflicts
- Associate patients and doctors

### 🧑‍⚕️ Medical Consultations
- Record medical consultations
- Store structured medical notes
- Maintain consultation lifecycle

### 📄 AI-generated Consultation Summary
- Automatically generate consultation summaries using AI
- Versioned summaries for traceability
- Manual reprocessing when needed

---

## 🏗️ Architecture

The project follows **Clean Architecture principles**, with a clear separation of concerns:

- **Domain Layer**: Core business logic and entities
- **Application Layer**: Use cases and service orchestration
- **Infrastructure Layer**: External systems and database interactions
- **API Layer**: RESTful endpoints for client interaction

## 🤖 Artificial Intelligence Integration

- AI is accessed through a **dedicated client layer**
- Prompts are structured and controlled
- Responses are strictly validated and parsed
- Fallback rules are applied when AI fails
- All AI interactions are logged for auditing

AI providers can be replaced without impacting the core business logic.

---

## 🔐 Security

- Authentication using **JWT**
- Role-based authorization:
    - `ADMIN`
    - `DOCTOR`
    - `RECEPTIONIST`
- Secure handling of sensitive data
- AI API keys stored as environment variables

---

## 🛠️ Technologies & Tools

### Backend
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Validation

### Database
- PostgreSQL
- Flyway (database migrations)

### AI & Integration
- External AI APIs (e.g. OpenAI)
- Spring WebClient

### DevOps & Quality
- Docker & Docker Compose
- Maven
- JUnit 5 & Mockito
- Lombok

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven
- Docker (optional but recommended)
- PostgreSQL

### Environment Variables
```env
OPENAI_API_KEY=your_api_key_here
OPENAI_BASE_URL=https://api.openai.com/v1
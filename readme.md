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
    - `USER`
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

## ▶️ How to Run the Project

This project is a **Spring Boot backend application** built with **Java and Maven**.  
You can run it **locally** or using **Docker**.


### 🔧 Tools Needed

Make sure you have the following installed:

- **Java 17+**
- **Maven 3.8+**
- **PostgreSQL**
- **Docker & Docker Compose** (optional, recommended)

---


## 🐳 Executando com Docker (Recomendado)

A maneira mais simples de rodar a aplicação é utilizando **Docker Compose**, que configura automaticamente a API e o banco de dados MySQL.

### Pré-requisitos

* Docker Engine e Docker Compose instalados.


## Configuration

The application uses configuration files located in `src/main/resources/`:

- `application.properties` or `application.yml` - Main configuration file
- Update database credentials, server port, and other settings as needed before building the JAR.


### 🧩 Environment Variables

Before running the application, configure the following environment variables:

```env
# === AI (Groq) ===
ai.provider=${AI_PROVIDER:groq}
ai.base-url=${AI_BASE_URL:https://api.groq.com/openai/v1}
ai.api-key=${GROQ_API_KEY}
ai.model=${AI_MODEL:llama-3.1-8b-instant}
ai.timeout-ms=${AI_TIMEOUT_MS:16000}
ai.max-retries=${AI_MAX_RETRIES:3}
```

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone
    
    ```   

2. **Suba os containers:**
    ```bash
    docker-compose up --build
    
    ```   


    *Este comando irá compilar a aplicação, criar a imagem Docker e iniciar os containers da API e do banco de dados.*

3.  **Acesse a aplicação:**
    * A API estará rodando em: `http://localhost:8080`
    * O banco de dados estará acessível na porta `5432`.

### 🫆 Exemplo de Uso (Register User)

* **Método:** `POST`
* **URL:** `http://localhost:8080/users`
* **Headers:** `Authorization: Bearer <SEU_TOKEN>`
* **Body (JSON Exemplo):**
  ```json
    {
    "name": "gustavo froes",
    "email": "gustavo@gmail.com",
    "userType": "PATIENT",
    "phone": "71996521870"
    }
    ```
  * **Resposta Esperada `201 CREATED`**


### ⚛️ Exemplo de Uso (Triage Patient AI)

* **Método:** `POST`
* **URL:** `http://localhost:8080/triage`
* **Headers:** `Authorization: Bearer <SEU_TOKEN>`
* **Body (JSON Exemplo):**
  ```json
  {
  "patientId": 1,
  "age": 45,
  "symptoms": ["dor de barriga", "fraqueza"],
  "medicalHistorySummary": "History of hypertension for 5 years. Uses losartan 50mg daily. No known drug allergies. Denies diabetes. No recent surgeries. Last medical check-up 6 months ago."
  }
  ```
* **Resposta Esperada `200 OK`**
    
    
  ```json
    {
    "urgency": "MEDIUM",
    "specialty": "Primary Care or Gastroenterology",
    "reason": "Patient is experiencing symptoms of abdominal discomfort and weakness, which may be related to their hypertension or other underlying conditions. A medical evaluation is necessary to determine the cause of these symptoms.",
    "trace": {
      "provider": "groq",
      "model": "llama-3.1-8b-instant",
      "prompt": "Patient data:\n- Age: 45\n- Symptoms: dor de barriga, fraqueza\n- Medical history summary: History of hypertension for 5 years. Uses losartan 50mg daily. No known drug allergies. Denies diabetes. No recent surgeries. Last medical check-up 6 months ago.\n\nOutput JSON schema:\n{\n  \"urgency\": \"LOW | MEDIUM | HIGH\",\n  \"specialty\": \"string\",\n  \"reason\": \"string\"\n}\n\nReturn ONLY JSON, no extra text.\n",
      "rawResponse": "{\n  \"urgency\": \"MEDIUM\",\n  \"specialty\": \"Primary Care or Gastroenterology\",\n  \"reason\": \"Patient is experiencing symptoms of abdominal discomfort and weakness, which may be related to their hypertension or other underlying conditions. A medical evaluation is necessary to determine the cause of these symptoms.\"\n}",
      "latencyMs": 1395
      }
    }
  ```


### 🔦 Exemplo de Uso (Find Patient Triages)

* **Método:** `GET`
* **URL:** `http://localhost:8080/PATIENT_ID/triages`
* **Headers:** `Authorization: Bearer <SEU_TOKEN>`
* **Response (JSON Exemplo):**
  ```json
    {
      "user": {
      "email": "gustavo@gmail.com",
      "id": 1,
      "name": "gustavo froes",
      "phone": "71996521870",
      "userType": "PATIENT"
      },
        "triages": [
        {
          "createdAt": "2026-02-04T14:46:35.950532256Z",
          "id": 1,
          "patientId": 1,
          "reason": "Patient is experiencing symptoms of abdominal discomfort and weakness, which may be related to their hypertension or other underlying conditions. A medical evaluation is necessary to determine the cause of these symptoms.",
          "specialty": "Primary Care or Gastroenterology",
          "urgency": "MEDIUM"
        }
      ]
    }
  ```
* **Resposta Esperada `200 OK`**


### Comandos Úteis

* **Parar a aplicação:** `docker-compose down`
* **Parar e remover volumes (limpar dados):** `docker-compose down -v`
* **Ver logs:** `docker-compose logs -f`

---


### Using IDE

You can also run the project directly from your IDE (IntelliJ IDEA, Eclipse, VS Code) by locating the main class (`Main.java` or `Application.java`) and selecting **Run**.



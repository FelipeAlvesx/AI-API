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

## ▶️ How to Run the Project

This project is a **Spring Boot backend application** built with **Java and Maven**.  
You can run it **locally** or using **Docker**.

## 🐳 Executando com Docker (Recomendado)

A maneira mais simples de rodar a aplicação é utilizando **Docker Compose**, que configura automaticamente a API e o banco de dados MySQL.

### Pré-requisitos

* Docker Engine e Docker Compose instalados.

### Passo a Passo

1.  **Clone o repositório:**
<div class="widget code-container remove-before-copy"><div class="code-header non-draggable"><span class="iaf s13 w700 code-language-placeholder">bash</span><div class="code-copy-button"><span class="iaf s13 w500 code-copy-placeholder">Copy</span><img class="code-copy-icon" src="data:image/svg+xml;utf8,%0A%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%3E%0A%20%20%3Cpath%20d%3D%22M10.8%208.63V11.57C10.8%2014.02%209.82%2015%207.37%2015H4.43C1.98%2015%201%2014.02%201%2011.57V8.63C1%206.18%201.98%205.2%204.43%205.2H7.37C9.82%205.2%2010.8%206.18%2010.8%208.63Z%22%20stroke%3D%22%23717C92%22%20stroke-width%3D%221.05%22%20stroke-linecap%3D%22round%22%20stroke-linejoin%3D%22round%22%2F%3E%0A%20%20%3Cpath%20d%3D%22M15%204.42999V7.36999C15%209.81999%2014.02%2010.8%2011.57%2010.8H10.8V8.62999C10.8%206.17999%209.81995%205.19999%207.36995%205.19999H5.19995V4.42999C5.19995%201.97999%206.17995%200.999992%208.62995%200.999992H11.57C14.02%200.999992%2015%201.97999%2015%204.42999Z%22%20stroke%3D%22%23717C92%22%20stroke-width%3D%221.05%22%20stroke-linecap%3D%22round%22%20stroke-linejoin%3D%22round%22%2F%3E%0A%3C%2Fsvg%3E%0A" /></div></div><pre id="code-s2ed4aiwh" style="color:#111b27;background:#e3eaf2;font-family:Consolas, Monaco, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, monospace;text-align:left;white-space:pre;word-spacing:normal;word-break:normal;word-wrap:normal;line-height:1.5;-moz-tab-size:4;-o-tab-size:4;tab-size:4;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;hyphens:none;padding:8px;margin:8px;overflow:auto;width:calc(100% - 8px);border-radius:8px;box-shadow:0px 8px 18px 0px rgba(120, 120, 143, 0.10), 2px 2px 10px 0px rgba(255, 255, 255, 0.30) inset"><code class="language-bash" style="white-space:pre;color:#111b27;background:none;font-family:Consolas, Monaco, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, monospace;text-align:left;word-spacing:normal;word-break:normal;word-wrap:normal;line-height:1.5;-moz-tab-size:4;-o-tab-size:4;tab-size:4;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;hyphens:none"><span>    </span><span class="token" style="color:#7c00aa">git</span><span> clone </span><span class="token" style="color:#111b27">[</span><span>LINK_DO_SEU_REPOSITORIO</span><span class="token" style="color:#111b27">]</span><span>
</span><span>    </span><span class="token" style="color:#005a8e">cd</span><span> nome-do-projeto
</span></code></pre></div>

2.  **Suba os containers:**
    Na raiz do projeto, execute:
<div class="widget code-container remove-before-copy"><div class="code-header non-draggable"><span class="iaf s13 w700 code-language-placeholder">bash</span><div class="code-copy-button"><span class="iaf s13 w500 code-copy-placeholder">Copy</span><img class="code-copy-icon" src="data:image/svg+xml;utf8,%0A%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%3E%0A%20%20%3Cpath%20d%3D%22M10.8%208.63V11.57C10.8%2014.02%209.82%2015%207.37%2015H4.43C1.98%2015%201%2014.02%201%2011.57V8.63C1%206.18%201.98%205.2%204.43%205.2H7.37C9.82%205.2%2010.8%206.18%2010.8%208.63Z%22%20stroke%3D%22%23717C92%22%20stroke-width%3D%221.05%22%20stroke-linecap%3D%22round%22%20stroke-linejoin%3D%22round%22%2F%3E%0A%20%20%3Cpath%20d%3D%22M15%204.42999V7.36999C15%209.81999%2014.02%2010.8%2011.57%2010.8H10.8V8.62999C10.8%206.17999%209.81995%205.19999%207.36995%205.19999H5.19995V4.42999C5.19995%201.97999%206.17995%200.999992%208.62995%200.999992H11.57C14.02%200.999992%2015%201.97999%2015%204.42999Z%22%20stroke%3D%22%23717C92%22%20stroke-width%3D%221.05%22%20stroke-linecap%3D%22round%22%20stroke-linejoin%3D%22round%22%2F%3E%0A%3C%2Fsvg%3E%0A" /></div></div><pre id="code-vnqbop180" style="color:#111b27;background:#e3eaf2;font-family:Consolas, Monaco, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, monospace;text-align:left;white-space:pre;word-spacing:normal;word-break:normal;word-wrap:normal;line-height:1.5;-moz-tab-size:4;-o-tab-size:4;tab-size:4;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;hyphens:none;padding:8px;margin:8px;overflow:auto;width:calc(100% - 8px);border-radius:8px;box-shadow:0px 8px 18px 0px rgba(120, 120, 143, 0.10), 2px 2px 10px 0px rgba(255, 255, 255, 0.30) inset"><code class="language-bash" style="white-space:pre;color:#111b27;background:none;font-family:Consolas, Monaco, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, monospace;text-align:left;word-spacing:normal;word-break:normal;word-wrap:normal;line-height:1.5;-moz-tab-size:4;-o-tab-size:4;tab-size:4;-webkit-hyphens:none;-moz-hyphens:none;-ms-hyphens:none;hyphens:none"><span>    </span><span class="token" style="color:#7c00aa">docker-compose</span><span> up </span><span class="token" style="color:#005a8e">--build</span><span>
</span></code></pre></div>
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


### Comandos Úteis

* **Parar a aplicação:** `docker-compose down`
* **Parar e remover volumes (limpar dados):** `docker-compose down -v`
* **Ver logs:** `docker-compose logs -f`

---

### 🔧 Prerequisites

Make sure you have the following installed:

- **Java 17+**
- **Maven 3.8+**
- **PostgreSQL**
- **Docker & Docker Compose** (optional, recommended)

---

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

### Using IDE

You can also run the project directly from your IDE (IntelliJ IDEA, Eclipse, VS Code) by locating the main class (`Main.java` or `Application.java`) and selecting **Run**.

## Configuration

The application uses configuration files located in `src/main/resources/`:

- `application.properties` or `application.yml` - Main configuration file
- Update database credentials, server port, and other settings as needed before building the JAR.

## Accessing the Application

Once running, the application will be available at: http://localhost:8080 


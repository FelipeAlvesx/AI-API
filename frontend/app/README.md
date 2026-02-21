# Frontend - MediAI

Interface moderna para o sistema de triagem e agendamentos com IA.

## Setup

```bash
cd frontend/app
npm install
```

## Desenvolvimento

```bash
npm run dev
```

A aplicação rodará em `http://localhost:3000`

## Build

```bash
npm run build
```

## Estrutura do Projeto

```
src/
├── components/        # Componentes React
│   ├── TriageForm.jsx
│   ├── AppointmentForm.jsx
│   └── TriageResult.jsx
├── services/         # Serviços de API
│   └── api.js
├── App.jsx          # Componente principal
├── main.jsx         # Entry point
└── index.css        # Estilos globais
```

## Funcionalidades

- 🏥 **Triagem Inteligente**: Formulário para triagem de pacientes com sugestões da IA
- 📅 **Agendamento**: Sistema para agendar consultas
- 💻 **UI Moderna**: Design limpo com cores calmas (azul, verde, cinza)
- ⚡ **Vite**: Build tool rápido e moderno
- 🎨 **Tailwind CSS**: Framework CSS para estilização

## Cores Utilizadas

- **Primário**: Azul (#2563eb)
- **Secundário**: Cinza Slate (#64748b)
- **Sucesso**: Verde (#10b981)
- **Erro**: Vermelho (#ef4444)

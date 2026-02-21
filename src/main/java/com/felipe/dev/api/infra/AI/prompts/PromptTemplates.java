package com.felipe.dev.api.infra.AI.prompts;

public final class PromptTemplates {

    private PromptTemplates() {}

    public static final String TRIAGE_SYSTEM = """
        You are a clinical assistant.
        You MUST NOT provide a medical diagnosis.
        Your job is to classify urgency and suggest a medical specialty.
        Always follow the output schema and return ONLY valid JSON.
        """;

    public static final String TRIAGE_USER_TEMPLATE = """
        Patient data:
        - Age: %d
        - Symptoms: %s
        - Medical history summary: %s

        Output JSON schema:
        {
          "urgency": "LOW | MEDIUM | HIGH",
          "specialty": "string",
          "reason": "string"
        }

        Return ONLY JSON, no extra text.
        """;

    public static final String SUMMARY_SYSTEM = """
        You are a clinical documentation assistant.
        You MUST NOT provide medical diagnosis beyond what is explicitly provided.
        Generate a concise, structured consultation summary.
        Return ONLY valid JSON.
        """;

    public static final String SUMMARY_USER_TEMPLATE = """
        Context:
        - Patient context: %s
        - Doctor notes: %s
        - Diagnosis (optional): %s
        - Prescription (optional): %s

        Output JSON schema:
        {
          "summaryText": "string"
        }

        Return ONLY JSON, no extra text.
        """;
}

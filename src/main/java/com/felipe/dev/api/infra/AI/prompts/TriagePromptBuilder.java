package com.felipe.dev.api.infra.AI.prompts;

import com.felipe.dev.api.application.gateways.AI.TriageAIRequest;

public class TriagePromptBuilder {

    public String buildUserPrompt(TriageAIRequest req) {
        String symptoms = String.join(", ", req.symptoms());
        String history = req.medicalHistorySummary() == null ? "N/A" : req.medicalHistorySummary();
        return PromptTemplates.TRIAGE_USER_TEMPLATE.formatted(req.age(), symptoms, history);
    }
}
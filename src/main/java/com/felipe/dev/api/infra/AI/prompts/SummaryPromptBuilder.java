package com.felipe.dev.api.infra.AI.prompts;

import com.felipe.dev.api.application.gateways.AI.SummaryAIRequest;

public class SummaryPromptBuilder {

    public String buildUserPrompt(SummaryAIRequest req) {
        return PromptTemplates.SUMMARY_USER_TEMPLATE.formatted(
                safe(req.patientContext()),
                safe(req.doctorNotes()),
                safe(req.diagnosis()),
                safe(req.prescription())
        );
    }

    private String safe(String value) {
        return value == null || value.isBlank() ? "N/A" : value;
    }
}
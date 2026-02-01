package com.felipe.dev.api.infra.AI.fallback;

import com.felipe.dev.api.application.gateways.AI.AITrace;
import com.felipe.dev.api.application.gateways.AI.SummaryAIRequest;
import com.felipe.dev.api.application.gateways.AI.SummaryAIResponse;

public class SummaryFallbackPolicy {

    public SummaryAIResponse fallback(SummaryAIRequest req, Exception ex) {
        String summary = """
            Consultation summary unavailable (AI fallback).
            Notes: %s
            Diagnosis: %s
            Prescription: %s
            """.formatted(
                safe(req.doctorNotes()),
                safe(req.diagnosis()),
                safe(req.prescription())
        ).trim();

        return new SummaryAIResponse(
                summary,
                new AITrace("fallback", "template", "N/A", ex.getMessage(), 0)
        );
    }

    private String safe(String v) {
        return v == null || v.isBlank() ? "N/A" : v;
    }
}
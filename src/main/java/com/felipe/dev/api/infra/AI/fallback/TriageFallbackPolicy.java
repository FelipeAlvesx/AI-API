package com.felipe.dev.api.infra.AI.fallback;

import com.felipe.dev.api.application.gateways.AI.AITrace;
import com.felipe.dev.api.application.gateways.AI.TriageAIRequest;
import com.felipe.dev.api.application.gateways.AI.TriageAIResponse;


public class TriageFallbackPolicy {

    public TriageAIResponse fallback(TriageAIRequest req, Exception ex) {
        // regra simples e segura:
        // - se sintomas incluem termos graves -> HIGH
        // - senão MEDIUM como padrão
        boolean severe = req.symptoms().stream().anyMatch(s ->
                s.toLowerCase().contains("dor no peito") ||
                        s.toLowerCase().contains("falta de ar") ||
                        s.toLowerCase().contains("desmaio")
        );

        var urgency = severe ? TriageAIResponse.Urgency.HIGH : TriageAIResponse.Urgency.MEDIUM;

        return new TriageAIResponse(
                urgency,
                "General Practice",
                "Fallback applied due to AI failure: " + ex.getClass().getSimpleName(),
                new AITrace("fallback", "rule-based", "N/A", ex.getMessage(), 0)
        );
    }
}

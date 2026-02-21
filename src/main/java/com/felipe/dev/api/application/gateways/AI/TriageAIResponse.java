package com.felipe.dev.api.application.gateways.AI;

public record TriageAIResponse(
        Urgency urgency,
        String specialty,
        String reason,
        AITrace trace
) {
    public enum Urgency { LOW, MEDIUM, HIGH }
}

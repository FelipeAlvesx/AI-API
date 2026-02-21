package com.felipe.dev.api.application.gateways.AI;

import java.util.List;

public record TriageAIRequest(
        int age,
        List<String> symptoms,
        String medicalHistorySummary
) {}

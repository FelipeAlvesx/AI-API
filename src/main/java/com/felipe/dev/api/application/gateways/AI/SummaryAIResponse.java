package com.felipe.dev.api.application.gateways.AI;

public record SummaryAIResponse(
        String summaryText,
        AITrace trace
) {}
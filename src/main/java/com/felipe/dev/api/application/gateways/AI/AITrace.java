package com.felipe.dev.api.application.gateways.AI;

public record AITrace(
        String provider,
        String model,
        String prompt,
        String rawResponse,
        long latencyMs
) {}

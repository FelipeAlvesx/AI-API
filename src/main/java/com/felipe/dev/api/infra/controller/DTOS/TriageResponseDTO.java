package com.felipe.dev.api.infra.controller.DTOS;

import com.felipe.dev.api.application.gateways.AI.AITrace;
import com.felipe.dev.api.application.gateways.AI.TriageAIResponse;
import com.felipe.dev.api.domain.entities.Triage;

public record TriageResponseDTO(
        String urgency,
        String specialty,
        String reason,
        AITrace trace
) {


    public TriageResponseDTO(TriageAIResponse response) {
        this(
                response.urgency().name(),
                response.specialty(),
                response.reason(),
                response.trace()
        );
    }
}

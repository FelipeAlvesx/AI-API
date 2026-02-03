package com.felipe.dev.api.application.usecases.triage;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.gateways.AI.TriageAIRequest;
import com.felipe.dev.api.application.gateways.AI.TriageAIResponse;

public class TriagePatient {

    private final AIClient aiClient;

    public TriagePatient(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public TriageAIResponse execute(TriageAIRequest request, Long id) {
        return aiClient.triage(request,id);
    }

}

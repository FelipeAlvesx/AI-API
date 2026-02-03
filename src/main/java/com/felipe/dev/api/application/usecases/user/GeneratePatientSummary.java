package com.felipe.dev.api.application.usecases.user;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.gateways.AI.SummaryAIRequest;
import com.felipe.dev.api.application.gateways.AI.SummaryAIResponse;

public class GeneratePatientSummary {

    private final AIClient aiClient;

    public GeneratePatientSummary(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public SummaryAIResponse execute(SummaryAIRequest request){
        return aiClient.generateSummary(request);
    }

}

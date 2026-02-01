package com.felipe.dev.api.application.usecases;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.gateways.AI.TriageAIRequest;

public class TriagePatient {

    private final AIClient aiClient;

    public TriagePatient(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public void execute(TriageAIRequest request){
        aiClient.triage(request);
    }

}

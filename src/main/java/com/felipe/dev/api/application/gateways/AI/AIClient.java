package com.felipe.dev.api.application.gateways.AI;

public interface AIClient {

        TriageAIResponse triage(TriageAIRequest request);
        SummaryAIResponse generateSummary(SummaryAIRequest request);

}

package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.usecases.GeneratePatientSummary;
import com.felipe.dev.api.application.usecases.TriagePatient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriageConfig {

    @Bean
    public TriagePatient triagePatient(AIClient aiClient) {
        return new TriagePatient(aiClient);
    }

    @Bean
    public GeneratePatientSummary generatePatientSummary(AIClient aiClient) {
        return new GeneratePatientSummary(aiClient);
    }

}

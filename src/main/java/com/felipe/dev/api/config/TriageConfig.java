package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.gateways.TriageRepository;
import com.felipe.dev.api.application.usecases.GeneratePatientSummary;
import com.felipe.dev.api.application.usecases.TriagePatient;
import com.felipe.dev.api.infra.gateways.TriageMapper;
import com.felipe.dev.api.infra.gateways.TriageRepositoryImpl;
import com.felipe.dev.api.infra.persistence.TriageRepositoryJpa;
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

    @Bean
    public TriageRepositoryImpl triageRepository(TriageMapper triageMapper, TriageRepositoryJpa triageRepositoryJpa) {
        return new TriageRepositoryImpl(triageRepositoryJpa, triageMapper);

    }

    @Bean
    public TriageMapper triageMapper() {
        return new TriageMapper();
    }

}

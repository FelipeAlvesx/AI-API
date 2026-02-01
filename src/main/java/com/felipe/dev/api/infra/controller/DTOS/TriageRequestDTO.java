package com.felipe.dev.api.infra.controller.DTOS;

import java.util.List;

public record TriageRequestDTO(
        int age,
        List<String> symptoms,
        String medicalHistorySummary
) {}

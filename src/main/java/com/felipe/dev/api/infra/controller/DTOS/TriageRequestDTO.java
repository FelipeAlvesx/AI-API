package com.felipe.dev.api.infra.controller.DTOS;

import java.util.List;

public record TriageRequestDTO(
        Long patientId,
        int age,
        List<String> symptoms,
        String medicalHistorySummary
) {}

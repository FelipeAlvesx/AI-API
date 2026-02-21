package com.felipe.dev.api.application.gateways.AI;

public record SummaryAIRequest(
        String patientContext,
        String doctorNotes,
        String diagnosis,
        String prescription
) {}
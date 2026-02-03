package com.felipe.dev.api.infra.controller.DTOS;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentRequest(
        @NotNull Long patientId,
        @NotNull Long doctorId,
        @NotNull LocalDateTime startAt
) {}

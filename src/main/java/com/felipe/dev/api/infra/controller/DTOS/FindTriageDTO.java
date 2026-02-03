package com.felipe.dev.api.infra.controller.DTOS;

import com.felipe.dev.api.domain.entities.Triage;
import com.felipe.dev.api.domain.entities.User;

import java.time.Instant;
import java.util.List;

public record FindTriageDTO(User user, List<Triage> triages) {



}

package com.felipe.dev.api.infra.controller.DTOS;

import com.felipe.dev.api.domain.entities.triage.Triage;
import com.felipe.dev.api.domain.entities.user.User;

import java.util.List;

public record FindTriageDTO(User user, List<Triage> triages) {



}

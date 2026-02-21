package com.felipe.dev.api.application.gateways;

import com.felipe.dev.api.domain.entities.triage.Triage;

import java.util.List;

public interface TriageRepository {

    Triage save(Triage triage);
    List<Triage> findByPatientId(Long patientId);


}

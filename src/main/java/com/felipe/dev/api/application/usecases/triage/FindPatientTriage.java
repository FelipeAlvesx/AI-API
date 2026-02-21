package com.felipe.dev.api.application.usecases.triage;

import com.felipe.dev.api.application.gateways.TriageRepository;
import com.felipe.dev.api.domain.entities.triage.Triage;

import java.util.List;

public class FindPatientTriage {

    private final TriageRepository triageRepository;

    public FindPatientTriage(TriageRepository triageRepository) {
        this.triageRepository = triageRepository;
    }

    public List<Triage> execute(Long patientId) {
        return triageRepository.findByPatientId(patientId);

    }

}

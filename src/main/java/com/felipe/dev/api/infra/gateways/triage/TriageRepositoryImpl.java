package com.felipe.dev.api.infra.gateways.triage;

import com.felipe.dev.api.application.gateways.TriageRepository;
import com.felipe.dev.api.domain.entities.triage.Triage;
import com.felipe.dev.api.infra.persistence.triage.TriageRepositoryJpa;

import java.util.List;

public class TriageRepositoryImpl implements TriageRepository {

    private final TriageRepositoryJpa triageRepository;

    private final TriageMapper triageMapper;

    public TriageRepositoryImpl(TriageRepositoryJpa triageRepository, TriageMapper triageMapper) {
        this.triageRepository = triageRepository;
        this.triageMapper = triageMapper;
    }


    @Override
    public Triage save(Triage triage) {
        triageRepository.save(triageMapper.toEntity(triage));
        return triage;
    }

    @Override
    public List<Triage> findByPatientId(Long patientId) {
        return triageRepository.findByPatientId(patientId).stream()
                .map(triageMapper::toDomain)
                .toList();
    }
}

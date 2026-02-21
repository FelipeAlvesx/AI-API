package com.felipe.dev.api.infra.persistence.triage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriageRepositoryJpa extends JpaRepository<TriageEntity, Long> {

    List<TriageEntity> findByPatientIdOrderByCreatedAtDesc(Long patientId);

    List<TriageEntity> findByPatientId(Long patientId);
}

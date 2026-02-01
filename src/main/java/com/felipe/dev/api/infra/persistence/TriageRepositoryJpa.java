package com.felipe.dev.api.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface TriageRepositoryJpa extends JpaRepository<TriageEntity, Long> {

    List<TriageEntity> findByPatientIdOrderByCreatedAtDesc(Long patientId);

    List<TriageEntity> findByPatientId(Long patientId);
}

package com.felipe.dev.api.infra.persistence.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepositoryJpa extends JpaRepository<AppointmentEntity, Long> {

//    boolean existsScheduledByUserAndStartAt(Long userId, LocalDateTime startAt);

    // Verificação rápida se já existe agendamento para um médico em um startAt exato
    boolean existsByDoctorIdAndStartAt(Long doctorId, LocalDateTime startAt);

}

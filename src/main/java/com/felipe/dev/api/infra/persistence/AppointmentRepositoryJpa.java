package com.felipe.dev.api.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepositoryJpa extends JpaRepository<AppointmentEntity, Long> {

//    boolean existsScheduledByUserAndStartAt(Long userId, LocalDateTime startAt);

}

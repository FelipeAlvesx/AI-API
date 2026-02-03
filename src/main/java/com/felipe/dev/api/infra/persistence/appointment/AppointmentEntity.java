package com.felipe.dev.api.infra.persistence.appointment;


import com.felipe.dev.api.domain.AppointmentStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "appointment", uniqueConstraints = @UniqueConstraint(columnNames = {"doctor_id", "start_at"}))
public class AppointmentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_id", nullable=false)
    private Long patientId;

    @Column(name="doctor_id", nullable=false)
    private Long doctorId;

    @Column(name="start_at", nullable=false)
    private LocalDateTime startAt;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AppointmentStats status;

    @Column(name="created_at", nullable=false)
    private Instant createdAt;

    // Construtor sem-args requerido pelo JPA
    public AppointmentEntity() {
    }

    public AppointmentEntity(Long patientId, Long doctorId, LocalDateTime startAt, AppointmentStats status, Instant createdAt) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startAt = startAt;
        this.status = status;
        this.createdAt = createdAt;
    }

}

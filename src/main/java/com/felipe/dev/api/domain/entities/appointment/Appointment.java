package com.felipe.dev.api.domain.entities.appointment;

import com.felipe.dev.api.domain.AppointmentStats;

import java.time.Instant;
import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private final Long patientId;
    private final Long doctorId;
    private final LocalDateTime startAt;
    private AppointmentStats status;
    private final Instant createdAt;

    public Appointment(Long patientId, Long doctorId, LocalDateTime startAt) {
        if (patientId == null) throw new IllegalArgumentException("patientId is required");
        if (doctorId == null) throw new IllegalArgumentException("doctorId is required");
        if (startAt == null) throw new IllegalArgumentException("startAt is required");

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startAt = startAt;
        this.status = AppointmentStats.SCHEDULED;
        this.createdAt = Instant.now();
    }

    public Appointment(Long id ,Long patientId, Long doctorId, LocalDateTime startAt, AppointmentStats status, Instant createdAt) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startAt = startAt;
        this.status = status;
        this.createdAt = createdAt;
    }

    public void cancel() {
        if (this.status != AppointmentStats.SCHEDULED) {
            throw new IllegalStateException("Only SCHEDULED appointments can be canceled");
        }
        this.status = AppointmentStats.CANCELED;
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Long getDoctorId() { return doctorId; }
    public LocalDateTime getStartAt() { return startAt; }
    public AppointmentStats getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

}
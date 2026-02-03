package com.felipe.dev.api.domain.entities;


import java.time.Instant;

public class Triage {

    private Long id;
    private Long patientId;
    private Instant createdAt;

    private String urgency;   // LOW | MEDIUM | HIGH
    private String specialty;
    private String reason;

    public Triage(Long patientId, String urgency, String specialty, String reason) {
        if (patientId == null) throw new IllegalArgumentException("patientId is required");
        if (urgency == null || urgency.isBlank()) throw new IllegalArgumentException("urgency is required");
        if (specialty == null || specialty.isBlank()) throw new IllegalArgumentException("specialty is required");
        if (reason == null || reason.isBlank()) throw new IllegalArgumentException("reason is required");

        this.patientId = patientId;
        this.urgency = urgency;
        this.specialty = specialty;
        this.reason = reason;
        this.createdAt = Instant.now();
    }

    public Triage(Long id, String urgency, String specialty, String reason, Instant createdAt) {
        this.id = id;
        this.urgency = urgency;
        this.specialty = specialty;
        this.reason = reason;
        this.createdAt = createdAt;
    }
    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Instant getCreatedAt() { return createdAt; }
    public String getUrgency() { return urgency; }
    public String getSpecialty() { return specialty; }
    public String getReason() { return reason; }

}

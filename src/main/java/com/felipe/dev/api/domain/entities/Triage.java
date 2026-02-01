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
        this.patientId = patientId;
        this.urgency = urgency;
        this.specialty = specialty;
        this.reason = reason;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Long getPatientId() { return patientId; }
    public Instant getCreatedAt() { return createdAt; }
    public String getUrgency() { return urgency; }
    public String getSpecialty() { return specialty; }
    public String getReason() { return reason; }

}

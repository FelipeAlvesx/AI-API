package com.felipe.dev.api.infra.persistence.triage;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "triage")
public class TriageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="patient_id", nullable=false)
    private Long patientId;

    @Column(name="created_at", nullable=false)
    private Instant createdAt;

    @Column(nullable=false)
    private String urgency;

    @Column(nullable=false)
    private String specialty;

    @Column(nullable=false, columnDefinition = "TEXT")
    private String reason;

    public TriageEntity() {}

    public TriageEntity(Long patientId, String urgency, String specialty, String reason) {
        this.patientId = patientId;
        this.urgency = urgency;
        this.specialty = specialty;
        this.reason = reason;
        this.createdAt = Instant.now();
    }
}

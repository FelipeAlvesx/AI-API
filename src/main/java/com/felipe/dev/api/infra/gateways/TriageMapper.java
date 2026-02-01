package com.felipe.dev.api.infra.gateways;

import com.felipe.dev.api.domain.entities.Triage;
import com.felipe.dev.api.infra.persistence.TriageEntity;

public class TriageMapper {

    public Triage toDomain(TriageEntity triageEntity) {
        return new Triage(triageEntity.getPatientId(), triageEntity.getUrgency(),
                triageEntity.getSpecialty(), triageEntity.getReason());
    }

    public TriageEntity toEntity(Triage triage) {
        return new TriageEntity(triage.getPatientId(), triage.getUrgency(),
                triage.getSpecialty(), triage.getReason());
    }


}

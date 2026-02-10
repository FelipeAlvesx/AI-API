package com.felipe.dev.api.infra.gateways.triage;

import com.felipe.dev.api.domain.entities.triage.Triage;
import com.felipe.dev.api.infra.persistence.triage.TriageEntity;

public class TriageMapper {

    public Triage toDomain(TriageEntity triageEntity) {
        return new Triage(triageEntity.getId() ,triageEntity.getPatientId(), triageEntity.getUrgency(),
                triageEntity.getSpecialty(), triageEntity.getReason());
    }

    public TriageEntity toEntity(Triage triage) {
        return new TriageEntity(triage.getPatientId(), triage.getUrgency(),
                triage.getSpecialty(), triage.getReason());
    }


}

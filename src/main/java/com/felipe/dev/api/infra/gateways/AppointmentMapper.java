package com.felipe.dev.api.infra.gateways;

import com.felipe.dev.api.domain.entities.Appointment;
import com.felipe.dev.api.infra.persistence.AppointmentEntity;

public class AppointmentMapper {

    public Appointment toDomain(AppointmentEntity appointmentEntity) {
        return new Appointment(
                appointmentEntity.getId(),
                appointmentEntity.getPatientId(),
                appointmentEntity.getStartAt(),
                appointmentEntity.getStatus(),
                appointmentEntity.getCreatedAt()
        );
    }

    public AppointmentEntity toEntity(Appointment appointment) {
        return new AppointmentEntity(
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getStartAt(),
                appointment.getStatus(),
                appointment.getCreatedAt()
        );
    }


}

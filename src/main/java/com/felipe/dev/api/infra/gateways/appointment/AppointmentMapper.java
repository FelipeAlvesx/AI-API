package com.felipe.dev.api.infra.gateways.appointment;

import com.felipe.dev.api.domain.entities.appointment.Appointment;
import com.felipe.dev.api.infra.persistence.appointment.AppointmentEntity;

public class AppointmentMapper {

    public Appointment toDomain(AppointmentEntity appointmentEntity) {
        return new Appointment(
                appointmentEntity.getId(),
                appointmentEntity.getPatientId(),
                appointmentEntity.getDoctorId(),
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

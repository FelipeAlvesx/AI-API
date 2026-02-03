package com.felipe.dev.api.application.usecases;

import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.domain.entities.Appointment;

public class ScheduleAppointment {

    private final AppointmentRepository appointmentRepository;

    public ScheduleAppointment(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment execute(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }


}

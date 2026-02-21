package com.felipe.dev.api.application.usecases.appointment;

import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.domain.entities.appointment.Appointment;

public class ScheduleAppointment {

    private final AppointmentRepository appointmentRepository;

    public ScheduleAppointment(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment execute(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }


}

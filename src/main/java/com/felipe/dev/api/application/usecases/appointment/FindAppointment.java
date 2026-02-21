package com.felipe.dev.api.application.usecases.appointment;

import java.util.List;

import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.domain.entities.appointment.Appointment;

public class FindAppointment {

    private final AppointmentRepository appointmentRepository;

    public FindAppointment (AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;

    }

    public List<Appointment> execute() {
        return appointmentRepository.findAll();
    }
    
}

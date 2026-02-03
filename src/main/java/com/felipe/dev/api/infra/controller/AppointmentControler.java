package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.appointment.ScheduleAppointment;
import com.felipe.dev.api.domain.entities.appointment.Appointment;
import com.felipe.dev.api.infra.controller.DTOS.AppointmentRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentControler {


    private final ScheduleAppointment scheduleAppointment;

    public AppointmentControler(ScheduleAppointment scheduleAppointment) {
        this.scheduleAppointment = scheduleAppointment;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody @Valid AppointmentRequest request) {
        var appointment = new Appointment(request.patientId(), request.doctorId(), request.startAt());
        var scheduled = scheduleAppointment.execute(appointment);
        return ResponseEntity.ok().body(scheduled);
    }


}

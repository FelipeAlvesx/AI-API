package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.appointment.FindAppointment;
import com.felipe.dev.api.application.usecases.appointment.ScheduleAppointment;
import com.felipe.dev.api.domain.entities.appointment.Appointment;
import com.felipe.dev.api.infra.controller.DTOS.AppointmentRequest;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    private final ScheduleAppointment scheduleAppointment;
    private final FindAppointment findAppointment;

    public AppointmentController(ScheduleAppointment scheduleAppointment, FindAppointment findAppointment) {
        this.scheduleAppointment = scheduleAppointment;
        this.findAppointment = findAppointment;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody @Valid AppointmentRequest request) {
        var appointment = new Appointment(request.patientId(), request.doctorId(), request.startAt());
        var scheduled = scheduleAppointment.execute(appointment);
        return ResponseEntity.ok().body(scheduled);
    }

    @GetMapping()
    public ResponseEntity<List<Appointment>> findAll() {
        return ResponseEntity.ok().body(findAppointment.execute());
    }

}

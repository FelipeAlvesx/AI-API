package com.felipe.dev.api.application.gateways;

import com.felipe.dev.api.domain.entities.appointment.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

    Appointment save(Appointment appointment);

    List<Appointment> findAll();

    List<Appointment> findAllByPatientId(Long patientId);

    List<Appointment> findAllByDoctorId(Long doctorId);

    Optional<Appointment> findById(Long id);

    boolean existsScheduledByDoctorAndStartAt(Long doctorId, LocalDateTime startAt);


}

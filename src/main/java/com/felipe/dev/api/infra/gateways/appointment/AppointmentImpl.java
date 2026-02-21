package com.felipe.dev.api.infra.gateways.appointment;


import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.UserType;
import com.felipe.dev.api.domain.entities.appointment.Appointment;
import com.felipe.dev.api.domain.entities.user.User;
import com.felipe.dev.api.infra.persistence.appointment.AppointmentRepositoryJpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AppointmentImpl implements AppointmentRepository {

    private final AppointmentRepositoryJpa appointmentRepositoryJpa;
    private final AppointmentMapper appointmentMapper;
    private final UserRepository userRepository;

    public AppointmentImpl(AppointmentRepositoryJpa appointmentRepositoryJpa, AppointmentMapper appointmentMapper, UserRepository userRepository) {
        this.appointmentRepositoryJpa = appointmentRepositoryJpa;
        this.appointmentMapper = appointmentMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        var now = LocalDateTime.now();
        var user = userRepository.findById(appointment.getDoctorId());

        if (user == null) {
            throw new IllegalArgumentException("Doctor not found");
        }

        if (user.getUserType() != UserType.DOCTOR) {
            throw new IllegalArgumentException("The provided user is not a doctor");
        }

        if (appointment.getStartAt().isBefore(now)) {
            throw new IllegalArgumentException("Scheduled date cannot be in the past");
        }

        boolean exists = appointmentRepositoryJpa.existsByDoctorIdAndStartAt(appointment.getDoctorId(), appointment.getStartAt());
        if (exists) {
            throw new IllegalArgumentException("The doctor already has an appointment scheduled at this time");
        }

        var appointmentSaved = appointmentRepositoryJpa.save(appointmentMapper.toEntity(appointment));
        return appointmentMapper.toDomain(appointmentSaved);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepositoryJpa.findAll()
                .stream()
                .map(appointmentMapper::toDomain)
                .toList();
    }

    @Override
    public List<Appointment> findAllByPatientId(Long patientId) {
        return appointmentRepositoryJpa.findAllByPatientId(patientId)
                .stream()
                .map(appointmentMapper::toDomain)
                .toList();
    }

    @Override
    public List<Appointment> findAllByDoctorId(Long doctorId) {
        return appointmentRepositoryJpa.findAllByDoctorId(doctorId)
            .stream()
            .map(appointmentMapper::toDomain)
            .toList();
               
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepositoryJpa.findById(id)
        .map(appointmentMapper::toDomain);
    }

    @Override
    public boolean existsScheduledByDoctorAndStartAt(Long doctorId, LocalDateTime startAt) {
        return appointmentRepositoryJpa.existsByDoctorIdAndStartAt(doctorId, startAt);
    }


    public boolean existsAppointment(User user, Appointment appointment ,LocalDateTime AppointmentDateTime) {
        // mantém para compatibilidade com chamada externa (se houver), mas delega ao repositório
        if (user == null) return false;
        if (user.getUserType() != UserType.DOCTOR) return false;
        return appointmentRepositoryJpa.existsByDoctorIdAndStartAt(appointment.getDoctorId(), AppointmentDateTime);
    }
}

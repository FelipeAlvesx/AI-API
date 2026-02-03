package com.felipe.dev.api.infra.gateways;


import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.UserType;
import com.felipe.dev.api.domain.entities.Appointment;
import com.felipe.dev.api.domain.entities.User;
import com.felipe.dev.api.infra.persistence.AppointmentRepositoryJpa;
import com.felipe.dev.api.infra.persistence.UserRepositoryJpa;

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
    public void save(Appointment appointment) {
        var now = LocalDateTime.now();
        var user = userRepository.findById(appointment.getDoctorId());

        if(appointment.getStartAt().isBefore(now)) {
            throw new IllegalArgumentException("Scheduled date cannot be in the past");
        }

        boolean exists = existsAppointment(user, appointment, appointment.getStartAt());
        if(exists){
            throw new IllegalArgumentException("The doctor already has an appointment scheduled at this time");
        }

        appointmentRepositoryJpa.save(appointmentMapper.toEntity(appointment));
    }

    @Override
    public List<Appointment> findAll() {
        return List.of();
    }

    @Override
    public List<Appointment> findAllByPatientId(Long patientId) {
        return List.of();
    }

    @Override
    public List<Appointment> findAllByDoctorId(Long doctorId) {
        return List.of();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsScheduledByDoctorAndStartAt(Long doctorId, LocalDateTime startAt) {
        return false;
    }


    public boolean existsAppointment(User user, Appointment appointment ,LocalDateTime AppointmentDateTime) {
        if(user.getUserType() == UserType.DOCTOR){
            var userId = user.getId();
            if(appointment.getDoctorId().equals(userId) && appointment.getStartAt().getHour() == AppointmentDateTime.getHour()) {
                return true; // Retorna true se houver uma consulta agendada para o médico na data
            }

        }
        return false;
    }
}

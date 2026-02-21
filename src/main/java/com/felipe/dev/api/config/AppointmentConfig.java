package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.application.usecases.appointment.FindAppointment;
import com.felipe.dev.api.application.usecases.appointment.ScheduleAppointment;
import com.felipe.dev.api.infra.gateways.appointment.AppointmentImpl;
import com.felipe.dev.api.infra.gateways.appointment.AppointmentMapper;
import com.felipe.dev.api.infra.persistence.appointment.AppointmentRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfig {

    @Bean
    AppointmentImpl AppointmentImpl(AppointmentRepositoryJpa appointmentRepositoryJpa, AppointmentMapper appointmentMapper, UserRepository userRepository) {
        return new AppointmentImpl(appointmentRepositoryJpa, appointmentMapper, userRepository);
    }

    @Bean
    AppointmentMapper AppointmentMapper() {
        return new AppointmentMapper();
    }


    @Bean
    ScheduleAppointment scheduleAppointment(AppointmentRepository appointmentRepository) {
        return new ScheduleAppointment(appointmentRepository);
    }

    @Bean
    FindAppointment findAppointment(AppointmentRepository appointmentRepository) {
        return new FindAppointment(appointmentRepository);
    }

}

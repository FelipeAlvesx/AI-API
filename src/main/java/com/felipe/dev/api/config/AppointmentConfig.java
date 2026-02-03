package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.AppointmentRepository;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.infra.gateways.AppointmentImpl;
import com.felipe.dev.api.infra.gateways.AppointmentMapper;
import com.felipe.dev.api.infra.persistence.AppointmentRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentConfig {

    @Bean
    public AppointmentImpl AppointmentImpl(AppointmentRepositoryJpa appointmentRepositoryJpa, AppointmentMapper appointmentMapper, UserRepository userRepository) {
        return new AppointmentImpl(appointmentRepositoryJpa, appointmentMapper, userRepository);
    }

    @Bean
    public AppointmentMapper AppointmentMapper() {
        return new AppointmentMapper();
    }

}

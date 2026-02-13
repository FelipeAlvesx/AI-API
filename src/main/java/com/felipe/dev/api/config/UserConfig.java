package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.TriageRepository;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.application.usecases.triage.FindPatientTriage;
import com.felipe.dev.api.application.usecases.user.FindDoctors;
import com.felipe.dev.api.application.usecases.user.RegisterPatient;
import com.felipe.dev.api.application.usecases.user.UpdatePatient;
import com.felipe.dev.api.infra.gateways.user.UserMapper;
import com.felipe.dev.api.infra.gateways.user.UserRepositoryImpl;
import com.felipe.dev.api.infra.persistence.user.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public RegisterPatient registerPatient(UserRepository userRepository) {
        return new RegisterPatient(userRepository);
    }

    @Bean
    public UpdatePatient UpdatePatient(UserRepository userRepository) {
        return new UpdatePatient(userRepository);
    }

    @Bean
    public FindPatientTriage findPatientTriage(TriageRepository triageRepository) {
        return new FindPatientTriage(triageRepository);
    }

    @Bean
    public FindDoctors findDoctors(UserRepository userRepository) {
        return new FindDoctors(userRepository);
    }

    @Bean
    public UserRepositoryImpl getUserRepositoryImpl(UserRepositoryJpa userRepositoryJpa, UserMapper mapper) {
        return new UserRepositoryImpl(userRepositoryJpa, mapper);
    }

    @Bean
    public UserMapper getUserMapper() {
        return new UserMapper();
    }

}

package com.felipe.dev.api.config;

import com.felipe.dev.api.application.gateways.AI.AIClient;
import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.application.usecases.RegisterPatient;
import com.felipe.dev.api.application.usecases.TriagePatient;
import com.felipe.dev.api.application.usecases.UpdatePatient;
import com.felipe.dev.api.infra.gateways.UserMapper;
import com.felipe.dev.api.infra.gateways.UserRepositoryImpl;
import com.felipe.dev.api.infra.persistence.UserRepositoryJpa;
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
    public UserRepositoryImpl getUserRepositoryImpl(UserRepositoryJpa userRepositoryJpa, UserMapper mapper) {
        return new UserRepositoryImpl(userRepositoryJpa, mapper);
    }

    @Bean
    public UserMapper getUserMapper() {
        return new UserMapper();
    }

}

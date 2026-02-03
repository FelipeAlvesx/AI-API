package com.felipe.dev.api.application.usecases.user;

import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.entities.user.User;

public class RegisterPatient {

    private final UserRepository repository;

    public RegisterPatient(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public User execute(User user) {
        return repository.registerPatient(user);
    }

}

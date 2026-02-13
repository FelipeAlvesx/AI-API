package com.felipe.dev.api.application.usecases.user;

import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.entities.user.User;

import java.util.List;

public class FindDoctors {

    private final UserRepository userRepository;

    public FindDoctors(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findDoctors();
    }

}

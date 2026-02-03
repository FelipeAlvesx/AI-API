package com.felipe.dev.api.application.usecases.user;

import com.felipe.dev.api.application.gateways.UserRepository;

public class UpdatePatient {

    private final UserRepository userRepository;

    public UpdatePatient(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long userId, String name, String email, String phone) {
        var user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.updatePatient(user);
    }

}

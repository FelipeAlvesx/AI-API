package com.felipe.dev.api.application.gateways;

import com.felipe.dev.api.domain.entities.user.User;

import java.util.List;

public interface UserRepository {


    User registerPatient(User user);

    User updatePatient(User user);

    User findById(Long id);

    List<User> findDoctors();



}

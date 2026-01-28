package com.felipe.dev.api.infra.gateways;

import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.entities.User;
import com.felipe.dev.api.infra.persistence.UserEntity;
import com.felipe.dev.api.infra.persistence.UserRepositoryJpa;

public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa repository;

    private final UserMapper mapper;

    public UserRepositoryImpl(UserRepositoryJpa userRepositoryJpa, UserMapper mapper) {
        this.repository = userRepositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public User registerPatient(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        repository.save(userEntity);
        return mapper.toDomain(userEntity);
    }

    @Override
    public User updatePatient(User user) {
        return null;
    }
}

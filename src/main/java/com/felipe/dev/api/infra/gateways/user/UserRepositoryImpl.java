package com.felipe.dev.api.infra.gateways.user;

import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.domain.UserType;
import com.felipe.dev.api.domain.entities.user.User;
import com.felipe.dev.api.infra.persistence.user.UserEntity;
import com.felipe.dev.api.infra.persistence.user.UserRepositoryJpa;

import java.util.List;

import static org.hibernate.Hibernate.map;

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

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .stream().map(mapper::toDomain).findFirst().orElse(null);
    }

    @Override
    public List<User> findDoctors() {
        return repository.findByUserType(UserType.DOCTOR)
                .stream()
                .map(mapper::toDomain).toList();
    }
}

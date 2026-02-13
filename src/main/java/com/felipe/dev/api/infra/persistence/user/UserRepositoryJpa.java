package com.felipe.dev.api.infra.persistence.user;

import com.felipe.dev.api.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserType(UserType userType);
}

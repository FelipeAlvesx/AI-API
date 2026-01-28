package com.felipe.dev.api.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
}

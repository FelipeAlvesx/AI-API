package com.felipe.dev.api.infra.gateways;

import com.felipe.dev.api.domain.entities.User;
import com.felipe.dev.api.infra.persistence.UserEntity;

public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getEmail(), userEntity.getUserType());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getEmail(), user.getUserType());
    }


}

package com.felipe.dev.api.infra.gateways.user;

import com.felipe.dev.api.domain.entities.user.User;
import com.felipe.dev.api.infra.persistence.user.UserEntity;

public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId() ,userEntity.getName(), userEntity.getEmail(), userEntity.getUserType(), userEntity.getPhone());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getEmail(), user.getUserType(), user.getPhone());
    }


}

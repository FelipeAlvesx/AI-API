package com.felipe.dev.api.infra.controller.DTOS;

import com.felipe.dev.api.domain.entities.user.User;


public record FindDoctorsDto(

        Long id,

        String name,

        String email,

        String userType,

        String phone

) {

    public FindDoctorsDto(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getUserType().name(), user.getPhone());
    }


}

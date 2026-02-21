package com.felipe.dev.api.infra.controller.DTOS;

import com.felipe.dev.api.domain.UserType;
import com.felipe.dev.api.domain.entities.user.User;
import jakarta.validation.constraints.NotBlank;

public record UserDto(

        @NotBlank
        String name,

        String email,

        @NotBlank
        String userType,

        @NotBlank
        String phone
) {

}

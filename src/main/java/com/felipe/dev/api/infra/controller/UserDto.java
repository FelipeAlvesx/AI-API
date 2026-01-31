package com.felipe.dev.api.infra.controller;

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

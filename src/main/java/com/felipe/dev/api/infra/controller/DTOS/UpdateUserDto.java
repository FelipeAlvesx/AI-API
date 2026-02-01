package com.felipe.dev.api.infra.controller.DTOS;

public record UpdateUserDto(
        Long userId,
        String name,
        String email,
        String phone,
        String userType

) {
}

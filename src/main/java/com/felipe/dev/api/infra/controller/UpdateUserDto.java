package com.felipe.dev.api.infra.controller;

public record UpdateUserDto(
        Long userId,
        String name,
        String email,
        String phone,
        String userType

) {
}

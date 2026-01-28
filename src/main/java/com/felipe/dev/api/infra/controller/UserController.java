package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.RegisterPatient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private final RegisterPatient registerPatient;

    public UserController(RegisterPatient registerPatient) {
        this.registerPatient = registerPatient;
    }

    @PostMapping
    public ResponseEntity<?> register() {
        // Implementation goes here
        return null;
    }

}

package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.RegisterPatient;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final RegisterPatient registerPatient;

    public UserController(RegisterPatient registerPatient) {
        this.registerPatient = registerPatient;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto) {
        // Implementation goes here
        return null;
    }

    @GetMapping
    public ResponseEntity<?> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

}

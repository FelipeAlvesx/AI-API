package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.RegisterPatient;
import com.felipe.dev.api.application.usecases.UpdatePatient;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final RegisterPatient registerPatient;

    private final UpdatePatient updatePatient;

    public UserController(RegisterPatient registerPatient, UpdatePatient updatePatient) {
        this.updatePatient = updatePatient;
        this.registerPatient = registerPatient;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto) {
        // Implementation goes here
        return null;
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserDto userDto) {
        return null;
    }

}

package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.usecases.RegisterPatient;
import com.felipe.dev.api.application.usecases.UpdatePatient;
import com.felipe.dev.api.domain.entities.User;
import com.felipe.dev.api.infra.controller.DTOS.UpdateUserDto;
import com.felipe.dev.api.infra.controller.DTOS.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        var user = new User(userDto);
        registerPatient.execute(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserDto userDto) {
        return null;
    }

}

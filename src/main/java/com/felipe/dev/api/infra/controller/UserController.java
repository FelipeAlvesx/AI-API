package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.gateways.UserRepository;
import com.felipe.dev.api.application.usecases.FindPatientTriage;
import com.felipe.dev.api.application.usecases.RegisterPatient;
import com.felipe.dev.api.application.usecases.UpdatePatient;
import com.felipe.dev.api.domain.entities.User;
import com.felipe.dev.api.infra.controller.DTOS.FindTriageDTO;
import com.felipe.dev.api.infra.controller.DTOS.UpdateUserDto;
import com.felipe.dev.api.infra.controller.DTOS.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final RegisterPatient registerPatient;

    private final FindPatientTriage findPatientTriage;

    private final UpdatePatient updatePatient;

    private final UserRepository userRepository;

    public UserController(RegisterPatient registerPatient, UpdatePatient updatePatient, FindPatientTriage findPatientTriage, UserRepository userRepository) {
        this.updatePatient = updatePatient;
        this.registerPatient = registerPatient;
        this.findPatientTriage = findPatientTriage;
        this.userRepository = userRepository;
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


    @GetMapping("{id}/triages")
    public ResponseEntity<FindTriageDTO> findPatientTriages(@PathVariable Long id){
        var response = findPatientTriage.execute(id);
        var dto = new FindTriageDTO(userRepository.findById(id), response);
        return ResponseEntity.ok(dto);
    }

}

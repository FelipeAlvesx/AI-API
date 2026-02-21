package com.felipe.dev.api.infra.controller;

import com.felipe.dev.api.application.gateways.AI.TriageAIRequest;
import com.felipe.dev.api.application.usecases.user.GeneratePatientSummary;
import com.felipe.dev.api.application.usecases.triage.TriagePatient;
import com.felipe.dev.api.infra.controller.DTOS.TriageRequestDTO;
import com.felipe.dev.api.infra.controller.DTOS.TriageResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/triage")
public class TriageController {

    private final TriagePatient triagePatient;

    private final GeneratePatientSummary generatePatientSummary;

    public TriageController(TriagePatient triagePatient, GeneratePatientSummary generatePatientSummary) {
        this.generatePatientSummary = generatePatientSummary;
        this.triagePatient = triagePatient;
    }

    @PostMapping
    public ResponseEntity<?> triage(@RequestBody TriageRequestDTO request){
        TriageAIRequest triageAIRequest = new TriageAIRequest(
                request.age(), request.symptoms(), request.medicalHistorySummary());
        TriageResponseDTO response = new TriageResponseDTO(triagePatient.execute(triageAIRequest, request.patientId()));
        return ResponseEntity.ok(response);
    }


}

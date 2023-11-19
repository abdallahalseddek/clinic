package com.mangement.clinic.controller;


import com.mangement.clinic.dto.PatientDTO;
import com.mangement.clinic.model.Patient;
import com.mangement.clinic.service.serviceImplementation.PatientServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
@AllArgsConstructor
public class PatientController {
    private final PatientServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<PatientDTO> newPatient(@RequestBody Patient newPatient) {
        return new ResponseEntity<>(service.newPatient(newPatient), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatientInfo(@RequestBody Patient patient) {
        return new ResponseEntity<>(service.updatePatientInfo(patient), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public void deletePatient(String name) {
        service.deletePatient(name);
    }
}

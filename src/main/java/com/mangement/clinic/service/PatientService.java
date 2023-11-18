package com.mangement.clinic.service;

import com.mangement.clinic.dto.PatientDTO;
import com.mangement.clinic.model.Patient;

public interface PatientService {
    PatientDTO newPatient(Patient newPatient);

    PatientDTO updatePatientInfo(Patient patient);

    void deletePatient(String name);
}

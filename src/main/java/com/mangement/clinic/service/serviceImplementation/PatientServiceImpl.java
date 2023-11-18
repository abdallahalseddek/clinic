package com.mangement.clinic.service.serviceImplementation;

import com.mangement.clinic.dto.PatientDTO;
import com.mangement.clinic.exeption.PatientException;
import com.mangement.clinic.mapper.PatientMapper;
import com.mangement.clinic.model.Patient;
import com.mangement.clinic.repository.PatientRepository;
import com.mangement.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Override
    public PatientDTO newPatient(Patient newPatient) {
        if (repository.findByFirstName(newPatient.getFirstName()).isPresent()) {
            throw new PatientException(newPatient.getFirstName());
        }
        return mapper.mapToDTO(repository.save(newPatient));
    }

    @Override
    public PatientDTO updatePatientInfo(Patient patient) {
        Patient updatedPatient = repository.findById(patient.getPatientId())
                .orElseThrow(() -> new PatientException("NO Such Patient Exist!"));
        updatedPatient.setAddress(patient.getAddress());
        updatedPatient.setContactInfo(patient.getContactInfo());
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        return mapper.mapToDTO(repository.save(updatedPatient));
    }

    @Override
    public void deletePatient(String name) {
        Patient patient = repository.findByFirstName(name)
                .orElseThrow(() -> new PatientException("Patient does not exist"));
        repository.delete(patient);
    }
}

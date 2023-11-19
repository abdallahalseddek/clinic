package com.mangement.clinic.mapper;

import com.mangement.clinic.dto.PatientDTO;
import com.mangement.clinic.model.Patient;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PatientMapper {
    PatientDTO mapToDTO(Patient patientEntity);

   // Patient mapToEntity(PatientDTO patientDTO);
}

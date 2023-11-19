package com.mangement.clinic.mapper;

import com.mangement.clinic.dto.AppointmentDTO;
import com.mangement.clinic.model.Appointment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface AppointmentMapper {
    AppointmentDTO mapToDTO(Appointment appointmentEntity);

    //Appointment mapToEntity(AppointmentDTO appointmentDTO);
}

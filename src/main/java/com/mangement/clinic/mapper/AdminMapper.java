package com.mangement.clinic.mapper;

import com.mangement.clinic.dto.AdminDTO;
import com.mangement.clinic.model.ClinicAdmin;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {
    AdminDTO mapToDTO(ClinicAdmin adminEntity);

    //ClinicAdmin mapToEntity(AdminDTO adminDTO);
}

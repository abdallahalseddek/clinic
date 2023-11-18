package com.mangement.clinic.service;

import com.mangement.clinic.dto.AdminDTO;
import com.mangement.clinic.model.ClinicAdmin;

import java.util.List;

public interface AdminService {
    AdminDTO createNewAdminUser(ClinicAdmin newAdmin);

    AdminDTO updateAdminInfo(ClinicAdmin admin);

    List<AdminDTO> allRegisteredAdmins();

    void deleteAdmin(String username);
}

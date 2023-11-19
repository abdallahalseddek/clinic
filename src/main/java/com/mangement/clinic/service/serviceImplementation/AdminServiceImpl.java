package com.mangement.clinic.service.serviceImplementation;

import com.mangement.clinic.dto.AdminDTO;
import com.mangement.clinic.exeption.AdminException;
import com.mangement.clinic.mapper.AdminMapper;
import com.mangement.clinic.model.ClinicAdmin;
import com.mangement.clinic.repository.AdminRepository;
import com.mangement.clinic.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;
    private final AdminMapper mapper;

    @Override
    public AdminDTO createNewAdminUser(ClinicAdmin newAdmin) {
        if (repository.findByUsername(newAdmin.getUsername()).isPresent()) {
            throw new AdminException(newAdmin.getUsername());
        }
        return mapper.mapToDTO(repository.save(newAdmin));
    }

    @Override
    public AdminDTO updateAdminInfo(ClinicAdmin admin) {
        ClinicAdmin updatedAdmin = repository.findById(admin.getAdminId())
                .orElseThrow(() -> new AdminException("NO Such User Exist!"));
        updatedAdmin.setUsername(admin.getUsername());
        updatedAdmin.setPassword(admin.getPassword());
        return mapper.mapToDTO(repository.save(admin));
    }

    @Override
    public List<AdminDTO> allRegisteredAdmins() {
        return repository.findAll()
                .stream().map(mapper::mapToDTO).toList();
    }

    @Override
    public void deleteAdmin(String username) {
        ClinicAdmin admin = repository.findByUsername(username)
                .orElseThrow(() -> new AdminException("Requested User to be deleted does not exist"));
        repository.delete(admin);
    }
}

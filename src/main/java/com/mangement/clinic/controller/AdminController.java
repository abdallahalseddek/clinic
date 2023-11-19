package com.mangement.clinic.controller;

import com.mangement.clinic.dto.AdminDTO;
import com.mangement.clinic.model.ClinicAdmin;
import com.mangement.clinic.service.serviceImplementation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")

public class AdminController {
    private final AdminServiceImpl service;

    @Autowired public AdminController(AdminServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDTO> createNewAdminUser(@RequestBody ClinicAdmin newAdmin) {
        return new ResponseEntity<>(service.createNewAdminUser(newAdmin), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AdminDTO> updateAdminInfo(@RequestBody ClinicAdmin admin) {
        return new ResponseEntity<>(service.updateAdminInfo(admin), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> allRegisteredAdmins() {
        return new ResponseEntity<>(service.allRegisteredAdmins(), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public void deleteAdmin(@RequestBody String username) {
        service.deleteAdmin(username);
    }
}

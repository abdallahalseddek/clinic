package com.mangement.clinic.repository;

import com.mangement.clinic.model.ClinicAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<ClinicAdmin, Integer> {
    Optional<ClinicAdmin> findByUsername(String username);
}

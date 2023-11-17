package com.mangement.clinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clinic_admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClinicAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "admin_id")
    private Integer adminId;
    private String username;
    private String password;
}

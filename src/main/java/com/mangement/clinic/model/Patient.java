package com.mangement.clinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_Id")
    private Integer patientId;
    private String firstName;
    private String lastName;
    private String address;
    private String contactInfo;
    @ManyToMany(mappedBy = "patients")
    private List<Appointment> appointments;
}

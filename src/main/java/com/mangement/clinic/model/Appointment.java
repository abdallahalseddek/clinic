package com.mangement.clinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "appointment_Id")
    private Integer appointmentId;
    private String reason;
    private Status status = Status.Scheduled;
    private String address;
    private String contactInfo;
    @ManyToMany
    @JoinTable(name = "patient_appointment", joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_Id"))
    private List<Patient> patients;
    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "admin_id")
    private ClinicAdmin admin;
}

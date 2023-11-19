package com.mangement.clinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Appointment")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "appointment_Id")
    private Integer appointmentId;
    private Date date;
    private Duration duration;
    private String reason;
    private Status status = Status.Scheduled;
    private String address;
    private String contactInfo;
    @ManyToMany
    @JoinTable(name = "patient_appointment", joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_Id"))
    private List<Patient> patients;
    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private ClinicAdmin admin;

    public Appointment() {
    }

    public Appointment(Integer appointmentId, Date date, Duration duration, String reason, Status status, String address, String contactInfo, List<Patient> patients, ClinicAdmin admin) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.duration = duration;
        this.reason = reason;
        this.status = status;
        this.address = address;
        this.contactInfo = contactInfo;
        this.patients = patients;
        this.admin = admin;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public ClinicAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(ClinicAdmin admin) {
        this.admin = admin;
    }
}

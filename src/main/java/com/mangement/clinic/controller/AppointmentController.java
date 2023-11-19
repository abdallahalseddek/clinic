package com.mangement.clinic.controller;

import com.mangement.clinic.dto.AppointmentDTO;
import com.mangement.clinic.model.Appointment;
import com.mangement.clinic.model.Status;
import com.mangement.clinic.service.serviceImplementation.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")

public class AppointmentController {
    private final AppointmentServiceImpl service;

    @Autowired public AppointmentController(AppointmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> createNewAppointment(Appointment newAppointment) {
        return new ResponseEntity<>(service.createNewAppointment(newAppointment), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<AppointmentDTO> updateAppointmentStatus(Appointment appointment, Status newstatus) {
        return new ResponseEntity<>(service.updateAppointmentStatus(appointment,newstatus), HttpStatus.ACCEPTED);
    }

    @GetMapping("/today")
    public ResponseEntity<List<AppointmentDTO>> listTodayAppointments() {
        return new ResponseEntity<>(service.listTodayAppointments(), HttpStatus.FOUND);
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<AppointmentDTO>> findAppointmentsByDate(Date date) {
        return new ResponseEntity<>(service.findAppointmentsByDate(date), HttpStatus.FOUND);
    }

    @GetMapping("/history")
    public ResponseEntity<List<AppointmentDTO>> PatientAppointmentsHistory(String patientName) {
        return new ResponseEntity<>(service.PatientAppointmentsHistory(patientName), HttpStatus.FOUND);
    }
}

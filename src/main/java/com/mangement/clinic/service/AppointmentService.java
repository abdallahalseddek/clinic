package com.mangement.clinic.service;


import com.mangement.clinic.dto.AppointmentDTO;
import com.mangement.clinic.model.Appointment;
import com.mangement.clinic.model.Status;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    AppointmentDTO createNewAppointment(Appointment newAppointment);

    AppointmentDTO updateAppointmentStatus(Appointment appointment, Status newstatus);

    List<AppointmentDTO> listTodayAppointments();

    List<AppointmentDTO> findAppointmentsByDate(Date date);

    List<AppointmentDTO> PatientAppointmentsHistory(String patientName);
}

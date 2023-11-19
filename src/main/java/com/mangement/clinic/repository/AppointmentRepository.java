package com.mangement.clinic.repository;

import com.mangement.clinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByDate(Date date);
    // @Query("select a.date, p.firstName from Appointment a join Patient p on p.patientId=a.appointmentId group by a.date limit 5")
    // List<Appointment> findAppointmentsByPatients(String patientName);
}

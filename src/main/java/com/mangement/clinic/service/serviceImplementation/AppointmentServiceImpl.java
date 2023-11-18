package com.mangement.clinic.service.serviceImplementation;

import com.mangement.clinic.dto.AppointmentDTO;
import com.mangement.clinic.exeption.AppointmentException;
import com.mangement.clinic.mapper.AppointmentMapper;
import com.mangement.clinic.model.Appointment;
import com.mangement.clinic.model.Status;
import com.mangement.clinic.repository.AppointmentRepository;
import com.mangement.clinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentDTO createNewAppointment(Appointment newAppointment) {
        return mapper.mapToDTO(repository.save(newAppointment));
    }

    @Override
    public AppointmentDTO updateAppointmentStatus(Appointment appointment,Status newstatus) {
        Appointment updatedappointment = repository.findById(appointment.getAppointmentId())
                .orElseThrow(() -> new AppointmentException("Not Exists"));
        updatedappointment.setStatus(newstatus);
        return mapper.mapToDTO(repository.save(updatedappointment));
    }

    @Override
    public List<AppointmentDTO> listTodayAppointments() {
        List<Appointment> appointments = repository.findByDate(new Date());
        return appointments.stream()
                .map(mapper::mapToDTO)
                .toList();
    }

    @Override
    public List<AppointmentDTO> findAppointmentsByDate(Date date) {
        List<Appointment> appointments = repository.findByDate(date);
        return appointments.stream()
                .map(mapper::mapToDTO).toList();
    }

    @Override
    public List<AppointmentDTO> PatientAppointmentsHistory(String patientName) {
        List<Appointment> appointments = repository.findAppointmentsByPatient(patientName);
        return appointments.stream()
                .map(mapper::mapToDTO).toList();
    }
}

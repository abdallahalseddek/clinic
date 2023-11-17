package com.mangement.clinic.dto;

import com.mangement.clinic.model.ClinicAdmin;
import com.mangement.clinic.model.Patient;
import com.mangement.clinic.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Date date;
    private Duration duration;
    private String reason;
    private Status status = Status.Scheduled;
    private String address;
    private String contactInfo;
}

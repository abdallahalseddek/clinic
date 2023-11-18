package com.mangement.clinic.dto;

import com.mangement.clinic.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;

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
    private String patientName;
}

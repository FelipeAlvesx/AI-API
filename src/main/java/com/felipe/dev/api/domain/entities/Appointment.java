package com.felipe.dev.api.domain.entities;

import com.felipe.dev.api.domain.AppointmentStats;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private LocalDateTime date;
    private User patient;
    private User doctor;
    private AppointmentStats status;

}

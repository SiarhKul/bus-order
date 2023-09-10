package com.example.busorder.models.dto;

import lombok.Builder;
import lombok.Data;


import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
public class ScheduleDTO {

    private LocalDate date;
    private Time time;
    private Integer amountPassengersTest;
    private String dep;
    private String dest;
}
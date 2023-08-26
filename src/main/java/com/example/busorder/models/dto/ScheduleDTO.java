package com.example.busorder.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
@ToString
public class ScheduleDTO {


    private LocalDate date;
    private Time time;
    private Integer amountPassengersTest;
    private String dep;
    private String dest;
}
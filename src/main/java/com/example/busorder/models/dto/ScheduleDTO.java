package com.example.busorder.models.dto;

import lombok.Builder;
import lombok.Data;


import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
public class ScheduleDTO {

    private Integer id;
    private LocalDate date;
    private Time time;
    private Integer amountPassengersTest;
    private String dep;
    private String dest;
    private Integer ticketPrice;

}

/*
* todo: Add price and amount of available seats
 */
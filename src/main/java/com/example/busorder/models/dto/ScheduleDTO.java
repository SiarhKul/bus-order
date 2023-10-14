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
}

/*
* todo: Add price and amount of available seats
*  {
            "date": "2023-01-01",
            "time": "13:30:00",
            "amountPassengersTest": 3,
            "dep": "Minsk",
            "dest": "Grodno"
        },
* * */
package com.example.busorder.models.dto;

import com.example.busorder.models.entities.Route;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ScheduleDTO {

    private Integer id;
    private Route route;
    private LocalDate date;
    private Time time;
    private Integer amountPassengers;
}
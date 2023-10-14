package com.example.busorder.models.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalDate;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookingRequestDTO {

    @Future(message = "The date must be in the future.")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Min(1)
    private Integer numberPeople;
    //todo Create enum
    @NotEmpty(message = "Departure city is not be empty")
    private String departureCity;

    @NotEmpty(message = "Destination city is not be empty")
    private String destinationCity;

    @NotEmpty(message = "BusStation in not be empty")
    private String busStopDeparture;

    @NotEmpty(message = "BusStation in not be empty")
    private String busStopDestination;





}
/*
 * todo

 *    3. depBusStation
 *     4.desBusStation
 *    5.Price
 * * */

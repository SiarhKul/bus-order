package com.example.busorder.models.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TripDTO {

    //    @Future(message = "The date must be in the future.")
    private LocalDate date;

    @NotEmpty(message = "Departure city is not be empty")
    private String departureCity;

    @NotEmpty(message = "Destination city is not be empty")
    private String destinationCity;

    @Min(1)
    @Max(20)
    private Integer numberPeople;

}

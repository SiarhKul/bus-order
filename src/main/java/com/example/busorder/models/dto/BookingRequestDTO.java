package com.example.busorder.models.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookingRequestDTO {

    @NotEmpty( message = "Date city is not be empty")
    private Date date;

    @NotEmpty( message = "Departure city is not be empty")
    private String departureCity;

    @NotEmpty( message = "Destination city is not be empty")
    private String destinationCity;

    @NotEmpty(message = "Number of people is not be empty")
    private Integer numberPeople;

}

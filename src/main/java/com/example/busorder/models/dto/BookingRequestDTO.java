package com.example.busorder.models.dto;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    private LocalDateTime date;

    @NotEmpty(message = "Departure city is not be empty")
    private String departureCity;

    @NotEmpty(message = "Destination city is not be empty")
    private String destinationCity;

    @Min(1)
    private Integer numberPeople;

}
/*
 * todo

 *    3. depBusStation
 *     4.desBusStation
 *    5.Price
 * * */

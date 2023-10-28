package com.example.busorder.models.dto;

import com.example.busorder.enums.Cities;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @NotNull
    @Valid
    private Cities departureCity;

    @NotNull
    @Valid
    private Cities destinationCity;

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

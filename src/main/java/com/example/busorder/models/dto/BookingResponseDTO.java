package com.example.busorder.models.dto;

import com.example.busorder.enums.BookingStatus;
import com.example.busorder.enums.Cities;
import com.example.busorder.models.entities.Client;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class BookingResponseDTO {

    private int id;
    private Client client;
    private BookingStatus status;
    private LocalDate date;
    private Time time;
    private Integer numberPeople;
    private Cities departureCity;
    private Cities destinationCity;
    private String busStopDeparture;
    private String busStopDestination;
}
/*
 * todo
 *    5.Price
  */

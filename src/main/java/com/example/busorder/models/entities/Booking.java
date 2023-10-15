package com.example.busorder.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalDate;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Booking")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Column(name = "number_people")
    private Integer numberPeople;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "destination_city")
    private String destinationCity;


    @Column(name = "bus_stop_departure")
    private String busStopDeparture;

    @Column(name = "bus_stop_destination")
    private String busStopDestination;
}
/*
* todo
*    1. Status must be enum
*    5.Price
* * */
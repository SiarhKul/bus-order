package com.example.busorder.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "number_people")
    private Integer numberPeople;

    @Column(name = "bus_stop_departure")
    private String busStopDeparture;

    @Column(name = "bus_stop_destination")
    private String busStopDestination;
}
/*
* todo
*    1. Status must be enum
*    2. Need to return list of bookings when you click on order button
*    3. depBusStation
*     4.desBusStation
*    5.Price
* * */
package com.example.busorder.models.entities;


import com.example.busorder.enums.BookingStatus;
import com.example.busorder.enums.Cities;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Column(name = "number_people")
    private Integer numberPeople;

//   Used CityEnumAttributeConverter instead of @Enumerated(EnumType.STRING)
    @Column(name = "departure_city")
    private Cities departureCity;

//   Used CityEnumAttributeConverter instead of @Enumerated(EnumType.STRING)
    @Column(name = "destination_city")
    private Cities destinationCity;


    @Column(name = "bus_stop_departure")
    private String busStopDeparture;

    @Column(name = "bus_stop_destination")
    private String busStopDestination;
}

/*
* todo
*    5.Price
**/
package com.example.busorder.models.entities;


import jakarta.persistence.*;
import lombok.*;

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

    //todo add dependency
    @Column(name = "client_id")
    private int clientId;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "number_people")
    private Integer numberPeople;
}

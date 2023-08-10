package com.example.busorder.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Route")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "departure_city")
    private String departure_city;

    @Column(name = "destination_city")
    private String destination_city;

}

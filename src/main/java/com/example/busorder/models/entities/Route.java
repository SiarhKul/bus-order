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
    private int id;

    @Column(name = "departure_city")
    private String departure_city;

    @Column(name = "destination_city")
    private String destination_city;

}
/*
*  @ManyToOne(optional = false)
    @JoinColumn(name = "departure_city_id")
    private City departure_city_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_city_id")
    private City destination_city_id;
*
* */
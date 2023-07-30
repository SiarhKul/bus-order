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

//    @Column(name = "route")
//    private String route;

    @OneToOne(mappedBy = "id")
    @Column(name = "departure_city_id")
    private int departure_city_id;

    @OneToOne(mappedBy = "id")
    @Column(name = "destination_city_id")
    private int destination_city_id;

}

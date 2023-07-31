package com.example.busorder.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "City")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class City {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}

//@OneToOne()
//@JoinColumn(name = "departure_city_id", referencedColumnName = "id")
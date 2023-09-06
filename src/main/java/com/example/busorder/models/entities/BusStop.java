package com.example.busorder.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Station")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "station")
    private String station;

    @OneToOne()
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
}

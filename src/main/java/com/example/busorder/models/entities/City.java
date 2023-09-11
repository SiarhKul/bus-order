package com.example.busorder.models.entities;

import com.example.busorder.Cities;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

//    @Valid
//    @Column(name = "name")
//    @Enumerated(EnumType.STRING)
//    private Cities name;

//    @OneToOne(mappedBy = "city")
//    private BusStop busStop;
}

package com.example.busorder.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Route")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "route")
    private String route;

}

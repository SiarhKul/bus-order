package com.example.busorder.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @OneToMany(mappedBy = "client")
    private List<Booking> booking;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mobile_phone")
    private int mobilePhone;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "password")
    private String password;
}

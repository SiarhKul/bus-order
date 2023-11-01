package com.example.busorder.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "Schedule")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id")
    private Route route;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Column(name = "amount_passengers")
    private Integer amountPassengers;

    @Column(name = "ticket_price")
    private Integer ticketPrice;

}

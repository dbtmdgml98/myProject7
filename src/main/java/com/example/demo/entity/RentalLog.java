package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class RentalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logMessage;

    @Enumerated(value = EnumType.STRING)
    private RentalLogStatus rentalLogStatus; // SUCCESS, FAILURE

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public RentalLog(Reservation reservation, String logMessage, RentalLogStatus rentalLogStatus) {
        this.reservation = reservation;
        this.logMessage = logMessage;
        this.rentalLogStatus = rentalLogStatus;
    }

    public RentalLog() {}
}

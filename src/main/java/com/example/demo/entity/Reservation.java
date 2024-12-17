package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus; // PENDING, APPROVED, CANCELED, EXPIRED

    public Reservation(Item item, User user, ReservationStatus reservationStatus, LocalDateTime startAt, LocalDateTime endAt) {
        this.item = item;
        this.user = user;
        this.reservationStatus = reservationStatus;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Reservation() {}

    public void updateStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}

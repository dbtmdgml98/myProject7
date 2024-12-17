package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import java.util.List;

// custom repository
public interface ReservationRepositoryQuery {

    List<Reservation> findReservations(Long userId, Long itemId);
}

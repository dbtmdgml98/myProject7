package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = Reservation.class, idClass = Long.class)
public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryQuery {

    List<Reservation> findByUserIdAndItemId(Long userId, Long itemId);

    List<Reservation> findByUserId(Long userId);

    List<Reservation> findByItemId(Long itemId);

    @Query("SELECT r FROM Reservation r " +
            "WHERE r.item.id = :id " +
            "AND NOT (r.endAt <= :startAt OR r.startAt >= :endAt) " +
            "AND r.reservationStatus = 'APPROVED'")
    List<Reservation> findConflictingReservations(
            @Param("id") Long id,
            @Param("startAt") LocalDateTime startAt,
            @Param("endAt") LocalDateTime endAt
    );

    // 방법1) JOIN FETCH
    @Override
    @Query("SELECT r FROM Reservation r JOIN FETCH r.user JOIN FETCH r.item")
    List<Reservation> findAll();

//    // 방법2) @EntityGraph
//    @EntityGraph(attributePaths = {"user", "item"})
//    List<Reservation> findAll();
}
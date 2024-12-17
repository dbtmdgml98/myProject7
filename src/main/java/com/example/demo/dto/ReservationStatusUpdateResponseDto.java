package com.example.demo.dto;

import com.example.demo.entity.Reservation;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationStatusUpdateResponseDto {

    private Long id;
    private String nickname;
    private String itemName;
    private String status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public ReservationStatusUpdateResponseDto(Long id, String nickname, String itemName, String status, LocalDateTime startAt, LocalDateTime endAt ) {
        this.id = id;
        this.nickname = nickname;
        this.itemName = itemName;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public static ReservationStatusUpdateResponseDto toDto(Reservation reservation) {
        return new ReservationStatusUpdateResponseDto(
                reservation.getId(),
                reservation.getUser().getNickname(),
                reservation.getItem().getName(),
                reservation.getReservationStatus().getStatus(),
                reservation.getStartAt(),
                reservation.getEndAt()
        );
    }
}

package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum ReservationStatus {

    PENDING("pending"),
    APPROVED("approved"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String status;

    ReservationStatus(String status) {
        this.status = status;
    }

    public static ReservationStatus of(String status) throws IllegalArgumentException {
        for (ReservationStatus reservationStatus : values()) {
            if (reservationStatus.getStatus().equals(status)) {
                return reservationStatus;
            }
        }

        throw new IllegalArgumentException("해당하는 상태가 없습니다.: " + status);
    }
}

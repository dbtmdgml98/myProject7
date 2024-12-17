package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum RentalLogStatus {

    SUCCESS("예약 성공"),
    FAILURE("예약 실패");

    private final String status;

     RentalLogStatus(String status) {
        this.status = status;
    }
}

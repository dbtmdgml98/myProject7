package com.example.demo.dto;

import com.example.demo.entity.ReservationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class ReservationStatusUpdateRequestDto {

    private String status;
}

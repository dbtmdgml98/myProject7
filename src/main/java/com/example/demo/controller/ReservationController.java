package com.example.demo.controller;

import com.example.demo.dto.ReservationRequestDto;
import com.example.demo.dto.ReservationResponseDto;
import com.example.demo.dto.ReservationStatusUpdateRequestDto;
import com.example.demo.dto.ReservationStatusUpdateResponseDto;
import com.example.demo.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationResponseDto> createReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        ReservationResponseDto reservationResponseDto = reservationService.createReservation(reservationRequestDto.getItemId(),
                reservationRequestDto.getUserId(),
                reservationRequestDto.getStartAt(),
                reservationRequestDto.getEndAt());

        return new ResponseEntity<>(reservationResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/update-status")
    public ResponseEntity<ReservationStatusUpdateResponseDto> updateReservation(@PathVariable Long id, @RequestBody ReservationStatusUpdateRequestDto status) {
        ReservationStatusUpdateResponseDto updateReservationStatus = reservationService.updateReservationStatus(id, status);

        return new ResponseEntity<>(updateReservationStatus, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDto>> findAll() {
        List<ReservationResponseDto> reservationResponseDtoList = reservationService.getReservations();

        return new ResponseEntity<>(reservationResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ReservationResponseDto>> searchAll(@RequestParam(required = false) Long userId,
                          @RequestParam(required = false) Long itemId) {
        List<ReservationResponseDto> reservationResponseDtoList = reservationService.searchAndConvertReservations(userId, itemId);

        return new ResponseEntity<>(reservationResponseDtoList, HttpStatus.OK);
    }
}

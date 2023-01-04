package com.komponente.KorisnickiServis2.controller;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/makeReservation")
    public ResponseEntity<ReservationDto> makeReservation(@RequestBody()ReservationCreateDto reservationCreateDto) {
        System.out.println(reservationCreateDto.getVehicleId());
        return new ResponseEntity<>(reservationService.createReservation(reservationCreateDto), HttpStatus.OK);
    }


    @PostMapping("/cancelReservation")
    public ResponseEntity<ReservationDto> cancelReservation(@RequestBody() ReservationCancelDto reservationCancelDto) {
        return new ResponseEntity<>(reservationService.cancelReservation(reservationCancelDto), HttpStatus.OK);
    }

    @PostMapping("/getReservation")
    public ResponseEntity<List<ReservationDto>> getReservation(@RequestBody() FindReservationsDto findReservationsDto) {
        return new ResponseEntity<>(reservationService.findAllForUser(findReservationsDto), HttpStatus.OK);
    }
}

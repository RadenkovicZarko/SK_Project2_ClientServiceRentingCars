package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.dto.FindReservationsDto;
import com.komponente.KorisnickiServis2.dto.ReservationCancelDto;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    ReservationDto createReservation(ReservationCreateDto reservationCreateDto);

    ReservationDto cancelReservation(ReservationCancelDto reservationCancelDto);

    List<Reservation> findAll();

    void sendScheduledNotification(Reservation reservation);

    List<ReservationDto> findAllForUser(FindReservationsDto findReservationsDto);


}

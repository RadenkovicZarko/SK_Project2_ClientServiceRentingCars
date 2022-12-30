package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.dto.ReservationCancelDto;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReservationDto;

public interface ReservationService {

    ReservationDto createReservation(ReservationCreateDto reservationCreateDto);

    ReservationDto cancelReservation(ReservationCancelDto reservationCancelDto);


}

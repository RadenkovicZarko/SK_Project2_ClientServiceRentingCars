package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.dto.ReservationCancelDto;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation reservationDtoToReservation(ReservationCreateDto reservationCreateDto)
    {
        Reservation reservation=new Reservation();
        reservation.setUserId(reservationCreateDto.getUserId());
        //reservation.setVehicle(reservationCreateDto.getVehicle());
        reservation.setDate_from(reservationCreateDto.getDate_from());
        reservation.setDate_to(reservationCreateDto.getDate_to());
        return reservation;
    }

    public ReservationDto reservationToReservationDto(Reservation reservation)
    {
        ReservationDto reservationDto=new ReservationDto();
        reservationDto.setUserId(reservation.getUserId());
        reservationDto.setVehicle(reservation.getVehicle());
        reservationDto.setDate_from(reservation.getDate_from());
        reservationDto.setDate_to(reservation.getDate_to());
        reservationDto.setPrice(reservation.getPrice());
        return reservationDto;
    }

    public Reservation reservationCancelDtoToReservation(ReservationCancelDto reservationCancelDto)
    {
        Reservation reservation=new Reservation();
        reservation.setId(reservationCancelDto.getId());
        reservation.setUserId(reservationCancelDto.getUserId());
        reservation.setVehicle(reservationCancelDto.getVehicle());
        reservation.setDate_to(reservationCancelDto.getDate_to());
        reservation.setDate_from(reservationCancelDto.getDate_from());
        return reservation;
    }
}

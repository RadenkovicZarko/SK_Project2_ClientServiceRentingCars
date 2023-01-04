package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Reservation;
import com.komponente.KorisnickiServis2.dto.ReservationCancelDto;
import com.komponente.KorisnickiServis2.dto.ReservationCreateDto;
import com.komponente.KorisnickiServis2.dto.ReservationDto;
import com.komponente.KorisnickiServis2.repository.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {


    public Reservation reservationDtoToReservation(ReservationCreateDto reservationCreateDto)
    {
        Reservation reservation=new Reservation();
        reservation.setUserId(reservationCreateDto.getUserId());
        //reservation.setId_vehicle(reservationCreateDto.getId_vehicle());
        reservation.setDate_from(reservationCreateDto.getDate_from());
        reservation.setDate_to(reservationCreateDto.getDate_to());
        return reservation;
    }

    public ReservationDto reservationToReservationDto(Reservation reservation)
    {
        ReservationDto reservationDto=new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setUserId(reservation.getUserId());
        reservationDto.setId_vehicle(reservation.getVehicle().getId());
        reservationDto.setDate_from(reservation.getDate_from());
        reservationDto.setDate_to(reservation.getDate_to());
        reservationDto.setPrice(reservation.getPrice());
        reservationDto.setModelName(reservation.getVehicle().getModel().getName());
        reservationDto.setTypeName(reservation.getVehicle().getType().getName());
        return reservationDto;
    }

    public ReservationDto reservationCancelDtoToReservationDto(ReservationCancelDto reservationCancelDto)
    {
        ReservationDto reservationDto=new ReservationDto();
        reservationDto.setId(reservationCancelDto.getId());
        reservationDto.setUserId(reservationCancelDto.getUserId());
        reservationDto.setId_vehicle(reservationCancelDto.getId_vehicle());
        reservationDto.setDate_to(reservationCancelDto.getDate_to());
        reservationDto.setDate_from(reservationCancelDto.getDate_from());
        return reservationDto;
    }
}

package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query(value="select * from reservation  WHERE reservation.user_id=?1",nativeQuery = true)
    Optional<List<Reservation>> findAllReservationsForUser(Long id);


}

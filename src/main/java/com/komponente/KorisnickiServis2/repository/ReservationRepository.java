package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}

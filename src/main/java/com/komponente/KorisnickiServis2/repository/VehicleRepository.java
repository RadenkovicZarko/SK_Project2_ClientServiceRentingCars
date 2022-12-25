package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query(value="select vehicle.* from company join vehicle on (company.id=vehicle.company_id) WHERE company.city=?1",nativeQuery = true)
    Optional<List<Vehicle>> findAllVehicleForCity(String city);

    @Query(value="select vehicle.* from company join vehicle on (company.id=vehicle.company_id) WHERE company.name=?1",nativeQuery = true)
    Optional<List<Vehicle>> findAllVehicleForCompany(String company);

    @Query(value = "select vehicle.* from vehicle where vehicle.id NOT IN(select vehicle.id from vehicle join reservation on(vehicle.id=reservation.vehicle_id) WHERE (?1>=reservation.date_from and ?2<=reservation.date_to) OR (?1>=reservation.date_from and ?1<=reservation.date_to) OR (?2>=reservation.date_from and ?2<=reservation.date_to))",nativeQuery = true)
    Optional<List<Vehicle>> findAllVehicleInDateInterval(Date d1, Date d2);

}

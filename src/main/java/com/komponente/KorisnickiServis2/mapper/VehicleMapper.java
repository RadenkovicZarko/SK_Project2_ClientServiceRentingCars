package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDto vehicleToVehicleDto(Vehicle vehicle)
    {
        VehicleDto vehicleDto=new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setType(vehicle.getType());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setCompany(vehicle.getCompany());
        return vehicleDto;
    }


}

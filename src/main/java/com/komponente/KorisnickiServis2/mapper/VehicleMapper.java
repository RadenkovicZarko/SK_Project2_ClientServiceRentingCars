package com.komponente.KorisnickiServis2.mapper;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.VehicleCreateDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDto vehicleToVehicleDto(Vehicle vehicle)
    {
        VehicleDto vehicleDto=new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setModel(vehicle.getModel().getName());
        vehicleDto.setType(vehicle.getType().getName());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setCompany(vehicle.getCompany().getName());
        return vehicleDto;
    }

    public VehicleCreateDto vehicleToVehicleCreateDto(Vehicle vehicle)
    {
        VehicleCreateDto vehicleDto=new VehicleCreateDto();
        vehicleDto.setModel(vehicle.getModel().getId());
        vehicleDto.setType(vehicle.getType().getId());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setCompany(vehicle.getCompany().getId());
        return vehicleDto;
    }




}

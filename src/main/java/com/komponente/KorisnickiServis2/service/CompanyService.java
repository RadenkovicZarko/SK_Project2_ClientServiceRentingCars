package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CompanyService {
    List<VehicleDto> findAllVehicleForCity(CityDto cityDto);

    List<VehicleDto> findAllVehicleForCompany(CompanyDto companyDto);

    List<VehicleDto> findAllVehicleInDateInterval(DateDto dateDto);

    VehicleDto add(VehicleCreateDto vehicleCreateDto);

}

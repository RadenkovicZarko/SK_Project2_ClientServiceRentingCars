package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.CityDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import org.springframework.data.domain.Page;


public interface CompanyService {
    Page<VehicleDto> findAllVehicleForCity(CityDto cityDto);

}

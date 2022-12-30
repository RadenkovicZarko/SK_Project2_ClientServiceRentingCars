package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.SearchDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    List<VehicleDto> findAllVehicleForSearchParameter(SearchDto searchDto);

}

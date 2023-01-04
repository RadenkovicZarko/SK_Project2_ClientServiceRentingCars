package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.dto.*;

import java.util.List;

public interface VehicleService {
    List<VehicleDto> findAllVehicleForSearchParameter(SearchDto searchDto);

    List<TypeDto> getAllTypes();
    List<ModelDto> getAllModels();

    VehicleCreateDto addVehicle(VehicleCreateDto vehicleCreateDto);

}

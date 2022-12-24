package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.dto.CityDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import com.komponente.KorisnickiServis2.repository.CompanyRepository;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ReservationRepository reservationRepository;

    @Override
    public Page<VehicleDto> findAllVehicleForCity(CityDto cityDto) {
        return null;
    }
}

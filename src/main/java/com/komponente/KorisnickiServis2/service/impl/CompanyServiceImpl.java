package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.VehicleMapper;
import com.komponente.KorisnickiServis2.repository.CompanyRepository;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.repository.VehicleRepository;
import com.komponente.KorisnickiServis2.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private VehicleRepository vehicleRepository;
    private ReservationRepository reservationRepository;
    private VehicleMapper vehicleMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, VehicleRepository vehicleRepository, ReservationRepository reservationRepository, VehicleMapper vehicleMapper) {
        this.companyRepository = companyRepository;
        this.vehicleRepository = vehicleRepository;
        this.reservationRepository = reservationRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleDto> findAllVehicleForCity(CityDto cityDto) {
        List<Vehicle> vozilo=vehicleRepository.findAllVehicleForCity(cityDto.getCity()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));
        List<VehicleDto> list=new ArrayList<>();
        if(cityDto.getSort())
        {
            vozilo.sort(Comparator.comparingInt(Vehicle::getPrice));
        }
        for(Vehicle v:vozilo)
            list.add(vehicleMapper.vehicleToVehicleDto(v));
        return list;
    }

    @Override
    public List<VehicleDto> findAllVehicleForCompany(CompanyDto companyDto) {
        List<Vehicle> vozilo=vehicleRepository.findAllVehicleForCompany(companyDto.getCompanyName()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));
        List<VehicleDto> list=new ArrayList<>();
        if(companyDto.getSort())
        {
            vozilo.sort(Comparator.comparingInt(Vehicle::getPrice));
        }
        for(Vehicle v:vozilo)
            list.add(vehicleMapper.vehicleToVehicleDto(v));
        return list;
    }


    @Override
    public List<VehicleDto> findAllVehicleInDateInterval(DateDto dateDto) {
        System.out.println(dateDto.getTo()+ " "+dateDto.getFrom());
        List<Vehicle> vozilo=vehicleRepository.findAllVehicleInDateInterval(dateDto.getFrom(),dateDto.getTo()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));
        List<VehicleDto> list=new ArrayList<>();
        for(Vehicle v:vozilo)
            list.add(vehicleMapper.vehicleToVehicleDto(v));
        return list;
    }

    @Override
    public VehicleDto add(VehicleCreateDto vehicleCreateDto) {
        return null;
    }


}

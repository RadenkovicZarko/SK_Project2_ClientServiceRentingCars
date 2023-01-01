package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.TypeMapper;
import com.komponente.KorisnickiServis2.mapper.VehicleMapper;
import com.komponente.KorisnickiServis2.repository.CompanyRepository;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.repository.ReviewRepository;
import com.komponente.KorisnickiServis2.repository.VehicleRepository;
import com.komponente.KorisnickiServis2.service.CompanyService;
import com.komponente.KorisnickiServis2.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ReviewRepository reviewRepository;





    @Override // Treba da se doda  sortiranje po averageRating-u
    public List<CompanyDto> findAllCompaniesWithRating() {
        List<Company> listaKompanija = companyRepository.findAll();


        List<CompanyDto> companyDtos=new ArrayList<>();
        for(Company c:listaKompanija)
        {
            Long avgRating=companyRepository.findAllReviewForCompany(c.getName()).orElseThrow(() -> new NotFoundException(String
                    .format("Cant calculate average of rating")));
            CompanyDto companyDto=new CompanyDto(c.getName(),avgRating);
            companyDtos.add(companyDto);
        }
        companyDtos.sort(Comparator.comparingLong(CompanyDto::getRating));
        return companyDtos;
    }

//    private CompanyRepository companyRepository;
//    private VehicleRepository vehicleRepository;
//    private ReservationRepository reservationRepository;
//    private VehicleMapper vehicleMapper;
//
//
//    public CompanyServiceImpl(CompanyRepository companyRepository, VehicleRepository vehicleRepository, ReservationRepository reservationRepository, VehicleMapper vehicleMapper) {
//        this.companyRepository = companyRepository;
//        this.vehicleRepository = vehicleRepository;
//        this.reservationRepository = reservationRepository;
//        this.vehicleMapper = vehicleMapper;
//    }


//    @Override
//    public VehicleDto add(VehicleCreateDto vehicleCreateDto) {
//        return null;
//    }









//    @Override
//    public List<VehicleDto> findAllVehicleForCity(CityDto cityDto) {
//        List<Vehicle> vozilo=vehicleRepository.findAllVehicleForCity(cityDto.getCity()).orElseThrow(() -> new NotFoundException(String
//                .format("There is no such cars")));
//        List<VehicleDto> list=new ArrayList<>();
//        if(cityDto.getSort())
//        {
//            vozilo.sort(Comparator.comparingInt(Vehicle::getPrice));
//        }
//        for(Vehicle v:vozilo)
//            list.add(vehicleMapper.vehicleToVehicleDto(v));
//        return list;
//    }
//
//    @Override
//    public List<VehicleDto> findAllVehicleForCompany(CompanyDto companyDto) {
//        List<Vehicle> vozilo=vehicleRepository.findAllVehicleForCompany(companyDto.getCompanyName()).orElseThrow(() -> new NotFoundException(String
//                .format("There is no such cars")));
//        List<VehicleDto> list=new ArrayList<>();
//        if(companyDto.getSort())
//        {
//            vozilo.sort(Comparator.comparingInt(Vehicle::getPrice));
//        }
//        for(Vehicle v:vozilo)
//            list.add(vehicleMapper.vehicleToVehicleDto(v));
//        return list;
//    }
//
//
//    @Override
//    public List<VehicleDto> findAllVehicleInDateInterval(DateDto dateDto) {
//        List<Vehicle> vozilo=vehicleRepository.findAllVehicleInDateInterval(dateDto.getFrom(),dateDto.getTo()).orElseThrow(() -> new NotFoundException(String
//                .format("There is no such cars")));
//        List<VehicleDto> list=new ArrayList<>();
//        for(Vehicle v:vozilo)
//            list.add(vehicleMapper.vehicleToVehicleDto(v));
//        return list;
//    }
//
//    @Override
//    public List<TypeDto> findAllAvailbleTypeOfVehicleInDateInterval(DateDto dateDto) {
//        List<Vehicle> vozilo=vehicleRepository.findAllVehicleInDateInterval(dateDto.getFrom(),dateDto.getTo()).orElseThrow(() -> new NotFoundException(String
//                .format("There is no such types")));
//        Set<TypeDto> list=new HashSet<>();
//        for(Vehicle v:vozilo)
//        {
//            Type t=v.getType();
//            list.add(typeMapper.typeToTypeDto(t));
//        }
//        return list.stream().toList();
//    }

}

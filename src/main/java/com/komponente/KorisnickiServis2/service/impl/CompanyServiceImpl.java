package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.CompanyMapper;
import com.komponente.KorisnickiServis2.repository.CompanyRepository;
import com.komponente.KorisnickiServis2.repository.ReviewRepository;
import com.komponente.KorisnickiServis2.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ReviewRepository reviewRepository;
    private CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewRepository reviewRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.reviewRepository = reviewRepository;
        this.companyMapper = companyMapper;
    }

    @Override // Treba da se doda  sortiranje po averageRating-u
    public List<CompanyDto> findAllCompaniesWithRating() {
        List<Company> listaKompanija = companyRepository.findAll();


        List<CompanyDto> companyDtos=new ArrayList<>();
        for(Company c:listaKompanija)
        {
            Long avgRating=companyRepository.findAllReviewForCompany(c.getName()).orElse(Long.valueOf(0));
            CompanyDto companyDto=new CompanyDto(c.getName(),avgRating);
            System.out.println(companyDto.getRating());
            companyDtos.add(companyDto);
        }
        companyDtos.sort(Comparator.comparingLong(CompanyDto::getRating));
        return companyDtos;
    }

    @Override
    public CompanyInformationDto setManager(SetManagerDto setManagerDto) {
        System.out.println(setManagerDto.getNameOfcompany());
        Company company=companyRepository.findByName(setManagerDto.getNameOfcompany()).orElseThrow(() -> new NotFoundException(String
                .format("Cant find company")));
        company.setId_manager(setManagerDto.getId_manager());
        companyRepository.save(company);
        return companyMapper.companyToCompanyInformationDto(company);
    }

    @Override
    public List<SearchCompanyDto> findAllAvailable() {
        List<Company> lista= companyRepository.findAllAvailable();

        List<SearchCompanyDto> searchCompanyDtos=new ArrayList<>();
        for(Company company:lista)
        {
            searchCompanyDtos.add(companyMapper.companyToSearchCompanyDto(company));
        }

        return searchCompanyDtos;
    }

    @Override
    public List<SearchCompanyDto> findAll() {
        List<Company> lista= companyRepository.findAll();

        List<SearchCompanyDto> searchCompanyDtos=new ArrayList<>();
        for(Company company:lista)
        {
            searchCompanyDtos.add(companyMapper.companyToSearchCompanyDto(company));
        }

        return searchCompanyDtos;
    }

    @Override
    public CompanyInformationDto findByIdOfManager(FindCompanyByManagerDto findCompanyByManagerDto) {
       return companyMapper.companyToCompanyInformationDto(companyRepository.findCompanyByManagerId(findCompanyByManagerDto.getManager_id()));

    }

    @Override
    public CompanyInformationDto updateCompany(CompanyInformationDto companyInformationDto) {
        Company company=companyRepository.findById(companyInformationDto.getId()).orElseThrow(() -> new NotFoundException(String
                .format("Cant find company")));
        company.setCity(companyInformationDto.getCity());
        company.setDescription(companyInformationDto.getDescription());
        companyRepository.save(company);
        return companyMapper.companyToCompanyInformationDto(company);
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

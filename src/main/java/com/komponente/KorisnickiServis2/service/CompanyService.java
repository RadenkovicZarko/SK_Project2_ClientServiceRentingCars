package com.komponente.KorisnickiServis2.service;

import com.komponente.KorisnickiServis2.dto.*;

import java.util.List;


public interface CompanyService {


    List<CompanyDto> findAllCompaniesWithRating();

    CompanyInformationDto setManager(SetManagerDto setManagerDto);

    List<SearchCompanyDto> findAllAvailable();
    List<SearchCompanyDto> findAll();

    CompanyInformationDto findByIdOfManager(FindCompanyByManagerDto findCompanyByManagerDto);

    CompanyInformationDto updateCompany(CompanyInformationDto companyInformationDto);

//    VehicleDto add(VehicleCreateDto vehicleCreateDto);
//    List<VehicleDto> findAllVehicleForCity(CityDto cityDto);
//
//    List<VehicleDto> findAllVehicleForCompany(CompanyDto companyDto);
//
//    List<VehicleDto> findAllVehicleInDateInterval(DateDto dateDto);
//
//    List<TypeDto> findAllAvailbleTypeOfVehicleInDateInterval(DateDto dateDto);
}

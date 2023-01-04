package com.komponente.KorisnickiServis2.controller;


import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/averageRating")
    public ResponseEntity<List<CompanyDto>> averageRating() {
        return new ResponseEntity<>(companyService.findAllCompaniesWithRating(), HttpStatus.OK);
    }

    @PostMapping("/setManager")
    public ResponseEntity<CompanyInformationDto> setManager(@RequestBody SetManagerDto setManagerDto){
        return new ResponseEntity<>(companyService.setManager(setManagerDto),HttpStatus.OK);
    }

    @GetMapping("/findAllAvailable")
    public ResponseEntity<List<SearchCompanyDto>> findAllAvailable()
    {
        return new ResponseEntity<>(companyService.findAllAvailable(),HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<SearchCompanyDto>> findAll()
    {
        return new ResponseEntity<>(companyService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/findByIdOfManager")
    public ResponseEntity<CompanyInformationDto> findByIdOfManager(@RequestBody FindCompanyByManagerDto findCompanyByManagerDto){
        return new ResponseEntity<>(companyService.findByIdOfManager(findCompanyByManagerDto),HttpStatus.OK);
    }

    @PostMapping("/updateCompanyDetails")
    public ResponseEntity<CompanyInformationDto> updateCompanyDetails(@RequestBody CompanyInformationDto companyInformationDto){
        return new ResponseEntity<>(companyService.updateCompany(companyInformationDto),HttpStatus.OK);
    }


//    @PostMapping("/findByCity")
//    public ResponseEntity<List<VehicleDto>> findByCity(@RequestBody() @Valid CityDto cityDto) {
//        return new ResponseEntity<>(companyService.findAllVehicleForCity(cityDto), HttpStatus.OK);
//    }
//
//    @PostMapping("/findByCompany")
//    public ResponseEntity<List<VehicleDto>> findByCompany(@RequestBody() @Valid CompanyDto companyDto) {
//        return new ResponseEntity<>(companyService.findAllVehicleForCompany(companyDto), HttpStatus.OK);
//    }
//
//    @PostMapping("/findByDateInterval")
//    public ResponseEntity<List<VehicleDto>> findByDateInterval(@RequestBody() @Valid DateDto dateDto) {
//        return new ResponseEntity<>(companyService.findAllVehicleInDateInterval(dateDto), HttpStatus.OK);
//    }
//
//    @PostMapping("/findTypes")
//    public ResponseEntity<List<TypeDto>> findAllAvailbleTypeOfVehicleInDateInterval(@RequestBody() @Valid DateDto dateDto) {
//        return new ResponseEntity<>(companyService.findAllAvailbleTypeOfVehicleInDateInterval(dateDto), HttpStatus.OK);
//    }

}

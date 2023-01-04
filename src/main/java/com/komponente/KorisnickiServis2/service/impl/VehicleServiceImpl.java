package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Model;
import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.ModelMapper;
import com.komponente.KorisnickiServis2.mapper.TypeMapper;
import com.komponente.KorisnickiServis2.mapper.VehicleMapper;
import com.komponente.KorisnickiServis2.repository.*;
import com.komponente.KorisnickiServis2.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private ReservationRepository reservationRepository;
    private VehicleMapper vehicleMapper;
    private TypeRepository typeRepository;
    private ModelRepository modelRepository;
    private TypeMapper typeMapper;
    private ModelMapper modelMapper;
    private CompanyRepository companyRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ReservationRepository reservationRepository, VehicleMapper vehicleMapper, TypeRepository typeRepository, ModelRepository modelRepository, TypeMapper typeMapper, ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.vehicleRepository = vehicleRepository;
        this.reservationRepository = reservationRepository;
        this.vehicleMapper = vehicleMapper;
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
        this.typeMapper = typeMapper;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<VehicleDto> findAllVehicleForSearchParameter(SearchDto searchDto) {

        List<Vehicle> vozilaZaGrad=new ArrayList<>();
        if(searchDto.getCity()!=null && !searchDto.getCity().isEmpty())
            vozilaZaGrad=vehicleRepository.findAllVehicleForCity(searchDto.getCity()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));

        List<Vehicle> vozilaZaKompaniju=new ArrayList<>();
        if(searchDto.getCompanyName()!=null && !searchDto.getCompanyName().isEmpty())
            vozilaZaKompaniju=vehicleRepository.findAllVehicleForCompany(searchDto.getCompanyName()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));

        List<Vehicle> vozilaUIntervalu=new ArrayList<>();
        if(searchDto.getFrom()!=null && searchDto.getTo()!=null && searchDto.getFrom()!=null && searchDto.getTo()!=null)
            vozilaUIntervalu=vehicleRepository.findAllVehicleInDateInterval(searchDto.getFrom(),searchDto.getTo()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));

        List<Vehicle> vozila=new ArrayList<>();
        if(!vozilaZaGrad.isEmpty() && !vozilaUIntervalu.isEmpty() && !vozilaZaKompaniju.isEmpty())
            vozila = vozilaZaGrad.stream()
                .filter(vozilaUIntervalu::contains).filter(vozilaZaKompaniju::contains).collect(toList());
        else if(!vozilaZaGrad.isEmpty() && !vozilaUIntervalu.isEmpty())
            vozila = vozilaZaGrad.stream()
                    .filter(vozilaUIntervalu::contains).collect(toList());
        else if(!vozilaZaGrad.isEmpty() && !vozilaZaKompaniju.isEmpty())
            vozila = vozilaZaGrad.stream()
                    .filter(vozilaZaKompaniju::contains).collect(toList());
        else if(!vozilaUIntervalu.isEmpty() && !vozilaZaKompaniju.isEmpty())
            vozila = vozilaUIntervalu.stream()
                    .filter(vozilaZaKompaniju::contains).collect(toList());
        else if(!vozilaZaGrad.isEmpty())
            vozila = vozilaZaGrad;
        else if(!vozilaUIntervalu.isEmpty())
            vozila = vozilaUIntervalu;
        else if(!vozilaZaKompaniju.isEmpty())
            vozila=vozilaZaKompaniju;


        if(searchDto.getCity()!=null && searchDto.getCompanyName()!=null && searchDto.getFrom()!=null && searchDto.getTo()!=null && searchDto.getCity().isEmpty() && searchDto.getCompanyName().isEmpty() && (searchDto.getFrom()==null || searchDto.getTo()==null))
            vozila=vehicleRepository.findAll();


        List<VehicleDto> list=new ArrayList<>();
        if(searchDto.getSort()!=null && searchDto.getSort())
        {
            vozila.sort(Comparator.comparingInt(Vehicle::getPrice));
        }
        for(Vehicle v:vozila)
            list.add(vehicleMapper.vehicleToVehicleDto(v));
        return list;


    }

    @Override
    public List<TypeDto> getAllTypes() {

        List<TypeDto> list=new ArrayList<>();
        for(Type t:typeRepository.findAll())
        {
            list.add(typeMapper.typeToTypeDto(t));
        }

        return list;
    }

    @Override
    public List<ModelDto> getAllModels() {
        List<ModelDto> list=new ArrayList<>();
        for(Model t:modelRepository.findAll())
        {
            list.add(modelMapper.modelToModelDto(t));
        }

        return list;
    }

    @Override
    public VehicleCreateDto addVehicle(VehicleCreateDto vehicleCreateDto) {
        Vehicle vehicle=new Vehicle();
        vehicle.setCompany(companyRepository.findById(vehicleCreateDto.getCompany()).orElseThrow(() -> new NotFoundException(String.format("There is no such vehicle"))));
        vehicle.setType(typeRepository.findById(vehicleCreateDto.getType()).orElseThrow(() -> new NotFoundException(String.format("There is no such types"))));
        vehicle.setModel(modelRepository.findById(vehicleCreateDto.getModel()).orElseThrow(() -> new NotFoundException(String.format("There is no such models"))));
        vehicle.setPrice(vehicleCreateDto.getPrice());
        vehicleRepository.save(vehicle);
        return vehicleMapper.vehicleToVehicleCreateDto(vehicle);
    }
}

package com.komponente.KorisnickiServis2.service.impl;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.SearchDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import com.komponente.KorisnickiServis2.exception.NotFoundException;
import com.komponente.KorisnickiServis2.mapper.VehicleMapper;
import com.komponente.KorisnickiServis2.repository.ReservationRepository;
import com.komponente.KorisnickiServis2.repository.VehicleRepository;
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

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ReservationRepository reservationRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.reservationRepository = reservationRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleDto> findAllVehicleForSearchParameter(SearchDto searchDto) {

        List<Vehicle> vozilaZaGrad=new ArrayList<>();
        if(!searchDto.getCity().isEmpty())
            vozilaZaGrad=vehicleRepository.findAllVehicleForCity(searchDto.getCity()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));

        List<Vehicle> vozilaZaKompaniju=new ArrayList<>();
        if(!searchDto.getCompanyName().isEmpty())
            vozilaZaKompaniju=vehicleRepository.findAllVehicleForCompany(searchDto.getCompanyName()).orElseThrow(() -> new NotFoundException(String
                .format("There is no such cars")));

        List<Vehicle> vozilaUIntervalu=new ArrayList<>();
        if(searchDto.getFrom()!=null && searchDto.getTo()!=null)
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


        if(searchDto.getCity().isEmpty() && searchDto.getCompanyName().isEmpty() && (searchDto.getFrom()==null || searchDto.getTo()==null))
            vozila=vehicleRepository.findAll();


        List<VehicleDto> list=new ArrayList<>();
        if(searchDto.getSort())
        {
            vozila.sort(Comparator.comparingInt(Vehicle::getPrice));
        }
        for(Vehicle v:vozila)
            list.add(vehicleMapper.vehicleToVehicleDto(v));
        return list;


    }
}

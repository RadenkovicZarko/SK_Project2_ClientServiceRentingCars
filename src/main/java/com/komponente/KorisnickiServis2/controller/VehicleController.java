package com.komponente.KorisnickiServis2.controller;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.DateDto;
import com.komponente.KorisnickiServis2.dto.SearchDto;
import com.komponente.KorisnickiServis2.dto.TypeDto;
import com.komponente.KorisnickiServis2.dto.VehicleDto;
import com.komponente.KorisnickiServis2.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/findAvailable")
    public ResponseEntity<List<VehicleDto>> findAllAvailableVehicle(@RequestBody() SearchDto searchDto) {
        return new ResponseEntity<>(vehicleService.findAllVehicleForSearchParameter(searchDto), HttpStatus.OK);
    }
}

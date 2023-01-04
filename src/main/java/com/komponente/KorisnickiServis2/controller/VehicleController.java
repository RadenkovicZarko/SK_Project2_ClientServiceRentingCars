package com.komponente.KorisnickiServis2.controller;

import com.komponente.KorisnickiServis2.domain.Vehicle;
import com.komponente.KorisnickiServis2.dto.*;
import com.komponente.KorisnickiServis2.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findTypes")
    public ResponseEntity<List<TypeDto>> findTypes() {
        return new ResponseEntity<>(vehicleService.getAllTypes(), HttpStatus.OK);
    }

    @GetMapping("/findModels")
    public ResponseEntity<List<ModelDto>> findModels() {
        return new ResponseEntity<>(vehicleService.getAllModels(), HttpStatus.OK);
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<VehicleCreateDto> addVehicle(@RequestBody() VehicleCreateDto vehicleCreateDto) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleCreateDto), HttpStatus.OK);
    }
}

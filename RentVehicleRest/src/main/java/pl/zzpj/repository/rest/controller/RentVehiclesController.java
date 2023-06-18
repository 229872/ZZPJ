package pl.zzpj.repository.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.dto.VehicleDto;
import pl.zzpj.repository.rest.api.RentVehiclesService;

import java.util.List;
import java.util.UUID;


@RestController()
@RequestMapping("/rentVehicles")
public class RentVehiclesController {
    @Autowired
    private RentVehiclesService vehiclesService;

    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto){
        return vehiclesService.addVehicle(vehicleDto);
    }

    @PatchMapping(value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public VehicleDto updateVehicle(@PathVariable String id,@RequestBody VehicleDto vehicleDto){
        return vehiclesService.updateVehicle(UUID.fromString(id), vehicleDto);
    }

    @PatchMapping(value = "/switchAvailability/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void switchAvailability(@PathVariable String id){
         vehiclesService.switchAvailability(UUID.fromString(id));
    }

    @DeleteMapping(value = "/remove/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void removeVehicle(@PathVariable String id){
        vehiclesService.removeVehicle(UUID.fromString(id));
    }

    @GetMapping(value = "/getById/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public VehicleDto getById(@PathVariable String id){
        return vehiclesService.getById(UUID.fromString(id));
    }

    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VehicleDto> getAll(){
        return vehiclesService.getAll();
    }

    @GetMapping(value = "/getAllByMake/{make}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VehicleDto> getAllByMake(@PathVariable String make){
        return vehiclesService.getAllByMake(make);
    }

    @GetMapping(value = "/getAllAvailable", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VehicleDto> getAllAvailable(){
        return vehiclesService.getAllAvailable();
    }

    @GetMapping(value = "/getAllByRating/{rating}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VehicleDto> getAllByRating(@PathVariable String rating){
        return vehiclesService.getAllByRating(rating);
    }

}

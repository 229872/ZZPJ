package pl.zzpj.repository.rest.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;
import pl.zzpj.repository.rest.dto.CarDto;
import pl.zzpj.repository.rest.dto.VehicleDto;
import pl.zzpj.repository.rest.api.RentVehiclesService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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


    @PostConstruct
    private void initData() {
        VehicleDto car1 = CarDto.builder()
                .make("Niisan")
                .model("Juke")
                .hourlyRate(20)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Muave")
                .transmission("Manual")
                .drive_type("FWD")
                .fuel_type("Petrol")
                .car_type("Hatchback")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(5)
                .build();

        VehicleDto car2 = CarDto.builder()
                .make("Dacia")
                .model("Sandero")
                .hourlyRate(15)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Dark-Yellow")
                .transmission("Automatic")
                .drive_type("FWD")
                .fuel_type("Diesel")
                .car_type("Hatchback")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(5)
                .build();

        VehicleDto car3 = CarDto.builder()
                .make("Fiat")
                .model("Multipla")
                .hourlyRate(17)
                .isAvailable(true)
                .damage(new ArrayList<>())
                .rating(ConditionRating.ALLWEATHER)
                .color("Beige")
                .transmission("Manual")
                .drive_type("FWD")
                .fuel_type("Petrol")
                .car_type("Hatchback")
                .car_options(new ArrayList<>())
                .specs(new ArrayList<>())
                .doors(5)
                .build();

        vehiclesService.addVehicle(car1);
        vehiclesService.addVehicle(car2);
        vehiclesService.addVehicle(car3);
    }
}

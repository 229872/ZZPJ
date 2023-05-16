package pl.zzpj.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.rest.api.RentVehiclesService;


@RestController(value = "/restVehicles")
@AllArgsConstructor
public class RentVehiclesController {
    private RentVehiclesService vehiclesService;
}

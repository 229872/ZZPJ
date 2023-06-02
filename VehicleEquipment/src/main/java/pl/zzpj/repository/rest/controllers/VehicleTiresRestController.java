package pl.zzpj.repository.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.adapters.VehicleTiresRestAdapter;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/equipment/tires")
public class VehicleTiresRestController {

    private final VehicleTiresRestAdapter restAdapter;

    @Autowired
    public VehicleTiresRestController(VehicleTiresRestAdapter vehicleTiresRestAdapter) {
        this.restAdapter = vehicleTiresRestAdapter;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleTireOutputDto> getAll() {
        return restAdapter.getAllEquipment();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto getEquipmentById(@PathVariable("id") UUID id)
            throws EquipmentNotFoundServiceException {
        return restAdapter.getEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipment(@RequestBody VehicleTireInputDto dto) {
        return restAdapter.addEquipment(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto updateEquipment(@PathVariable UUID id, @RequestBody VehicleTireInputDto dto)
            throws BadEquipmentTypeException, EquipmentNotFoundServiceException {
        return restAdapter.updateEquipment(id, dto);
    }
}

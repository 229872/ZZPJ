package pl.zzpj.repository.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.adapters.VehicleTiresRestAdapter;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/equipment/tires")
public class VehicleTiresRestController {

    private final VehicleTiresRestAdapter tiresRestAdapter;

    @Autowired
    public VehicleTiresRestController(VehicleTiresRestAdapter vehicleTiresRestAdapter) {
        this.tiresRestAdapter = vehicleTiresRestAdapter;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleTireOutputDto> getAll() {
        return tiresRestAdapter.getAllEquipment();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto getEquipmentById(@PathVariable("id") UUID id)
            throws EquipmentNotFoundServiceException {
        return tiresRestAdapter.getEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "summer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSummer(@RequestBody VehicleTireInputCreateDto dto) {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SUMMER);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "winter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentWinter(@RequestBody VehicleTireInputCreateDto dto) {
        return tiresRestAdapter.addEquipment(dto, RestTireType.WINTER);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "special", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSpecial(@RequestBody VehicleTireInputCreateDto dto) {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SPECIAL);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentAll(@RequestBody VehicleTireInputCreateDto dto) {
        return tiresRestAdapter.addEquipment(dto, RestTireType.ALL_SEASON);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto updateEquipment(@PathVariable UUID id, @RequestBody VehicleTireInputCreateDto dto)
            throws BadEquipmentTypeException, EquipmentNotFoundServiceException {
        return tiresRestAdapter.updateEquipment(id, dto);
    }
}

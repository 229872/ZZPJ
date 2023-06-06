package pl.zzpj.repository.rest.controllers;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.rest.adapters.VehicleTiresRestAdapter;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;

@RestController
@RequestMapping(path = "/equipment/tires")
@AllArgsConstructor
public class VehicleTiresRestController {

    private final VehicleTiresRestAdapter tiresRestAdapter;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleTireOutputDto> getAll() {
        return tiresRestAdapter.getAllEquipment();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto getEquipmentById(@PathVariable("id") UUID id)
        throws VehicleEquipmentServiceNotFoundException {
        return tiresRestAdapter.getEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "summer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSummer(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentServiceCreateException {
        return tiresRestAdapter.addEquipmentSummer(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "winter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentWinter(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentServiceCreateException {
        return tiresRestAdapter.addEquipmentWinter(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "special", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSpecial(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentServiceCreateException {
        return tiresRestAdapter.addEquipmentSpecial(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "all_season", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
        MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentAll(@RequestBody @Valid VehicleTireInputCreateDto dto)
        throws VehicleEquipmentServiceCreateException {
        return tiresRestAdapter.addEquipmentAllSeason(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto updateEquipment(@PathVariable UUID id, @RequestBody VehicleTireInputUpdateDto dto)
        throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        return tiresRestAdapter.updateEquipment(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto setArchiveStatusEquipment(@PathVariable UUID id, @PathVariable boolean status)
        throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        return tiresRestAdapter.setArchiveStatusEquipment(id, status);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void removeEquipment(@PathVariable UUID id) {
        tiresRestAdapter.removeEquipment(id); //fixme some serious logic in here?
    }
}

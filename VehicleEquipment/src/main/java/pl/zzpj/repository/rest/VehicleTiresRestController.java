package pl.zzpj.repository.rest;

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
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.rest.adapters.VehicleTiresRestAdapter;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;
import pl.zzpj.repository.rest.exceptions.BadTireTypeException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestCreateException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotFoundException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotSpecifiedException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestUpdateException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/equipment/tires")
@AllArgsConstructor
public class VehicleTiresRestController {

    private final VehicleTiresRestAdapter tiresRestAdapter;

    //TODO ROLES ALLOWED
    //TODO SWAGGER DOCUMENTATION
    //TODO TESTS BOTH REST AND SERVICE

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleTireOutputDto> getAll() {
        return tiresRestAdapter.getAllEquipment();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto getEquipmentById(@PathVariable("id") UUID id)
        throws VehicleEquipmentRestNotFoundException {
        return tiresRestAdapter.getEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "summer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSummer(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentRestCreateException, BadTireTypeException, VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SUMMER);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "winter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentWinter(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentRestCreateException, BadTireTypeException, VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.WINTER);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "special", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSpecial(@RequestBody VehicleTireInputCreateDto dto)
        throws VehicleEquipmentRestCreateException, BadTireTypeException, VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SPECIAL);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "all_season", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
        MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentAll(@RequestBody @Valid VehicleTireInputCreateDto dto)
        throws VehicleEquipmentRestCreateException, BadTireTypeException, VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.ALL_SEASON);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto updateEquipment(@PathVariable UUID id, @RequestBody VehicleTireInputUpdateDto dto)
        throws VehicleEquipmentRestNotFoundException, VehicleEquipmentRestUpdateException,
        VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.updateEquipment(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto setArchiveStatusEquipment(@PathVariable UUID id, @PathVariable boolean status)
        throws VehicleEquipmentRestUpdateException, VehicleEquipmentRestNotSpecifiedException,
        VehicleEquipmentRestNotFoundException {
        return tiresRestAdapter.setArchiveStatusEquipment(id, status);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void removeEquipment(@PathVariable UUID id) {
        tiresRestAdapter.removeEquipment(id); //fixme some serious logic in here?
    }
}

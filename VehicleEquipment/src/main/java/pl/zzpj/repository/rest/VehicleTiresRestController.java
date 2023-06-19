package pl.zzpj.repository.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@AllArgsConstructor
@RequestMapping(path = "/equipment/tires")
public class VehicleTiresRestController {

    private final VehicleTiresRestAdapter tiresRestAdapter;

    //TODO TESTS BOTH REST AND SERVICE

    //    @RolesAllowed({GUEST})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all vehicle tires")
    @ApiResponse(responseCode = "200", description = "Returned list of tires",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = VehicleTireOutputDto.class))})
    public List<VehicleTireOutputDto> getAll() {
        return tiresRestAdapter.getAllEquipment();
    }


    //    @RolesAllowed({GUEST})
    @Operation(summary = "Get vehicle tire by uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tire",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "404", description = "Tire not found",
                    content = @Content)})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto getEquipmentById(@Valid @PathVariable("id") UUID id)
            throws VehicleEquipmentRestNotFoundException {
        return tiresRestAdapter.getEquipmentById(id);
    }

    @Operation(summary = "Create summer type tire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Summer type tire successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "summer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSummer(@Valid @RequestBody VehicleTireInputCreateDto dto)
            throws VehicleEquipmentRestCreateException, BadTireTypeException,
            VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SUMMER);
    }

    @Operation(summary = "Create winter type tire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Winter type tire successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "winter", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentWinter(@Valid @RequestBody VehicleTireInputCreateDto dto)
            throws VehicleEquipmentRestCreateException, BadTireTypeException,
            VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.WINTER);
    }

    @Operation(summary = "Create special type tire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Special type tire successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "special", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentSpecial(@Valid @RequestBody VehicleTireInputCreateDto dto)
            throws VehicleEquipmentRestCreateException, BadTireTypeException,
            VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.SPECIAL);
    }

    @Operation(summary = "Create all season type tire")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "All season type tire successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "all_season", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto createEquipmentAll(@Valid @RequestBody VehicleTireInputCreateDto dto)
            throws VehicleEquipmentRestCreateException, BadTireTypeException,
            VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.addEquipment(dto, RestTireType.ALL_SEASON);
    }

    @Operation(summary = "Update tire by uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tire successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire", //todo fixme
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto updateEquipment(@Valid @PathVariable UUID id,
                                                @Valid @RequestBody VehicleTireInputUpdateDto dto)
            throws VehicleEquipmentRestNotFoundException, VehicleEquipmentRestUpdateException,
            VehicleEquipmentRestNotSpecifiedException {
        return tiresRestAdapter.updateEquipment(id, dto);
    }

    @Operation(summary = "Change archive status of a tire by uuid and boolean")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Archive status changed successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleTireOutputDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleTireOutputDto setArchiveStatusEquipment(@Valid @PathVariable UUID id, @PathVariable boolean status)
            throws VehicleEquipmentRestUpdateException, VehicleEquipmentRestNotSpecifiedException,
            VehicleEquipmentRestNotFoundException {
        return tiresRestAdapter.setArchiveStatusEquipment(id, status);
    }

    @Operation(summary = "Remove tire by uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tire successfully removed",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Incorrect input for creating tire",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Other error occurred",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void removeEquipment(@PathVariable UUID id) {
        tiresRestAdapter.removeEquipment(id);
    }
}

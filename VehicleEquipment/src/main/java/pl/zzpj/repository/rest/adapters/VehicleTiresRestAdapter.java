package pl.zzpj.repository.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandService;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryService;
import pl.zzpj.repository.rest.adapters.mappers.vehicleTire.VehicleTireFromDomainToDtoMapper;
import pl.zzpj.repository.rest.adapters.mappers.vehicleTire.VehicleTireFromInputDtoToDomainMapper;
import pl.zzpj.repository.rest.command.VehicleTiresCommandRest;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;
import pl.zzpj.repository.rest.exceptions.BadTireTypeException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestCreateException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotFoundException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotSpecifiedException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestUpdateException;
import pl.zzpj.repository.rest.query.VehicleTiresQueryRest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class VehicleTiresRestAdapter implements VehicleTiresCommandRest, VehicleTiresQueryRest {

    private final VehicleTireCommandService commandService;
    private final VehicleTireQueryService queryService;
    private final VehicleTireFromInputDtoToDomainMapper fromInputDtoMapper;
    private final VehicleTireFromDomainToDtoMapper fromDomainMapper;

    @Autowired
    public VehicleTiresRestAdapter(VehicleTireCommandService commandService,
                                   VehicleTireQueryService queryService,
                                   VehicleTireFromInputDtoToDomainMapper fromInputDtoMapper,
                                   VehicleTireFromDomainToDtoMapper fromDomainMapper) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.fromInputDtoMapper = fromInputDtoMapper;
        this.fromDomainMapper = fromDomainMapper;
    }


    @Override
    public List<VehicleTireOutputDto> getAllEquipment() {
        return queryService.getAllEquipment().stream()
            .map(fromDomainMapper::convertDomainModelToTireOutputDto).collect(Collectors.toList());
    }

    @Override
    public VehicleTireOutputDto getEquipmentById(UUID uuid) throws VehicleEquipmentRestNotFoundException {
        try {
            return fromDomainMapper.convertDomainModelToTireOutputDto(queryService.getEquipmentById(uuid));
        } catch (VehicleEquipmentServiceNotFoundException e) {
            throw new VehicleEquipmentRestNotFoundException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public VehicleTireOutputDto addEquipment(VehicleTireInputCreateDto dto, RestTireType type)
        throws BadTireTypeException, VehicleEquipmentRestCreateException,
        VehicleEquipmentRestNotSpecifiedException {
        try {

            return fromDomainMapper.convertDomainModelToTireOutputDto(commandService
                .addEquipment(fromInputDtoMapper.convertTireInputCreateDtoToDomainModel(dto, type)));
        } catch (VehicleEquipmentServiceCreateException e) {
            throw new VehicleEquipmentRestCreateException(e.getMessage(), e.getCause());
        } catch (IllegalArgumentException e) {
            throw new BadTireTypeException(e.getMessage(), e.getCause());
        } catch (Exception e) {
            throw new VehicleEquipmentRestNotSpecifiedException(e.getMessage(), e.getCause());
        }
    }


    @Override
    public VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputUpdateDto dto)
        throws VehicleEquipmentRestNotFoundException,
        VehicleEquipmentRestUpdateException, VehicleEquipmentRestNotSpecifiedException {
        try {
            return fromDomainMapper.convertDomainModelToTireOutputDto(commandService
                .updateEquipment(id, fromInputDtoMapper.convertTireInputUpdateDtoToDomainModel(dto)));
        } catch (VehicleEquipmentServiceNotFoundException e) {
            throw new VehicleEquipmentRestNotFoundException(e.getMessage(), e.getCause());
        } catch (VehicleEquipmentServiceUpdateException e) {
            throw new VehicleEquipmentRestUpdateException(e.getMessage(), e.getCause());
        } catch (Exception e) {
            throw new VehicleEquipmentRestNotSpecifiedException(e.getMessage(), e.getCause());
        }
    }

    public VehicleTireOutputDto setArchiveStatusEquipment(UUID id, boolean status)
        throws VehicleEquipmentRestNotFoundException, VehicleEquipmentRestUpdateException,
        VehicleEquipmentRestNotSpecifiedException {
        try {

            return fromDomainMapper.convertDomainModelToTireOutputDto(commandService
                .setArchiveStatus(id, status));
        } catch (VehicleEquipmentServiceNotFoundException e) {
            throw new VehicleEquipmentRestNotFoundException(e.getMessage(), e.getCause());
        } catch (VehicleEquipmentServiceUpdateException e) {
            throw new VehicleEquipmentRestUpdateException(e.getMessage(), e.getCause());
        } catch (Exception e) {
            throw new VehicleEquipmentRestNotSpecifiedException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void removeEquipment(UUID id) {
        commandService.removeEquipment(id);
    }
}

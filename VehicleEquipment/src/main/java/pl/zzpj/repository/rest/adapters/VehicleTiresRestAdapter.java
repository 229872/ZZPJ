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
    public VehicleTireOutputDto getEquipmentById(UUID uuid) throws VehicleEquipmentServiceNotFoundException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(queryService.getEquipmentById(uuid));
    }

    @Override
    public VehicleTireOutputDto addEquipment(VehicleTireInputCreateDto dto, RestTireType tireType) throws VehicleEquipmentServiceCreateException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                addEquipment(fromInputDtoMapper.convertTireInputCreateDtoToDomainModel(dto, tireType)));
    }

    @Override
    public VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputUpdateDto dto)
            throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                updateEquipment(id, fromInputDtoMapper.convertTireInputUpdateDtoToDomainModel(dto)));
    }

    public VehicleTireOutputDto setArchiveStatusEquipment(UUID id, boolean status) throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                setArchiveStatus(id, status));
    }

    @Override
    public void removeEquipment(UUID id) {
        commandService.removeEquipment(id);
    }


}

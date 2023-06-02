package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.util.UUID;

public interface VehicleTiresCommandRest {

    VehicleTireOutputDto addEquipment(VehicleTireInputCreateDto dto, RestTireType tireType);

    VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputCreateDto dto) throws EquipmentNotFoundServiceException, BadEquipmentTypeException;

    void removeEquipment(UUID id);

}

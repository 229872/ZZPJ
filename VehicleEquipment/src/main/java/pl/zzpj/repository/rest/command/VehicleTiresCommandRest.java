package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;

import java.util.UUID;

public interface VehicleTiresCommandRest {

    VehicleTireOutputDto addEquipment(VehicleTireInputDto dto);

    VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputDto dto) throws EquipmentNotFoundServiceException, BadEquipmentTypeException;

    void removeEquipment(UUID id);

}

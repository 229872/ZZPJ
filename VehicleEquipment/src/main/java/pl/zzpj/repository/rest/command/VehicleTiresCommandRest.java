package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentDataIntegrityViolationException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.util.UUID;

public interface VehicleTiresCommandRest {

    VehicleTireOutputDto addEquipment(VehicleTireInputCreateDto dto, RestTireType tireType) throws EquipmentDataIntegrityViolationException;

    VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputUpdateDto dto) throws EquipmentNotFoundException, BadEquipmentTypeException, EquipmentDataIntegrityViolationException;

    void removeEquipment(UUID id);

}

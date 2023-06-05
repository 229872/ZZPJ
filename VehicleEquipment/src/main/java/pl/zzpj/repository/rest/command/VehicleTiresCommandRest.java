package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;

import java.util.UUID;

public interface VehicleTiresCommandRest {

    VehicleTireOutputDto addEquipmentSummer(VehicleTireInputCreateDto dto) throws VehicleEquipmentServiceCreateException;
    VehicleTireOutputDto addEquipmentWinter(VehicleTireInputCreateDto dto) throws VehicleEquipmentServiceCreateException;
    VehicleTireOutputDto addEquipmentAllSeason(VehicleTireInputCreateDto dto) throws VehicleEquipmentServiceCreateException;
    VehicleTireOutputDto addEquipmentSpecial(VehicleTireInputCreateDto dto) throws VehicleEquipmentServiceCreateException;

    VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputUpdateDto dto) throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceCreateException, VehicleEquipmentServiceUpdateException;

    public VehicleTireOutputDto setArchiveStatusEquipment(UUID id, boolean status) throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException;

    void removeEquipment(UUID id);

}

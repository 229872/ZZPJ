package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;
import pl.zzpj.repository.rest.exceptions.BadTireTypeException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestCreateException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotFoundException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestNotSpecifiedException;
import pl.zzpj.repository.rest.exceptions.VehicleEquipmentRestUpdateException;

import java.util.UUID;

public interface VehicleTiresCommandRest {

    VehicleTireOutputDto addEquipment(VehicleTireInputCreateDto dto, RestTireType type)
        throws VehicleEquipmentServiceCreateException, BadTireTypeException,
        VehicleEquipmentRestCreateException, VehicleEquipmentRestNotSpecifiedException;

    VehicleTireOutputDto updateEquipment(UUID id, VehicleTireInputUpdateDto dto)
        throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceCreateException,
        VehicleEquipmentRestNotFoundException,
        VehicleEquipmentRestUpdateException, VehicleEquipmentRestNotSpecifiedException;

    public VehicleTireOutputDto setArchiveStatusEquipment(UUID id, boolean status)
        throws VehicleEquipmentRestNotFoundException, VehicleEquipmentRestUpdateException,
        VehicleEquipmentRestNotSpecifiedException;

    void removeEquipment(UUID id);
}

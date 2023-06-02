package pl.zzpj.repository.ports.command.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.UUID;


public interface VehicleTireCommandService {

    VehicleTire addEquipment(VehicleTire tire) throws VehicleEquipmentServiceCreateException;

    VehicleTire updateEquipment(UUID id, VehicleTire tire) throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException;

    void removeEquipment(UUID id);

    VehicleTire setArchiveStatus(UUID id, boolean status) throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException;
}

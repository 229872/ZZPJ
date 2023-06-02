package pl.zzpj.repository.ports.command.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentDataIntegrityViolationException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.UUID;


public interface VehicleTireCommandService {

    VehicleTire addEquipment(VehicleTire tire) throws EquipmentDataIntegrityViolationException; //todo throws

    VehicleTire updateEquipment(UUID id, VehicleTire tire) throws EquipmentNotFoundException, BadEquipmentTypeException, EquipmentDataIntegrityViolationException; //todo throws

    void removeEquipment(UUID id); //todo

}

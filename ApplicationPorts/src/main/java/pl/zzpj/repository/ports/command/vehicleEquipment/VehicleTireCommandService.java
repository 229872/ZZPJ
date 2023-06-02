package pl.zzpj.repository.ports.command.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.UUID;


public interface VehicleTireCommandService {

    VehicleTire addEquipment(VehicleTire tire); //todo throws

    VehicleTire updateEquipment(UUID id, VehicleTire tire) throws EquipmentNotFoundServiceException, BadEquipmentTypeException; //todo throws

    void removeEquipment(UUID id); //todo

}

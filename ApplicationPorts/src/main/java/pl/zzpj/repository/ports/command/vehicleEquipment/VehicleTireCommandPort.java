package pl.zzpj.repository.ports.command.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.UUID;


public interface VehicleTireCommandPort { //todo exceptions?

    VehicleTire add(VehicleTire tire);

    VehicleTire update(VehicleTire tire) throws EquipmentNotFoundServiceException;

    void remove(UUID id);
}

package pl.zzpj.repository.ports.command.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentDataIntegrityViolationException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.UUID;


public interface VehicleTireCommandPort { //todo exceptions?

    VehicleTire add(VehicleTire tire) throws EquipmentDataIntegrityViolationException;

    VehicleTire update(VehicleTire tire) throws EquipmentNotFoundException, EquipmentDataIntegrityViolationException;

    void remove(UUID id);
}

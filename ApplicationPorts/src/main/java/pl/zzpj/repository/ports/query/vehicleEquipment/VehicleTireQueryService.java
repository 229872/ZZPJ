package pl.zzpj.repository.ports.query.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

import java.util.List;
import java.util.UUID;

public interface VehicleTireQueryService {

    List<VehicleTire> getAllEquipment();

    VehicleTire getEquipmentById(UUID id) throws EquipmentNotFoundException; //todo throws

//    List<VehicleEquipment> getAllEquipmentByType()

}

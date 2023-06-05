package pl.lodz.p.edu.zzpj.api;

import pl.lodz.p.edu.zzpj.dto.RandomDto;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.BadEquipmentTireTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;

public interface RandomApi {
    void addRandomVehicleTire(RandomDto dto) throws VehicleEquipmentServiceCreateException, BadEquipmentTireTypeException;

}

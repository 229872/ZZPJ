package pl.zzpj.repository.rest.query;

import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;

import java.util.List;
import java.util.UUID;

public interface VehicleTiresQueryRest {

    List<VehicleTireOutputDto> getAllEquipment();

    VehicleTireOutputDto getEquipmentById(UUID id) throws VehicleEquipmentServiceNotFoundException;
}

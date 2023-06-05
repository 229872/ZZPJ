package pl.lodz.p.edu.zzpj.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.adapter.mapper.ExternalVehicleTireMapper;
import pl.lodz.p.edu.zzpj.api.RandomApi;
import pl.lodz.p.edu.zzpj.dto.RandomDto;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.BadEquipmentTireTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandService;

@Component
@AllArgsConstructor
public class VehicleEquipmentExternalClientAdapter implements RandomApi {

    private final VehicleTireCommandService commandService;
    private final ExternalVehicleTireMapper mapper;


    @Override
    public void addRandomVehicleTire(RandomDto dto) throws VehicleEquipmentServiceCreateException, BadEquipmentTireTypeException {
        commandService.addEquipmentNoType(mapper.convertTireInputCreateDtoToDomainModel(dto), 0); //fixme
    }
}

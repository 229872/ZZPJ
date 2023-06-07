package pl.zzpj.repository.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.rest.adapter.mapper.ExternalVehicleTireMapper;
import pl.zzpj.repository.rest.api.RandomVehicleTireApi;
import pl.zzpj.repository.rest.dto.RandomVehicleTireDto;
import pl.zzpj.repository.rest.exception.CreateUserExternalClientException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.BadEquipmentTireTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandService;

@Component
@AllArgsConstructor
public class VehicleEquipmentExternalClientAdapter implements RandomVehicleTireApi {

    private final VehicleTireCommandService commandService;
    private final ExternalVehicleTireMapper mapper;

    @Override
    public void addRandomVehicleTire(RandomVehicleTireDto dto, Integer type) {
        try {
            commandService.addEquipmentNoType(mapper.convertTireInputCreateDtoToDomainModel(dto));
        } catch (VehicleEquipmentServiceCreateException | BadEquipmentTireTypeException exception) {
            throw new CreateUserExternalClientException(exception.getMessage(), exception.getCause());
        }

    }
}

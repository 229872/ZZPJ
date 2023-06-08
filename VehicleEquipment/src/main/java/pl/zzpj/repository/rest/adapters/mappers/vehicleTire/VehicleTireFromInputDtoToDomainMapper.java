package pl.zzpj.repository.rest.adapters.mappers.vehicleTire;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.TireType;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputUpdateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

@Component
public class VehicleTireFromInputDtoToDomainMapper {

    public VehicleTire convertTireInputCreateDtoToDomainModel(VehicleTireInputCreateDto inputDto, RestTireType tireType) {
        return VehicleTire.fromApiBuilder()
                .name(inputDto.name())
                .description(inputDto.description())
                .cost(inputDto.cost())
                .size(inputDto.size())
                .maximumSpeed(inputDto.maximumSpeed())
                .maximumWeight(inputDto.maximumWeight())
                .type(TireType.valueOf(tireType.name())).build();
    }

    public VehicleTire convertTireInputUpdateDtoToDomainModel(VehicleTireInputUpdateDto updateDto) {
        return VehicleTire.fromApiBuilder()
                .name(updateDto.name())
                .description(updateDto.description())
                .cost(updateDto.cost())
                .maximumSpeed(updateDto.maximumSpeed())
                .maximumWeight(updateDto.maximumWeight()).build();
    }
}

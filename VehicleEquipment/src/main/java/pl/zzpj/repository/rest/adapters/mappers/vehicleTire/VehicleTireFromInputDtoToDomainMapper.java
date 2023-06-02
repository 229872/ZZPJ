package pl.zzpj.repository.rest.adapters.mappers.vehicleTire;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.TireType;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputCreateDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

@Component
public class VehicleTireFromInputDtoToDomainMapper {

    public VehicleTire convertTireInputCreateDtoToDomainModel(VehicleTireInputCreateDto inputDto, RestTireType tireType) {
        return VehicleTire.fromApiBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .type(TireType.valueOf(tireType.name())).build();
    }
}

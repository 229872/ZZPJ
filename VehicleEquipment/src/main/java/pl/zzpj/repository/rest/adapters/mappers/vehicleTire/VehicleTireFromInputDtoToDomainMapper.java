package pl.zzpj.repository.rest.adapters.mappers.vehicleTire;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.core.domain.model.vehicleModel.TireType;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Input.VehicleTireInputDto;

@Component
public class VehicleTireFromInputDtoToDomainMapper {

    public VehicleTire convertTireInputCreateDtoToDomainModel(VehicleTireInputDto inputDto) {
        return VehicleTire.fromApiBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .archive(inputDto.getArchive())
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .productionDate(inputDto.getProductionDate())
                .type(TireType.valueOf(inputDto.getType().name())).build();
    }
}

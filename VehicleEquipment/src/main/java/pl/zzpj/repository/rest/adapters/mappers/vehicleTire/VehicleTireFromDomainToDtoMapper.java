package pl.zzpj.repository.rest.adapters.mappers.vehicleTire;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.rest.dto.vehicleEquipment.Output.VehicleTireOutputDto;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

@Component
public class VehicleTireFromDomainToDtoMapper {

    public VehicleTireOutputDto convertDomainModelToTireOutputDto(VehicleTire vehicleTire) {
        return VehicleTireOutputDto.fromDomainBuilder()
                .uuid(vehicleTire.getEquipment().getSuperModel().getId())
                .name(vehicleTire.getEquipment().getName())
                .description(vehicleTire.getEquipment().getDescription())
                .cost(vehicleTire.getEquipment().getCost()) //Cost as another entity?
                .size(vehicleTire.getSize())
                .maximumSpeed(vehicleTire.getMaximumSpeed())
                .maximumWeight(vehicleTire.getMaximumWeight())
                .type(RestTireType.valueOf(vehicleTire.getType().name())).build();
    }
}



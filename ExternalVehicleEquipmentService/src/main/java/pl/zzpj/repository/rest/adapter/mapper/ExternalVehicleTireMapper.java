package pl.zzpj.repository.rest.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.rest.dto.RandomVehicleTireDto;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

@Component
@RequiredArgsConstructor
public class ExternalVehicleTireMapper {
    public VehicleTire convertTireInputCreateDtoToDomainModel(RandomVehicleTireDto inputDto) {
        return VehicleTire.fromApiBuilder()
                .name(inputDto.product_name())
                .description(inputDto.promo_code())
                .cost(inputDto.price())
                .size(inputDto.uid().toString())
                .maximumSpeed(Double.valueOf(inputDto.id()))
                .maximumWeight(Double.valueOf(inputDto.id()) / 2.0)
                .type(null).build();
    }
}

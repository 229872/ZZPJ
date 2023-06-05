package pl.lodz.p.edu.zzpj.adapter.mapper;

import pl.lodz.p.edu.zzpj.dto.RandomDto;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;

public class ExternalVehicleTireMapper {
    public VehicleTire convertTireInputCreateDtoToDomainModel(RandomDto inputDto) {
        return VehicleTire.fromApiBuilder()
                .name(inputDto.product_name())
                .description(inputDto.promoCode())
                .cost(inputDto.price())
                .size(inputDto.uid().toString())
                .maximumSpeed(Double.valueOf(inputDto.id()))
                .maximumWeight(Double.valueOf(inputDto.id()))
                .type(null).build();
    }
}

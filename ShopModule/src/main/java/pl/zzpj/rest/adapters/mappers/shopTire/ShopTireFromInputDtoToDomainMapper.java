package pl.zzpj.rest.adapters.mappers.shopTire;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.core.domain.model.shopModel.TireType;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;

@Component
public class ShopTireFromInputDtoToDomainMapper {

    public ShopTire convertTireInputCreateDtoToDomainModel(ShopTireInputDto inputDto) {
        return ShopTire.fromApiBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .productionDate(inputDto.getProductionDate())
                .type(TireType.valueOf(inputDto.getType().name())).build();
    }
}

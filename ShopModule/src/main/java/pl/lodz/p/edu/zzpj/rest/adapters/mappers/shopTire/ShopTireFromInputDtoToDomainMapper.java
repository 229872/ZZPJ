package pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopTire;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

public class ShopTireFromInputDtoToDomainMapper {

    public ShopTire convertTireInputDtoToDomainModel(ShopTireInputDto inputDto) {
        return ShopTire.toDomainBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .productionDate(inputDto.getProductionDate()).build();
    }
}

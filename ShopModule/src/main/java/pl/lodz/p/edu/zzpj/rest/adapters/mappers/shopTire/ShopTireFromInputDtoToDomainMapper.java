package pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopTire;

import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireCreateInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireUpdateInputDto;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

@Component
public class ShopTireFromInputDtoToDomainMapper { //FIXME acceptable only for now

    public ShopTire convertTireInputCreateDtoToDomainModel(ShopTireCreateInputDto inputDto) {
        return ShopTire.fromApiBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .productionDate(inputDto.getProductionDate()).build();
    }

    public ShopTire convertTireInputUpdateDtoToDomainModel(ShopTireUpdateInputDto inputDto) {
        return ShopTire.fromApiBuilder()
                .name(inputDto.getName())
                .description(inputDto.getDescription())
                .cost(inputDto.getCost()) //Cost as another entity?
                .size(inputDto.getSize())
                .maximumSpeed(inputDto.getMaximumSpeed())
                .maximumWeight(inputDto.getMaximumWeight())
                .productionDate(inputDto.getProductionDate()).build();
    }
}

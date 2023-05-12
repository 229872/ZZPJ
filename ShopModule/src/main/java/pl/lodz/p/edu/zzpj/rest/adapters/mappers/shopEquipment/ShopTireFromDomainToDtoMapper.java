package pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopEquipment;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

public class ShopTireFromDomainToDtoMapper {

    public ShopTireOutputDto convertDomainModelToTireOutputDto(ShopTire shopTire) { //change it a bit?
        return ShopTireOutputDto.builder()
            .uuid(shopTire.getUuid())
            .name(shopTire.getName())
            .description(shopTire.getDescription())
            .cost(shopTire.getCost()) //Cost as another entity?
            .size(shopTire.getSize())
            .maximumSpeed(shopTire.getMaximumSpeed())
            .maximumWeight(shopTire.getMaximumWeight())
            .productionDate(shopTire.getProductionDate()).build();
    }
}



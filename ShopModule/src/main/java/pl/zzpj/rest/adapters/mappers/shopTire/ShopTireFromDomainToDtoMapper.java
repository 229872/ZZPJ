package pl.zzpj.rest.adapters.mappers.shopTire;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

@Component
public class ShopTireFromDomainToDtoMapper {

    public ShopTireOutputDto convertDomainModelToTireOutputDto(ShopTire shopTire) { //change it a bit?
        return ShopTireOutputDto.builder()
                .uuid(shopTire.getId())
                .name(shopTire.getName())
                .description(shopTire.getDescription())
                .cost(shopTire.getCost()) //Cost as another entity?
                .size(shopTire.getSize())
                .maximumSpeed(shopTire.getMaximumSpeed())
                .maximumWeight(shopTire.getMaximumWeight())
                .productionDate(shopTire.getProductionDate()).build();
    }
}



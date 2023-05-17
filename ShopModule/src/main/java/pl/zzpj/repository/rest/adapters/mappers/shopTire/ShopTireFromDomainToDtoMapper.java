package pl.zzpj.repository.rest.adapters.mappers.shopTire;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.shopModel.ShopTire;
import pl.zzpj.repository.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.repository.rest.dto.shopEquipment.RestTireType;

@Component
public class ShopTireFromDomainToDtoMapper {

    public ShopTireOutputDto convertDomainModelToTireOutputDto(ShopTire shopTire) {
        return ShopTireOutputDto.fromDomainBuilder()
                .uuid(shopTire.getEquipment().getSuperModel().getId())
                .name(shopTire.getEquipment().getName())
                .description(shopTire.getEquipment().getDescription())
                .cost(shopTire.getEquipment().getCost()) //Cost as another entity?
                .size(shopTire.getSize())
                .maximumSpeed(shopTire.getMaximumSpeed())
                .maximumWeight(shopTire.getMaximumWeight())
                .productionDate(shopTire.getProductionDate())
                .type(RestTireType.valueOf(shopTire.getType().name())).build();
    }
}



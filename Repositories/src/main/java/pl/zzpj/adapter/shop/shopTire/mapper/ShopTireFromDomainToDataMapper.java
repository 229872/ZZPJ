package pl.zzpj.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopTireFromDomainToDataMapper {
    public ShopTireEnt convertDomainModelToDataRepository(ShopTire shopTire) {
        return ShopTireEnt.toDataBuilder()
                .id(shopTire.getId())
                .version(shopTire.getVersion())
                .name(shopTire.getName())
                .description(shopTire.getDescription())
                .cost(shopTire.getCost())
                .size(shopTire.getSize())
                .maximumSpeed(shopTire.getMaximumSpeed())
                .maximumWeight(shopTire.getMaximumWeight())
                .productionDate(shopTire.getProductionDate())
                .build();
    }
}

package pl.lodz.p.edu.zzpj.postgres.adapters.mappers.shopTire;

import pl.lodz.p.edu.zzpj.postgres.entities.shopEntities.ShopTireEnt;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

public class ShopTireFromDomainToDataMapper {
    public ShopTireEnt convertDomainModelToDataRepository(ShopTire shopTire) {
        return ShopTireEnt.toDataBuilder()
                .uuid(shopTire.getUuid())
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

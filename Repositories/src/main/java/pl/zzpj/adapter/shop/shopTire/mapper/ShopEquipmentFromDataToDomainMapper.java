package pl.zzpj.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
<<<<<<<< HEAD:Repositories/src/main/java/pl/zzpj/adapter/shop/shopTire/mapper/ShopTireFromDataToDomainMapper.java
import pl.zzpj.data.shop.ShopTireEnt;
========
import pl.zzpj.core.domain.model.shopModel.TireType;
import pl.zzpj.repository.data.shop.ShopTireEnt;
>>>>>>>> 687b08a3415d78b5eb6d95ecb5c5d1e1f8ad4efe:Repositories/src/main/java/pl/zzpj/adapter/shop/shopTire/mapper/ShopEquipmentFromDataToDomainMapper.java

@Component
@NoArgsConstructor
public class ShopEquipmentFromDataToDomainMapper {

    public ShopTire convertDataToDomainModel(ShopTireEnt tireEnt) {
        return ShopTire.fromDataBuilder()
                .uuid(tireEnt.getId())
                .version(tireEnt.getVersion())
                .name(tireEnt.getName())
                .description(tireEnt.getDescription())
                .archive(tireEnt.isArchive())
                .cost(tireEnt.getCost()) //Cost as another entity?
                .size(tireEnt.getSize())
                .maximumSpeed(tireEnt.getMaximumSpeed())
                .maximumWeight(tireEnt.getMaximumWeight())
                .productionDate(tireEnt.getProductionDate())
                .type(TireType.valueOf(tireEnt.getTypeEnt().name()))
                .build();
    }
}

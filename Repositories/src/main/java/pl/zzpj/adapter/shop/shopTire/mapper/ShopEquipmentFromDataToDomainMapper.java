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

        ShopTire returnTire = new ShopTire(tireEnt.getId(), tireEnt.getVersion(),
                tireEnt.getName(), tireEnt.isArchive(), tireEnt.getDescription(), tireEnt.getCost(), tireEnt.getSize(),
                tireEnt.getMaximumSpeed(), tireEnt.getMaximumWeight(), tireEnt.getProductionDate(),
                TireType.valueOf(tireEnt.getTypeEnt().name()));
        return returnTire;
    }
}

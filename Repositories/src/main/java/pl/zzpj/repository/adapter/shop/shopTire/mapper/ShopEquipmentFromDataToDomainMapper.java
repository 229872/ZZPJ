package pl.zzpj.repository.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.EquipmentType;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.repository.data.shop.ShopEquipmentEnt;
import pl.zzpj.repository.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopEquipmentFromDataToDomainMapper {

    public ShopEquipment convertDataToDomainModel(ShopEquipmentEnt equipment) {

        switch (EquipmentType.valueOf(equipment.getEquipmentType())) {
            case TIRE -> {
                return buildShopTire((ShopTireEnt) equipment);
            }
        }
        return null;
    }

    private ShopEquipment buildShopTire(ShopTireEnt tireEnt) {
        return ShopTire.fromDataBuilder()
                .uuid(tireEnt.getId())
                .version(tireEnt.getVersion())
                .name(tireEnt.getName())
                .description(tireEnt.getDescription())
                .cost(tireEnt.getCost()) //Cost as another entity?
                .size(tireEnt.getSize())
                .maximumSpeed(tireEnt.getMaximumSpeed())
                .maximumWeight(tireEnt.getMaximumWeight())
                .productionDate(tireEnt.getProductionDate())
                .build();
    }

}

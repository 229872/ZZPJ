package pl.zzpj.repository.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.repository.data.shop.ShopEquipmentEnt;
import pl.zzpj.repository.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopEquipmentFromDomainToDataMapper {
    public ShopEquipmentEnt convertDomainModelToDataRepository(ShopEquipment equipment) {

        switch (equipment.getType()) {
            case TIRE -> {
                return buildShopTireEnt((ShopTire) equipment);
            }
        }
        return null;

    }

    private ShopTireEnt buildShopTireEnt(ShopTire equipment) {
        return ShopTireEnt.toDataBuilder()
                .id(equipment.getId())
                .version(equipment.getVersion())
                .name(equipment.getName())
                .description(equipment.getDescription())
                .cost(equipment.getCost())
                .size(equipment.getSize())
                .maximumSpeed(equipment.getMaximumSpeed())
                .maximumWeight(equipment.getMaximumWeight())
                .productionDate(equipment.getProductionDate())
                .equipmentType(equipment.getType().name())
                .build();
    }
}

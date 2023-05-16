package pl.zzpj.repository.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.repository.data.shop.ShopEquipmentEnt;
import pl.zzpj.repository.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopEquipmentFromDomainToDataMapper {
    public ShopEquipmentEnt convertDomainModelToDataRepository(ShopTire tire) {
        return ShopTireEnt.toDataBuilder()
                .id(tire.getEquipment().getSuperModel().getId())
                .version(tire.getEquipment().getSuperModel().getVersion())
                .name(tire.getEquipment().getName())
                .description(tire.getEquipment().getDescription())
                .cost(tire.getEquipment().getCost())
                .size(tire.getSize())
                .maximumSpeed(tire.getMaximumSpeed())
                .maximumWeight(tire.getMaximumWeight())
                .productionDate(tire.getProductionDate())
                .equipmentType(tire.getType().name())
                .build();
    }
}

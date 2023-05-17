package pl.zzpj.repository.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.core.domain.model.shopModel.TireType;
import pl.zzpj.repository.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopEquipmentFromDataToDomainMapper {

    public ShopTire convertDataToDomainModel(ShopTireEnt tireEnt) {
        ShopTire returnTire = ShopTire.fromDataBuilder()
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
        return returnTire;
    }
}

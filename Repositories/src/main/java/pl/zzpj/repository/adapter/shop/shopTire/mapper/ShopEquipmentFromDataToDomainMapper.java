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

        ShopTire returnTire = new ShopTire(tireEnt.getId(), tireEnt.getVersion(),
                tireEnt.getName(), tireEnt.isArchive(), tireEnt.getDescription(), tireEnt.getCost(), tireEnt.getSize(),
                tireEnt.getMaximumSpeed(), tireEnt.getMaximumWeight(), tireEnt.getProductionDate(),
                TireType.valueOf(tireEnt.getTypeEnt().name()));
        return returnTire;
    }
}

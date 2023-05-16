package pl.zzpj.adapter.shop.shopTire.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.data.shop.ShopTireEnt;

@Component
@NoArgsConstructor
public class ShopTireFromDataToDomainMapper {
    public ShopTire convertTireEntToDomainModel(ShopTireEnt tireEnt) {
        return ShopTire.fromDataBuilder()
                .uuid(tireEnt.getId())
                .version(tireEnt.getVersion())
                .name(tireEnt.getName())
                .description(tireEnt.getDescription())
                .cost(tireEnt.getCost()) //Cost as another entity?
                .size(tireEnt.getSize())
                .maximumSpeed(tireEnt.getMaximumSpeed())
                .maximumWeight(tireEnt.getMaximumWeight())
                .productionDate(tireEnt.getProductionDate()).build();
    }

}

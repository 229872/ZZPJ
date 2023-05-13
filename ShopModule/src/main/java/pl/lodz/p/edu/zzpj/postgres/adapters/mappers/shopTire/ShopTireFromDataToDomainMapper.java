package pl.lodz.p.edu.zzpj.postgres.adapters.mappers.shopTire;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.postgres.entities.shopEntities.ShopTireEnt;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

@Component
@NoArgsConstructor
public class ShopTireFromDataToDomainMapper {
    public ShopTire convertTireEntToDomainModel(ShopTireEnt tireEnt) {
        return ShopTire.fromDataBuilder()
                .uuid(tireEnt.getUuid())
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

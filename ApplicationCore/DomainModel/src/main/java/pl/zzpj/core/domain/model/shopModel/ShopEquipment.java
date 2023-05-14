package pl.zzpj.core.domain.model.shopModel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.zzpj.core.domain.model.AbstractDataModel;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ShopEquipment extends AbstractDataModel {

    protected String name;

    protected String description;

    protected Double cost;

    protected Boolean archive;

    protected ShopEquipment(UUID uuid, long version, String name, String description, Double cost) {
        super(uuid, version);
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    protected ShopEquipment(String name, String description, Double cost) {
        super();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

}

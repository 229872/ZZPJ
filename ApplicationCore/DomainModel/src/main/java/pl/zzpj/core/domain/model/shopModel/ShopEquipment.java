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

    protected double cost;

    protected boolean archive;

    protected ShopEquipment(UUID uuid, String name, String description, double cost) {
        super(uuid);
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    protected ShopEquipment(String name, String description, double cost) {
        super();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

}

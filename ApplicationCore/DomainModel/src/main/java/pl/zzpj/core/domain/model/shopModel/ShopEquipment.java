package pl.zzpj.core.domain.model.shopModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.zzpj.core.domain.model.AbstractDataModel;

import java.util.UUID;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public abstract class ShopEquipment extends AbstractDataModel {

    protected String name;

    protected String description;

    protected float cost;

    protected ShopEquipment(UUID uuid, String name, String description, float cost) {
        super();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    protected ShopEquipment(String name, String description, float cost) {
        super();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

}

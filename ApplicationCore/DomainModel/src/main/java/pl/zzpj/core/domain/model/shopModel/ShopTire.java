package pl.zzpj.core.domain.model.shopModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShopTire extends ShopEquipment{

    private String size;

    private int width;

    private int diameter;

    private TireSeason season;


    public void update(ShopTire tire) {
        this.name = tire.getName();
        this.description = tire.getDescription();
        this.cost = tire.getCost();
        this.size = tire.getSize();
        this.width = tire.getWidth();
        this.diameter = tire.getDiameter();
        this.season = tire.getSeason();
    }
}

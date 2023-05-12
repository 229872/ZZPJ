package pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output;

import java.util.UUID;

public class ShopEquipmentOutputDto {

    protected UUID uuid;

    protected String name;

    protected String description;

    protected double cost;

    public ShopEquipmentOutputDto(UUID uuid, String name, String description, double cost) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}

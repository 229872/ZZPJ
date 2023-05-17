package pl.zzpj.rest.dto.shopEquipment.Output;

import java.util.UUID;

public class ShopEquipmentOutputDto {

    protected UUID uuid;

    protected String name;

    protected String description;

    protected Double cost;

    public ShopEquipmentOutputDto(UUID uuid, String name, String description, Double cost) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}

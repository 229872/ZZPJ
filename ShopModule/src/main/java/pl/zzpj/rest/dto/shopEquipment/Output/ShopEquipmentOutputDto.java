package pl.zzpj.rest.dto.shopEquipment.Output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@NoArgsConstructor
@Jacksonized
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

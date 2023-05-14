package pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input;

import lombok.Data;

@Data
public class ShopEquipmentUpdateInputDto {

    protected String name;

    protected String description;

    protected Double cost;
}

package pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ShopEquipmentInputDto {

    @NotBlank
    protected String name;

    @NotBlank
    protected String description;

    @NotNull
    @Positive
    protected Double cost;
}

package pl.zzpj.repository.rest.dto.shopEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopEquipmentInputDto {

    @NotBlank
    protected String name;

    @NotBlank
    protected String description;

    @NotNull
    @Positive
    protected Double cost;

    @NotNull
    protected Boolean archive;
}

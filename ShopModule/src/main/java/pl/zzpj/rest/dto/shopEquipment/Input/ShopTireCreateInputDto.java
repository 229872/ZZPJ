package pl.zzpj.rest.dto.shopEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopTireCreateInputDto extends ShopEquipmentInputDto {

    @NotBlank
    private String size;

    @NotNull
    @Positive
    private Long maximumSpeed;

    @NotNull
    @Positive
    private Long maximumWeight;

    @NotNull
    @DateTimeFormat
    private LocalDateTime productionDate;
}

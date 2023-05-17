package pl.zzpj.repository.rest.dto.shopEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.zzpj.repository.rest.dto.shopEquipment.RestTireType;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopTireInputDto extends ShopEquipmentInputDto {

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

    @NotNull
    private RestTireType type;

    @Builder
    public ShopTireInputDto(String name,
                            String description, Double cost, String size, Boolean archive,
                            Long maximumSpeed, Long maximumWeight, LocalDateTime productionDate, RestTireType type) {
        super(name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.type = type;
    }
}

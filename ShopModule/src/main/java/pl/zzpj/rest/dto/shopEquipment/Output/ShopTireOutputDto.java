package pl.zzpj.rest.dto.shopEquipment.Output;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShopTireOutputDto extends ShopEquipmentOutputDto {
    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    @Builder
    public ShopTireOutputDto(UUID uuid, String name,
                             String description, double cost, String size,
                             Long maximumSpeed, Long maximumWeight, LocalDateTime productionDate) {
        super(uuid, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
    }
}

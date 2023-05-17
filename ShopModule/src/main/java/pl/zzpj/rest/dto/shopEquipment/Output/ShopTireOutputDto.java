package pl.zzpj.rest.dto.shopEquipment.Output;

import lombok.Builder;
import pl.zzpj.rest.dto.shopEquipment.RestTireType;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShopTireOutputDto extends ShopEquipmentOutputDto {
    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    private RestTireType type;

    @Builder(builderMethodName = "fromDomainBuilder")
    public ShopTireOutputDto(UUID uuid, String name,
                             String description, Double cost, String size,
                             Long maximumSpeed, Long maximumWeight, LocalDateTime productionDate, RestTireType type) {
        super(uuid, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.type = type;
    }
}

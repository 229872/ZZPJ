package pl.zzpj.core.domain.model.shopModel;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ShopTire extends ShopEquipment {

    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    @Builder(builderMethodName = "toDomainBuilder")
    public ShopTire(String name, String description,
                    double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate) {
        super(name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
    }

    @Builder(builderMethodName = "fromDataBuilder")
    public ShopTire(UUID uuid, String name, String description,
                    double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate) {
        super(uuid, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
    }
}

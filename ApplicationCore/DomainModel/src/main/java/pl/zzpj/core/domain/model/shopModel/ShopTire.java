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

    @Builder(builderMethodName = "fromApiBuilder")
    public ShopTire(String name, String description,
                    Double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate) {
        super(name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
    }

    @Builder(builderMethodName = "fromDataBuilder")
    public ShopTire(UUID uuid, long version, String name, String description,
                    Double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate) {
        super(uuid, version, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
    }

    public void merge(ShopTire tire) {
        if (tire.getName() != null) this.name = tire.getName();
        if (tire.getDescription() != null) this.name = tire.getDescription();
        if (tire.size != null) this.size = tire.getSize();
        if (tire.maximumSpeed != null) this.maximumSpeed = tire.getMaximumSpeed();
        if (tire.maximumWeight != null) this.maximumWeight = tire.getMaximumWeight();
        if (tire.productionDate != null) this.productionDate = tire.getProductionDate();
    }
}

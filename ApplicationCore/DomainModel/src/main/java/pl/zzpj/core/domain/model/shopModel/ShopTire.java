package pl.zzpj.core.domain.model.shopModel;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ShopTire {

    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    private ShopEquipment equipment;

    private TireType type;


    @Builder(builderMethodName = "fromApiBuilder")
    public ShopTire(String name, String description,
                    Double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate, TireType type) {
        this.equipment = new ShopEquipment(name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.type = type;
    }

    @Builder(builderMethodName = "fromDataBuilder")
    public ShopTire(UUID uuid, long version, String name, String description,
                    Double cost, String size, Long maximumSpeed,
                    Long maximumWeight, LocalDateTime productionDate, TireType type) {
        this.equipment = new ShopEquipment(uuid, version, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.type = type;
    }

    public void merge(ShopTire tire) {
        this.equipment.merge(tire.getEquipment());
        if (!Objects.equals(tire.size, this.size)) this.size = tire.getSize();
        if (!Objects.equals(tire.maximumSpeed, this.maximumSpeed)) this.maximumSpeed = tire.getMaximumSpeed();
        if (!Objects.equals(tire.maximumWeight, this.maximumWeight)) this.maximumWeight = tire.getMaximumWeight();
        this.productionDate = tire.getProductionDate();
        if (tire.type != this.type) this.type = tire.getType();
    }
}

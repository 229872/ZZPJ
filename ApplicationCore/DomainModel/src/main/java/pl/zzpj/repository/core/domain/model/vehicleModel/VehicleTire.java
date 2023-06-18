package pl.zzpj.repository.core.domain.model.vehicleModel;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTire {

    private String size;

    private Double maximumSpeed;
    private Double maximumWeight;

    private VehicleEquipment equipment;

    private TireType type;


    @Builder(builderMethodName = "fromApiBuilder")
    public VehicleTire(String name, String description,
                       Double cost, String size, Double maximumSpeed,
                       Double maximumWeight, TireType type) {
        this.equipment = new VehicleEquipment(name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.type = type;
    }

    @Builder(builderMethodName = "fromDataBuilder")
    public VehicleTire(UUID uuid, long version, String name, boolean archive, String description,
                       Double cost, String size, Double maximumSpeed,
                       Double maximumWeight, TireType type) {
        this.equipment = VehicleEquipment.builder().uuid(uuid).version(version)
                .name(name).description(description).cost(cost).archive(archive).build();
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.type = type;
    }

    public void merge(VehicleTire tire) {
        this.equipment.merge(tire.getEquipment());
        if (!Objects.equals(tire.maximumSpeed, this.maximumSpeed)) this.maximumSpeed = tire.getMaximumSpeed();
        if (!Objects.equals(tire.maximumWeight, this.maximumWeight)) this.maximumWeight = tire.getMaximumWeight();
    }
}

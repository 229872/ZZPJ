package pl.zzpj.repository.core.domain.model.vehicleModel;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VehicleEquipment {

    private String name;

    private String description;

    private Double cost;

    private Boolean archive;

    private SuperDataModel superModel;

    @Builder
    public VehicleEquipment(UUID uuid, long version, String name, String description, Double cost, boolean archive) {
        this.superModel = SuperDataModel.builder().id(uuid).version(version).build();
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }

    // Create new vehicle, builder was not working?
    public VehicleEquipment(String name, String description, Double cost) {
        this.superModel = new SuperDataModel();
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = false;
    }

    public void merge(VehicleEquipment equipment) {
        if (!Objects.equals(equipment.getCost(), this.cost)) this.setCost(equipment.getCost());
        if (!Objects.equals(equipment.getName(), this.name)) this.setName(equipment.getName());
        if (!Objects.equals(equipment.getDescription(), this.description))
            this.setDescription(equipment.getDescription());
    }
}

package pl.zzpj.core.domain.model.shopModel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopEquipment {

    private String name;

    private String description;

    private Double cost;

    private Boolean archive;

    private SuperDataModel superModel;

    public ShopEquipment(UUID uuid, long version, String name, String description, Double cost, boolean archive) {
        this.superModel = new SuperDataModel(uuid, version);
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }

    public ShopEquipment(String name, String description, Double cost, Boolean archive) {
        this.superModel = new SuperDataModel();
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }

    public void merge(ShopEquipment equipment) {
        if (!Objects.equals(equipment.getCost(), this.cost)) this.setCost(equipment.getCost());
        if (!Objects.equals(equipment.getName(), this.name)) this.setName(equipment.getName());
        if (!Objects.equals(equipment.getDescription(), this.description)) this.setName(equipment.getDescription());
        if (equipment.getArchive() != this.archive) this.setArchive(equipment.getArchive());
    }
}

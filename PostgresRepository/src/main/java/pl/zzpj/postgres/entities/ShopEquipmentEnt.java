package pl.zzpj.postgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class ShopEquipmentEnt extends AbstractEntity {

    @Column
    protected String name;

    @Column
    protected String description;

    @Column
    protected double cost;

    public ShopEquipmentEnt(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}

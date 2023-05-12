package pl.lodz.p.edu.zzpj.postgres.entities.shopEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.edu.zzpj.postgres.entities.AbstractEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ShopEquipmentEnt extends AbstractEntity {

    @Column
    protected String name;

    @Column
    protected String description;

    @Column
    protected double cost;

//    public ShopEquipmentEnt(UUID uuid, String name, String description, double cost) {
//        super(uuid);
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//    }

    public ShopEquipmentEnt(String name, String description, double cost) {
        super();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}

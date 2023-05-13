package pl.lodz.p.edu.zzpj.postgres.entities.shopEntities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.lodz.p.edu.zzpj.postgres.entities.AbstractEntity;

import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ShopEquipmentEnt extends AbstractEntity {

    @Column
    @NotBlank
    protected String name;

    @Column
    @NotBlank
    protected String description;

    @Column
    @Positive
    protected double cost;

    protected ShopEquipmentEnt(UUID uuid, long version, String name, String description, double cost) {
        super(uuid, version);
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
}

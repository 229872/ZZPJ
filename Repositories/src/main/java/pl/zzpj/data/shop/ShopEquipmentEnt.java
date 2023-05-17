package pl.zzpj.repository.data.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import pl.zzpj.repository.data.AbstractEntity;

import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ShopEquipmentEnt extends AbstractEntity { //TODO

    @Column
    @NotBlank
    protected String name;

    @Column
    @NotBlank
    protected String description;

    @Column
    @Positive
    protected double cost;

    @Column
    protected boolean archive;

    public ShopEquipmentEnt(UUID id, long version, String name,
                            String description, double cost, boolean archive) {
        super(id, version);
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }
}

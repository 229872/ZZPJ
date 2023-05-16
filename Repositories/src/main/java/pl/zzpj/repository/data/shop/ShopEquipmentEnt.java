package pl.zzpj.repository.data.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.zzpj.repository.data.AbstractEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@MappedSuperclass
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
    protected String equipmentType;
}

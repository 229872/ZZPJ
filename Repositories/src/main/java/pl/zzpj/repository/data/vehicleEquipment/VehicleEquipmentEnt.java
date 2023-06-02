package pl.zzpj.repository.data.vehicleEquipment;

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
public abstract class VehicleEquipmentEnt extends AbstractEntity { //TODO

    @Column(nullable = false)
    @NotBlank
    protected String name;

    @Column(nullable = false)
    @NotBlank
    protected String description;

    @Column(nullable = false)
    @Positive
    protected double cost;

    @Column(nullable = false)
    protected boolean archive;

    public VehicleEquipmentEnt(UUID id, long version, String name,
                               String description, double cost, boolean archive) {
        super(id, version);
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }
}

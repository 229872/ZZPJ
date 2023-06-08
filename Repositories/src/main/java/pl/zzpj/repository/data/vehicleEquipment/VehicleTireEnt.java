package pl.zzpj.repository.data.vehicleEquipment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@Table(name = "VehicleTire")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "VehicleEquipmentEntId")
public class VehicleTireEnt extends VehicleEquipmentEnt {

    @Column(nullable = false, updatable = false)
    @NotBlank
    private String size;

    @Column(nullable = false)
    @Positive
    @NotNull
    private Double maximumSpeed;

    @Positive
    @NotNull
    @Column(nullable = false)
    private Double maximumWeight;

    @NotNull
    @Column(nullable = false, updatable = false)
    private TireTypeEnt typeEnt;

    public VehicleTireEnt(UUID id, Long version, String name, String description,
                          Double cost, boolean archive, String size,
                          Double maximumSpeed, Double maximumWeight, TireTypeEnt type) {
        super(id, version, name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.typeEnt = TireTypeEnt.valueOf(type.name());
    }
}

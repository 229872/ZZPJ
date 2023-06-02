package pl.zzpj.repository.data.vehicleEquipment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "Shop_Tire")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "ShopEquipmentEntId")
public class VehicleTireEnt extends VehicleEquipmentEnt {

    @Column(nullable = false)
    @NotBlank
    private String size;

    @Column(nullable = false)
    @Positive
    private Double maximumSpeed;

    @Positive
    @Column(nullable = false)
    private Double maximumWeight;

    private TireTypeEnt typeEnt;

    public VehicleTireEnt(UUID id, Long version, @NotBlank String name, @NotBlank String description,
                          @Positive Double cost, boolean archive, @NotBlank String size,
                          @Positive Double maximumSpeed, @Positive Double maximumWeight, TireTypeEnt type) {
        super(id, version, name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.typeEnt = TireTypeEnt.valueOf(type.name());
    }
}

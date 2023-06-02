package pl.zzpj.repository.data.vehicleEquipment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Column
    @NotBlank
    private String size;

    @Column
    @Positive
    private Double maximumSpeed;

    @Column
    @Positive
    private Double maximumWeight;


    @Column
    @NotNull
    private TireTypeEnt typeEnt;

    @Builder(builderMethodName = "toDataBuilder")
    public VehicleTireEnt(UUID id, Long version, @NotBlank String name, @NotBlank String description,
                          @Positive Double cost, boolean archive, String size,
                          Double maximumSpeed, Double maximumWeight, TireTypeEnt typeEnt) {
        super(id, version, name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.typeEnt = typeEnt;
    }
}

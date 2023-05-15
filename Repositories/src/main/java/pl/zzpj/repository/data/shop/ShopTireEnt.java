package pl.zzpj.repository.data.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "Shop_Tire")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "ShopEquipmentEntId")
public class ShopTireEnt extends ShopEquipmentEnt {

    @Column
    @NotBlank
    private String size;

    @Column
    @Positive
    private Long maximumSpeed;

    @Column
    @Positive
    private Long maximumWeight;

    @Column
    @DateTimeFormat
    @NotNull
    private LocalDateTime productionDate; //todo date mapper?

    @Builder(builderMethodName = "toDataBuilder")
    public ShopTireEnt(UUID id, long version, String name, String description,
                       double cost, String size, Long maximumSpeed,
                       Long maximumWeight, LocalDateTime productionDate, String equipmentType) {
        super(id, version, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.equipmentType = equipmentType;
    }
}

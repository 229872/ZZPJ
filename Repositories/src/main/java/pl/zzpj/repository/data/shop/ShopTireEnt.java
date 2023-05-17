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
    private LocalDateTime productionDate;

    @Column
    @NotNull
    private TireTypeEnt typeEnt;

    @Builder(builderMethodName = "toDataBuilder")
    public ShopTireEnt(UUID id, Long version, @NotBlank String name, @NotBlank String description,
                       @Positive double cost, boolean archive, String size,
                       Long maximumSpeed, Long maximumWeight, LocalDateTime productionDate, TireTypeEnt typeEnt) {
        super(id, version, name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.typeEnt = typeEnt;
    }
}

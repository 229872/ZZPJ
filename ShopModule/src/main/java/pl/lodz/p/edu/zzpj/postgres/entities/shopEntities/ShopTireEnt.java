package pl.lodz.p.edu.zzpj.postgres.entities.shopEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "ShopEquipmentEntId")
public class ShopTireEnt extends ShopEquipmentEnt {

    @Column
    private String size;

    @Column
    private Long maximumSpeed;

    @Column
    private Long maximumWeight;

    @Column
    private LocalDateTime productionDate;

}

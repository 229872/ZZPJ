package pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.TireSeason;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopTireInputDto extends ShopEquipmentInputDto {
    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    private TireSeason season;
}

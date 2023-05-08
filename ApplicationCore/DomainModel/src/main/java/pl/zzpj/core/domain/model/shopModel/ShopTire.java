package pl.zzpj.core.domain.model.shopModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopTire extends ShopEquipment{

    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    private LocalDateTime productionDate;

    private TireSeason season;

}

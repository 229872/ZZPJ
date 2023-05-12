package pl.lodz.p.edu.zzpj.rest.query;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;

import java.util.List;
import java.util.UUID;

public interface ShopTiresQueryRest extends ShopEquipmentQueryRest<ShopTireOutputDto> {

    List<ShopTireOutputDto> getAllEquipment();

    ShopTireOutputDto getEquipmentById(UUID uuid) throws EquipmentNotFoundServiceException;
}

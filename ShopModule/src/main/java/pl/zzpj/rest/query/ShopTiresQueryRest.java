package pl.zzpj.rest.query;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

public interface ShopTiresQueryRest {

    List<ShopTireOutputDto> getAllEquipment();

    ShopTireOutputDto getEquipmentById(UUID id) throws EquipmentNotFoundServiceException;
}

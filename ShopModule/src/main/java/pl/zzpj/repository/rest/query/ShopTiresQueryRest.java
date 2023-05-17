package pl.zzpj.repository.rest.query;

import pl.zzpj.repository.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

public interface ShopTiresQueryRest {

    List<ShopTireOutputDto> getAllEquipment();

    ShopTireOutputDto getEquipmentById(UUID id) throws EquipmentNotFoundServiceException;
}

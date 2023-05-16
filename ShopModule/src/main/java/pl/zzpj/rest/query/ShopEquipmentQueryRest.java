package pl.zzpj.rest.query;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryRest<T extends ShopEquipmentOutputDto> {
    List<T> getAllEquipment();

    T getEquipmentById(UUID uuid) throws EquipmentNotFoundServiceException;
}

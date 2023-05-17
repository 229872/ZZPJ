package pl.zzpj.repository.rest.command;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.repository.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.UUID;

public interface ShopTiresCommandRest {

    ShopTireOutputDto addEquipment(ShopTireInputDto dto);

    ShopTireOutputDto updateEquipment(UUID id, ShopTireInputDto dto) throws EquipmentNotFoundServiceException, BadEquipmentTypeException;

    void removeEquipment(UUID id);

}

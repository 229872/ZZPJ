package pl.zzpj.rest.command;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireCreateInputDto;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireUpdateInputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.UUID;

public interface ShopTiresCommandRest extends ShopEquipmentCommandRest<ShopTireCreateInputDto, ShopTireOutputDto> {

    //Fixme Think about it
    ShopTireOutputDto addEquipment(ShopTireCreateInputDto dto);

    ShopTireOutputDto updateEquipment(UUID id, ShopTireUpdateInputDto dto) throws EquipmentNotFoundServiceException;

    void removeEquipment(UUID id);

}

package pl.lodz.p.edu.zzpj.rest.command;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireCreateInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireUpdateInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;

import java.util.UUID;

public interface ShopTiresCommandRest extends ShopEquipmentCommandRest<ShopTireCreateInputDto, ShopTireOutputDto> {

    //Fixme Think about it
    ShopTireOutputDto addEquipment(ShopTireCreateInputDto dto);

    ShopTireOutputDto updateEquipment(UUID id, ShopTireUpdateInputDto dto) throws EquipmentNotFoundServiceException;

    void removeEquipment(UUID id);

}

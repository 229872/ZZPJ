package pl.lodz.p.edu.zzpj.rest.command;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.UUID;

public interface ShopTiresCommandRest extends ShopEquipmentCommandRest<ShopTireInputDto, ShopTireOutputDto> {

    //Fixme Think about it
    ShopTireOutputDto addEquipment(ShopTireInputDto dto);

    ShopTireOutputDto updateEquipment(UUID id, ShopTireInputDto dto);

    void removeEquipment(UUID id);

}

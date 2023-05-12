package pl.lodz.p.edu.zzpj.rest.command;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;

import java.util.UUID;

public interface ShopEquipmentCommandRest {

    //Fixme Think about it
    ShopEquipmentOutputDto addEquipment(ShopEquipmentInputDto dto);

    ShopEquipmentOutputDto updateEquipment(UUID id, ShopEquipmentInputDto dto);

    void removeEquipment(UUID id);

}

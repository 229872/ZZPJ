package pl.zzpj.rest.command;

import pl.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;

import java.util.UUID;

public interface ShopEquipmentCommandRest<T extends ShopEquipmentInputDto, U extends ShopEquipmentOutputDto> {
    U addEquipment(T dto);

//    U updateEquipment(UUID id, T dto) throws EquipmentNotFoundServiceException;

    void removeEquipment(UUID id);
}

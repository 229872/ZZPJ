package pl.lodz.p.edu.zzpj.rest.command;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;

import java.util.UUID;

public interface ShopEquipmentCommandRest<T extends ShopEquipmentInputDto, U extends ShopEquipmentOutputDto> {
    U addEquipment(T dto);

    U updateEquipment(UUID id, T dto) throws EquipmentNotFoundServiceException;

    void removeEquipment(UUID id);
}

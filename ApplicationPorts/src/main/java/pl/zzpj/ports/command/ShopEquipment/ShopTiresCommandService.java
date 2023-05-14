package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.UUID;


public interface ShopTiresCommandService extends ShopEquipmentCommandService<ShopTire> {

    ShopTire addEquipment(ShopTire equipment); //todo throws

    ShopTire updateEquipment(UUID id, ShopTire equipment) throws EquipmentNotFoundServiceException; //todo throws

    void removeEquipment(UUID id); //todo

}

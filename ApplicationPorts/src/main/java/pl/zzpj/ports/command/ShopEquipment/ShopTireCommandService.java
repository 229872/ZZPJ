package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.UUID;


public interface ShopTireCommandService {

    ShopTire addEquipment(ShopTire tire); //todo throws

    ShopTire updateEquipment(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException, BadEquipmentTypeException; //todo throws

    void removeEquipment(UUID id); //todo

}

package pl.zzpj.repository.ports.command.ShopEquipment;

import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.shopModel.ShopTire;

import java.util.UUID;


public interface ShopTireCommandService {

    ShopTire addEquipment(ShopTire tire); //todo throws

    ShopTire updateEquipment(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException, BadEquipmentTypeException; //todo throws

    void removeEquipment(UUID id); //todo

}

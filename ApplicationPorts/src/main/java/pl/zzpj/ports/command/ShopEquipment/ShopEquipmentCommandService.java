package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;


public interface ShopEquipmentCommandService {

    ShopEquipment addEquipment(ShopEquipment equipment); //todo throws

    ShopEquipment updateEquipment(UUID id, ShopEquipment equipment) throws EquipmentNotFoundServiceException, BadEquipmentTypeException; //todo throws

    void removeEquipment(UUID id); //todo

}

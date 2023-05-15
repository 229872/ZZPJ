package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;


public interface ShopEquipmentCommandPort { //todo exceptions?

    ShopEquipment add(ShopEquipment tire);

    ShopEquipment update(ShopEquipment tire) throws EquipmentNotFoundServiceException;

    void remove(UUID id);
}

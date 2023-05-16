package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.UUID;


public interface ShopTireCommandPort { //todo exceptions?

    ShopTire add(ShopTire tire);

    ShopTire update(ShopTire tire) throws EquipmentNotFoundServiceException;

    void remove(UUID id);
}

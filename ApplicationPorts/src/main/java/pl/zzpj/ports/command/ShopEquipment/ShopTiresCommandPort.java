package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.UUID;

public interface ShopTiresCommandPort extends ShopEquipmentCommandPort<ShopTire> { //todo exceptions?

    ShopTire add(ShopTire tire);

    ShopTire update(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException;

    void remove(UUID id);
}

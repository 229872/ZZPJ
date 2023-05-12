package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;

public interface ShopEquipmentCommandPort<T extends ShopEquipment>{

    T add(T obj);

    T update(UUID id, T tire) throws EquipmentNotFoundServiceException;

    void remove(UUID o);
}

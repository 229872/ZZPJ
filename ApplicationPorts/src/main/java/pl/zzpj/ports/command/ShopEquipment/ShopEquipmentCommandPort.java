package pl.zzpj.ports.command.ShopEquipment;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;

public interface ShopEquipmentCommandPort { //todo exceptions?

    ShopEquipment add(ShopEquipment equipment);

    ShopEquipment update(UUID id, ShopEquipment equipment) throws EquipmentNotFoundServiceException;

    void remove(ShopEquipment id);
}

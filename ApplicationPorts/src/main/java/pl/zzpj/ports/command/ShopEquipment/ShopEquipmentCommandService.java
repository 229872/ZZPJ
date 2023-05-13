package pl.zzpj.ports.command.ShopEquipment;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;

@Component
public interface ShopEquipmentCommandService<T extends ShopEquipment> {
    T addEquipment(T o); //todo throws

    T updateEquipment(UUID id, T o) throws EquipmentNotFoundServiceException; //todo throws

    void removeEquipment(UUID id); //todo
}

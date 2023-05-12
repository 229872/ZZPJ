package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryService<T extends ShopEquipment> {

    List<T> getAllEquipment();

    T getEquipmentById(UUID id) throws EquipmentNotFoundServiceException; //todo throws
}

package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShopEquipmentQueryPort<T extends ShopEquipment> {

    public List<T> getAllEquipment();

    public T getById(UUID id) throws EquipmentNotFoundServiceException;
}

package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryPort<T extends ShopEquipment> {

    public List<T> getAllTires();

    public T getTireById(UUID id) throws EquipmentNotFoundServiceException;
}

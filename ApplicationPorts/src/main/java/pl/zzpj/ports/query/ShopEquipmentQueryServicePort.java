package pl.zzpj.ports.query;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryServicePort {

    public List<ShopEquipment> getAll();


    public ShopEquipment get(UUID id) throws EquipmentNotFoundServiceException;
}

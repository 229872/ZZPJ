package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;


public interface ShopEquipmentQueryPort {

    public List<ShopEquipment> getAllEquipment();

    public ShopEquipment getEquipmentById(UUID id) throws EquipmentNotFoundServiceException;

    //todo some more?
}

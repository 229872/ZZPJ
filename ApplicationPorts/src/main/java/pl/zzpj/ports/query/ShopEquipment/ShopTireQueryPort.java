package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.UUID;


public interface ShopTireQueryPort {

    public List<ShopTire> getAllEquipment();

    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException;

    //todo some more?
}

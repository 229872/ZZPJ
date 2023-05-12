package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShopTiresQueryPort extends ShopEquipmentQueryPort<ShopTire>  {

    public List<ShopTire> getAllEquipment();

    public ShopTire getById(UUID id) throws EquipmentNotFoundServiceException;

    //todo some more?
}

package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.UUID;

public interface ShopTiresQueryService extends ShopEquipmentQueryService<ShopTire> {

    List<ShopTire> getAllEquipment();

    ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException; //todo throws

//    List<ShopEquipment> getAllEquipmentByType()

}

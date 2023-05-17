package pl.zzpj.repository.ports.query.ShopEquipment;

import pl.zzpj.repository.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.UUID;

public interface ShopTireQueryService {

    List<ShopTire> getAllEquipment();

    ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException; //todo throws

//    List<ShopEquipment> getAllEquipmentByType()

}

package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryService {

    List<ShopEquipment> getAllEquipment();

    ShopEquipment getEquipmentById(UUID id) throws EquipmentNotFoundServiceException; //todo throws

//    List<ShopEquipment> getAllEquipmentByType()

}

package pl.zzpj.ports.query.ShopEquipment;

import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryService {

    List<ShopEquipment> getAllEquipment();

    ShopEquipment getEquipmentById(UUID id); //todo throws

//    List<ShopEquipment> getAllEquipmentByType()

    //TODO get all tires? Get tires by type?
}

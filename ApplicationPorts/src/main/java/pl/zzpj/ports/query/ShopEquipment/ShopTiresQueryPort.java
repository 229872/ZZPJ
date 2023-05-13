package pl.zzpj.ports.query.ShopEquipment;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;

import java.util.List;
import java.util.UUID;

@Component
public interface ShopTiresQueryPort extends ShopEquipmentQueryPort<ShopTire> {

    public List<ShopTire> getAllTires();

    public ShopTire getTireById(UUID id) throws EquipmentNotFoundServiceException;

    //todo some more?
}

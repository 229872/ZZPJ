package pl.zzpj.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.ports.command.ShopEquipmentCommandServicePort;
import pl.zzpj.ports.query.ShopEquipmentQueryServicePort;

import java.util.List;
import java.util.UUID;

@ApplicationScope
@Service
public class ShopEquipmentService implements ShopEquipmentCommandServicePort, ShopEquipmentQueryServicePort { //TODO


    public ShopEquipment add(ShopEquipment equipment) {
        return null;
    }


    public ShopEquipment update(UUID id, ShopEquipment equipment) throws EquipmentNotFoundServiceException {
        return null;
    }

    @Override
    public void remove(ShopEquipment id) {

    }


    @Override
    public List<ShopEquipment> getAll() {
        return null;
    }

    @Override
    public ShopEquipment get(UUID id) throws EquipmentNotFoundServiceException {
        return null;
    }
}

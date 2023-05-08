package pl.zzpj.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScope
@Service
public class ShopEquipmentService implements ShopEquipmentCommandService, ShopEquipmentQueryService {
    @Override
    public ShopEquipment addEquipment(ShopEquipment equipment) {
        return null;
    }

    @Override
    public ShopEquipment updateEquipment(UUID id, ShopEquipment equipment) {
        return null;
    }

    @Override
    public void removeEquipment(UUID id) {

    }

    @Override
    public List<ShopEquipment> getAllEquipment() {
        return null;
    }

    @Override
    public ShopEquipment getEquipmentById(UUID id) {
        return null;
    }


    //TODO



}

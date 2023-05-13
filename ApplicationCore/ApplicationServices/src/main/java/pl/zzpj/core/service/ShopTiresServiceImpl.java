package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryService;

import java.util.List;
import java.util.UUID;

@ApplicationScope
@Service
public class ShopTiresServiceImpl implements ShopTiresCommandService, ShopTiresQueryService {

    private final ShopTiresCommandPort commandPort;

    private final ShopTiresQueryPort queryPort;

    @Autowired
    public ShopTiresServiceImpl(ShopTiresCommandPort commandPort, ShopTiresQueryPort queryPort) {
        this.commandPort = commandPort;
        this.queryPort = queryPort;
    }

    @Override
    public ShopTire addEquipment(ShopTire tire) {
        return commandPort.add(tire);
    }

    @Override
    public ShopTire updateEquipment(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException {
        return commandPort.update(tire);
    }

    @Override
    public void removeEquipment(UUID id) { //else throws?
        commandPort.remove(id);
    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return queryPort.getAllEquipment();
    }

    @Override
    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return queryPort.getEquipmentById(id);
    }


    //TODO


}

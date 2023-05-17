package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTireCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopTireCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTireQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTireQueryService;

import java.util.List;
import java.util.UUID;

@Service
public class ShopTireServiceImpl implements ShopTireCommandService, ShopTireQueryService {

    private ShopTireCommandPort commandPort;

    private ShopTireQueryPort queryPort;

    @Autowired
    public ShopTireServiceImpl(ShopTireCommandPort commandPort, ShopTireQueryPort queryPort) {
        this.commandPort = commandPort;
        this.queryPort = queryPort;
    }

    @Override
    public ShopTire addEquipment(ShopTire tire) {
        ShopTire returnTire = commandPort.add(tire);
        return returnTire;
    }

    @Override
    public ShopTire updateEquipment(UUID id, ShopTire tire) throws
            EquipmentNotFoundServiceException {
        ShopTire existingTire = queryPort.getEquipmentById(id);
        existingTire.merge(tire);
        return commandPort.update(existingTire);
    }

    @Override
    public void removeEquipment(UUID id) {
        commandPort.remove(id);
    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return queryPort.getAllEquipment(); //FIXME do more types like get by equipment type or whatever
    }

    @Override
    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return queryPort.getEquipmentById(id);
    }
}

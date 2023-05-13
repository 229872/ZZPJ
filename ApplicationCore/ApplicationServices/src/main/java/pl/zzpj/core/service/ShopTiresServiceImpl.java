package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryService;

import java.util.List;
import java.util.UUID;

@Service
public class ShopTiresServiceImpl implements ShopTiresCommandService, ShopTiresQueryService {

    private ShopTiresCommandPort commandPort;

    private ShopTiresQueryPort queryPort;

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
        ShopTire existingTire = queryPort.getTireById(id);
        existingTire.merge(tire);
        return commandPort.update(existingTire);
    }

    @Override
    public void removeEquipment(UUID id) { //else throws?
        commandPort.remove(id);
    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return queryPort.getAllTires();
    }

    @Override
    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return queryPort.getTireById(id);
    }

    //TODO
}

package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandPort;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryPort;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryService;

import java.util.List;
import java.util.UUID;

@Service
public class ShopEquipmentServiceImpl implements ShopEquipmentCommandService, ShopEquipmentQueryService {

    private ShopEquipmentCommandPort commandPort;

    private ShopEquipmentQueryPort queryPort;

    @Autowired
    public ShopEquipmentServiceImpl(ShopEquipmentCommandPort commandPort, ShopEquipmentQueryPort queryPort) {
        this.commandPort = commandPort;
        this.queryPort = queryPort;
    }


    @Override
    public ShopEquipment addEquipment(ShopEquipment equipment) {
        return commandPort.add(equipment);
    }

    @Override
    public ShopEquipment updateEquipment(UUID id, ShopEquipment equipment) throws
            EquipmentNotFoundServiceException, BadEquipmentTypeException {
        ShopEquipment existingEquipment = queryPort.getEquipmentById(id);
        existingEquipment = mergeEquipment(existingEquipment, equipment);
        return commandPort.update(existingEquipment);
    }

    @Override
    public void removeEquipment(UUID id) {
        commandPort.remove(id);
    }

    @Override
    public List<ShopEquipment> getAllEquipment() {
        return queryPort.getAllEquipment(); //FIXME do more types like get by equipment type or whatever
    }

    @Override
    public ShopEquipment getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return queryPort.getEquipmentById(id);
    }

    private ShopEquipment mergeEquipment(ShopEquipment equipment, ShopEquipment existingEquipment)
            throws BadEquipmentTypeException { //Maybe some kind of application logic exception?

        if (equipment.getType() != existingEquipment.getType()) {
            throw new BadEquipmentTypeException();
        }

        switch (existingEquipment.getType()) {
            case TIRE -> ((ShopTire) existingEquipment).merge((ShopTire) equipment);
        }
        return null;

    }
}

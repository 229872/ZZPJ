package pl.zzpj.repository.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandPort;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandService;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryPort;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryService;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleTireServiceImpl implements VehicleTireCommandService, VehicleTireQueryService {

    private final VehicleTireCommandPort commandPort;

    private final VehicleTireQueryPort queryPort;

    @Autowired
    public VehicleTireServiceImpl(VehicleTireCommandPort commandPort, VehicleTireQueryPort queryPort) {
        this.commandPort = commandPort;
        this.queryPort = queryPort;
    }

    @Override
    public VehicleTire addEquipment(VehicleTire tire) {
        return commandPort.add(tire);
    }

    @Override
    public VehicleTire updateEquipment(UUID id, VehicleTire tire) throws
            EquipmentNotFoundServiceException {
        VehicleTire existingTire = queryPort.getEquipmentById(id);
        existingTire.merge(tire);
        return commandPort.update(existingTire);
    }

    @Override
    public void removeEquipment(UUID id) {
        commandPort.remove(id);
    }

    @Override
    public List<VehicleTire> getAllEquipment() {
        return queryPort.getAllEquipment(); //FIXME do more types like get by equipment type or whatever
    }

    @Override
    public VehicleTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return queryPort.getEquipmentById(id);
    }
}

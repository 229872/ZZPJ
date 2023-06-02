package pl.zzpj.repository.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentDataIntegrityViolationException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundException;
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
    public VehicleTire addEquipment(VehicleTire tire) throws EquipmentDataIntegrityViolationException {
        return commandPort.add(tire);
    }

    @Override
    public VehicleTire updateEquipment(UUID id, VehicleTire tire) throws
            EquipmentNotFoundException, EquipmentDataIntegrityViolationException {
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
        return queryPort.getAllEquipment();
    }

    @Override
    public VehicleTire getEquipmentById(UUID id) throws EquipmentNotFoundException {
        return queryPort.getEquipmentById(id);
    }
}

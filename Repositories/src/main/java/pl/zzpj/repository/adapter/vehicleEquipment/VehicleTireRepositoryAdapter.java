package pl.zzpj.repository.adapter.vehicleEquipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.adapter.vehicleEquipment.mapper.VehicleTireFromDataToDomainMapper;
import pl.zzpj.repository.adapter.vehicleEquipment.mapper.VehicleTireFromDomainToDataMapper;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandPort;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryPort;
import pl.zzpj.repository.api.VehicleEquipmentRepository;
import pl.zzpj.repository.data.vehicleEquipment.VehicleTireEnt;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleTireRepositoryAdapter implements VehicleTireCommandPort, VehicleTireQueryPort {

    private VehicleEquipmentRepository repository;
    private VehicleTireFromDataToDomainMapper fromDataMapper;
    private VehicleTireFromDomainToDataMapper fromDomainMapper;

    @Autowired
    public VehicleTireRepositoryAdapter(VehicleEquipmentRepository repository,
                                        VehicleTireFromDataToDomainMapper fromDataMapper,
                                        VehicleTireFromDomainToDataMapper fromDomainMapper) {
        this.repository = repository;
        this.fromDataMapper = fromDataMapper;
        this.fromDomainMapper = fromDomainMapper;
    }

    @Override
    public VehicleTire add(VehicleTire tire) {
        VehicleTireEnt returnEnt = (VehicleTireEnt) repository.save(fromDomainMapper.convertDomainModelToDataRepository(tire));
        VehicleTire returnDomainTire = fromDataMapper.convertDataToDomainModel(returnEnt);
        return returnDomainTire;
    }

    @Override
    public VehicleTire update(VehicleTire tire) throws EquipmentNotFoundServiceException {
        return fromDataMapper.convertDataToDomainModel((VehicleTireEnt) repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public void remove(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<VehicleTire> getAllEquipment() {
        return repository.findAll().stream().map(x -> (VehicleTireEnt) x)
                .map(fromDataMapper::convertDataToDomainModel).collect(Collectors.toList());
    }

    @Override
    public VehicleTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return fromDataMapper.convertDataToDomainModel(
                (VehicleTireEnt) repository.findById(id).orElseThrow(EquipmentNotFoundServiceException::new));
    }
}

package pl.zzpj.repository.adapter.vehicleEquipment;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.adapter.vehicleEquipment.mapper.VehicleTireFromDataToDomainMapper;
import pl.zzpj.repository.adapter.vehicleEquipment.mapper.VehicleTireFromDomainToDataMapper;
import pl.zzpj.repository.api.VehicleEquipmentRepository;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.data.vehicleEquipment.VehicleTireEnt;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandPort;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryPort;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VehicleTireRepositoryAdapter implements VehicleTireCommandPort, VehicleTireQueryPort {

    private final VehicleEquipmentRepository repository;
    private final VehicleTireFromDataToDomainMapper fromDataMapper;
    private final VehicleTireFromDomainToDataMapper fromDomainMapper;


    @Override
    public VehicleTire add(VehicleTire tire) throws VehicleEquipmentServiceCreateException {
        try {
            VehicleTireEnt returnEnt = (VehicleTireEnt)
                repository.saveAndFlush(fromDomainMapper.convertDomainModelToDataRepository(tire));
            return fromDataMapper.convertDataToDomainModel(returnEnt);
        } catch (ConstraintViolationException | DataIntegrityViolationException | NullPointerException e) {
            throw new VehicleEquipmentServiceCreateException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public VehicleTire update(VehicleTire tire) throws VehicleEquipmentServiceUpdateException,
        VehicleEquipmentServiceNotFoundException {
        try {
            return fromDataMapper.convertDataToDomainModel((VehicleTireEnt) repository
                .saveAndFlush(fromDomainMapper.convertDomainModelToDataRepository(tire)));
        } catch (EntityNotFoundException e) {
            throw new VehicleEquipmentServiceNotFoundException(e.getMessage(), e.getCause());
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new VehicleEquipmentServiceUpdateException(e.getMessage(), e.getCause());
        }
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
    public VehicleTire getEquipmentById(UUID id) throws VehicleEquipmentServiceNotFoundException {
        return fromDataMapper.convertDataToDomainModel((VehicleTireEnt)
            repository.findById(id).orElseThrow(VehicleEquipmentServiceNotFoundException::new));
    }
}

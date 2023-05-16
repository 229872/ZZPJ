package pl.zzpj.core.service;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.ports.command.rent.RentVehiclesCommandPort;
import pl.zzpj.ports.command.rent.RentVehiclesCommandService;
import pl.zzpj.ports.query.rent.RentVehiclesQueryPort;
import pl.zzpj.ports.query.rent.RentVehiclesQueryService;

import java.util.List;
import java.util.UUID;

public class RentVehicleServiceImpl implements RentVehiclesCommandService, RentVehiclesQueryService {

    private RentVehiclesCommandPort vehiclesCommandPort;

    private RentVehiclesQueryPort vehiclesQueryPort;




    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    @Override
    public Vehicle getById(UUID id) {
        return null;
    }

    @Override
    public List<Vehicle> getAllAvailable() {
        return null;
    }

    @Override
    public Vehicle addVehicle(Vehicle o) {
        return null;
    }

    @Override
    public Vehicle updateVehicle(UUID id, Vehicle o) throws EquipmentNotFoundServiceException {
        return null;
    }

    @Override
    public void removeVehicle(UUID id) {

    }
}

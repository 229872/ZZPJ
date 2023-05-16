package pl.zzpj.adapter.rentVehicles;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.ports.command.rent.RentVehiclesCommandPort;
import pl.zzpj.ports.query.rent.RentVehiclesQueryPort;

import java.util.List;
import java.util.UUID;

public class RentVehiclesAdapter implements RentVehiclesCommandPort, RentVehiclesQueryPort {
    @Override
    public Vehicle add(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle remove(UUID id) {
        return null;
    }

    @Override
    public Vehicle getById(UUID id) {
        return null;
    }

    @Override
    public Vehicle getByMake(String make) {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    @Override
    public List<Vehicle> getAllAvailable() {
        return null;
    }

    @Override
    public List<Vehicle> getAllByType(String type) {
        return null;
    }
}

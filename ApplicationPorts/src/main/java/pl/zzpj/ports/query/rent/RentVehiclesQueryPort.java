package pl.zzpj.ports.query.rent;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.List;
import java.util.UUID;

public interface RentVehiclesQueryPort {
    Vehicle getById(UUID id);
    Vehicle getByMake(String make);
    List<Vehicle> getAll();
    List<Vehicle> getAllAvailable();
    List<Vehicle> getAllByType(String type);

}

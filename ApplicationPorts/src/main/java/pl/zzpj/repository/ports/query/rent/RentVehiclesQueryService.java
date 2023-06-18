package pl.zzpj.repository.ports.query.rent;

import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.List;
import java.util.UUID;

public interface RentVehiclesQueryService {
    Vehicle findById(UUID id);
    List<Vehicle> findAllByMake(String make);
    List<Vehicle> findAll();
    List<Vehicle> findAllAvailable();
    List<Vehicle> findAllByRating(String rating);
}

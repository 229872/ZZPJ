package pl.zzpj.ports.query.rent;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.List;
import java.util.UUID;

@Component
public interface RentVehiclesQueryPort {
    Vehicle getById(UUID id);
    List<Vehicle> getAllByMake(String make);
    List<Vehicle> getAll();
    List<Vehicle> getAllAvailable();
    List<Vehicle> getAllByType(String type);

}

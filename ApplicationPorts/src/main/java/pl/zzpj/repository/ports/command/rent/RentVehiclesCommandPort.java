package pl.zzpj.repository.ports.command.rent;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.UUID;

@Component
public interface RentVehiclesCommandPort {
    Vehicle add(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void remove (UUID id);
}

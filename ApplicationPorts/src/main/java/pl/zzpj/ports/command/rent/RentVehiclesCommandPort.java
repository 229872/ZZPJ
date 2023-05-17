package pl.zzpj.ports.command.rent;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.UUID;

@Component
public interface RentVehiclesCommandPort {
    Vehicle add(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void remove (UUID id);
}

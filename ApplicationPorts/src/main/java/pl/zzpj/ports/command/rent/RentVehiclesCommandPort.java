package pl.zzpj.ports.command.rent;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.UUID;

public interface RentVehiclesCommandPort {
    Vehicle add(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    Vehicle remove (UUID id);
}

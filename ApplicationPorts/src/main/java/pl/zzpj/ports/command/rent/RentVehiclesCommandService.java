package pl.zzpj.ports.command.rent;

import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;

import java.util.UUID;

public interface RentVehiclesCommandService {
    Vehicle addVehicle(Vehicle o);

    Vehicle updateVehicle(UUID id, Vehicle o);

    void switchAvailability(UUID id);

    void removeVehicle(UUID id);
}

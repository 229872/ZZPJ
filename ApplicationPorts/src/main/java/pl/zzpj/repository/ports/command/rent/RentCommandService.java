package pl.zzpj.repository.ports.command.rent;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface RentCommandService {
    Rent createRent(UUID userId, UUID vehicleId, LocalDateTime startDate, LocalDateTime endDate);
    Rent cancelRent(UUID id);
    Rent issueVehicle(UUID id);
    Rent returnVehicle(UUID id);
    Rent returnDamagedVehicle(UUID id); // może jakiś opis uszkodzeń i wycena?
    Rent returnMissingVehicle(UUID id); // nazwa dziwna, ale wiadomo o co chodzi
    void updateRentsNotIssued(); // dla scheduled taska
}

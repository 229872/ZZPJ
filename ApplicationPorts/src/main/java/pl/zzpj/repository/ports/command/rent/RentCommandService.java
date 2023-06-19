package pl.zzpj.repository.ports.command.rent;

import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface RentCommandService {
    Rent createRent(UUID userId, UUID vehicleId, LocalDateTime startDate, LocalDateTime endDate) throws RentInvalidDatePeriodException, UserServiceNotFoundException;
    Rent cancelRent(UUID id) throws RentNotFoundException, RentNotCancellableException;
    Rent issueVehicle(UUID id) throws RentNotFoundException, RentCannotIssueVehicleException;
    Rent returnVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException;
    Rent returnDamagedVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException; // może jakiś opis uszkodzeń i wycena?
    Rent returnMissingVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException; // nazwa dziwna, ale wiadomo o co chodzi
    void updateRentsNotIssued(); // dla scheduled taska
}

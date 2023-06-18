package pl.zzpj.repository.ports.query.rent;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface RentQueryService {
    Rent findRent(UUID rentId);
    List<Rent> findRentsByUser(UUID userId);
    List<Rent> findFutureRentsByVehicle(UUID vehicleId);
    List<Rent> findRentsByStatus(RentStatus status);
    List<Rent> findRentsToIssue(Period timeToDeclared);
    List<Rent> findRentsToReturn(Period timeToDeclared);
    List<Rent> findAllRents();
    boolean isVehicleAvailable(UUID vehicleId, LocalDateTime start, LocalDateTime end); // czy tu czy w vehicle service?
    boolean isCancellable(Rent rent);
    BigDecimal calculatePrice(UUID vehicleId, UUID userId, LocalDateTime start, LocalDateTime end);
}

package pl.zzpj.repository.ports.query.rent;

import pl.zzpj.repository.core.domain.exception.rent.RentNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RentQueryService {
    Rent findRent(UUID rentId) throws RentNotFoundException;
    List<Rent> findRentsByUser(UUID userId);
    List<Rent> findAllRentsByVehicle(UUID vehicleId);
    List<Rent> findFutureRentsByVehicle(UUID vehicleId);
    List<Rent> findRentsByStatus(RentStatus status);
    List<Rent> findRentsToIssue(LocalDateTime endTime);
    List<Rent> findRentsToReturn(LocalDateTime endTime);
    List<Rent> findAllRents();
    boolean isVehicleAvailable(UUID vehicleId, LocalDateTime start, LocalDateTime end); // czy tu czy w vehicle service?
    boolean isCancellable(Rent rent);
    BigDecimal calculatePrice(UUID vehicleId, UUID userId, LocalDateTime start, LocalDateTime end) throws UserServiceNotFoundException;
}

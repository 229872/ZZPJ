package pl.zzpj.ports.query.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.Person;
import pl.zzpj.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface RentQueryService {
    Rent findRent(UUID rentId);
    List<Rent> findRentsByUser(User user);
    List<Rent> findFutureRentsByVehicle(String vehicle);
    List<Rent> findRentsByStatus(RentStatus status);
    List<Rent> findRentsToIssue(Period timeToDeclared);
    List<Rent> findRentsToReturn(Period timeToDeclared);
    List<Rent> findAllRents();
    boolean isVehicleAvailable(String vehicle, LocalDateTime start, LocalDateTime end); // czy tu czy w vehicle service?
    boolean isCancellable(Rent rent);
    BigDecimal calculatePrice(String vehicle, User user, LocalDateTime start, LocalDateTime end); // can be static?
}

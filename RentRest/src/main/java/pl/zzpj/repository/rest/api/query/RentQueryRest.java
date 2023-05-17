package pl.zzpj.repository.rest.api.query;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface RentQueryRest {
    Rent findRent(UUID rentId);
    List<Rent> findRentsByUser(User user);
    List<Rent> findFutureRentsByVehicle(String vehicle);
    List<Rent> findRentsByStatus(RentStatus status);
    List<Rent> findRentsToIssue(Period timeToDeclared);
    List<Rent> findRentsToReturn(Period timeToDeclared);
    List<Rent> findAllRents();
    BigDecimal calculatePrice(String vehicle, User user, LocalDateTime start, LocalDateTime end); // can be static?

}

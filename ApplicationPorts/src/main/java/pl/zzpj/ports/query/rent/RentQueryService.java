package pl.zzpj.ports.query.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.Person;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface RentQueryService {
    Rent findRent(UUID rentId);
    List<Rent> findUserRents(UUID userId);
    List<Rent> findRentsByStatus(RentStatus status);
    List<Rent> findRentsToIssue(Period timeToDeclared);
    List<Rent> findRentsToReturn(Period timeToDeclared);
    List<Rent> findAllRents();
    boolean isVehicleAvailable(String vehicle, LocalDateTime start, LocalDateTime end); // czy tu czy w vehicle service?
    BigDecimal calculatePrice(String vehicle, Person person, LocalDateTime start, LocalDateTime end); // can be static?
}

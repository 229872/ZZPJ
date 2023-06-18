package pl.zzpj.repository.rest.api.query;

import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.rest.dto.RentDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

public interface RentQueryRest {
    RentDto findRent(UUID rentId);
    List<RentDto> findRentsByUser(UUID userId);
    List<RentDto> findFutureRentsByVehicle(UUID vehicleId);
    List<RentDto> findRentsByStatus(RentStatus status);
    List<RentDto> findRentsToIssue(Period timeToDeclared);
    List<RentDto> findRentsToReturn(Period timeToDeclared);
    List<RentDto> findAllRents();
    BigDecimal calculatePrice(UUID vehicleId, UUID userId, LocalDateTime start, LocalDateTime end); // can be static?

}

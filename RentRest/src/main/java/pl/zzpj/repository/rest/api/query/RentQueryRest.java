package pl.zzpj.repository.rest.api.query;

import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.rest.dto.PriceDto;
import pl.zzpj.repository.rest.dto.RentDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RentQueryRest {
    RentDto findRent(UUID rentId);
    List<RentDto> findRentsByUser(UUID userId);
    List<RentDto> findAllRentsByVehicle(UUID vehicleId);
    List<RentDto> findFutureRentsByVehicle(UUID vehicleId);
    List<RentDto> findRentsByStatus(RentStatus status);
    List<RentDto> findRentsToIssue(LocalDateTime endTime);
    List<RentDto> findRentsToReturn(LocalDateTime endTime);
    List<RentDto> findAllRents();
    PriceDto calculatePrice(UUID vehicleId,
                            UUID userId,
                            LocalDateTime start,
                            LocalDateTime end);
}

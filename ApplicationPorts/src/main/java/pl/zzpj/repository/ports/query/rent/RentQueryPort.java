package pl.zzpj.repository.ports.query.rent;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RentQueryPort {
    Rent getRent(UUID rentId);
    List<Rent> getRentsByStatus(RentStatus status);
    List<Rent> getRentsByStatuses(List<RentStatus> statuses);
    List<Rent> getRentsByUserId(UUID userId);
    List<Rent> getRentsByVehicleId(UUID vehicleId);
    List<Rent> getRentsByVehicleIdAndDatesBetween(UUID vehicleID,
                                                  LocalDateTime startDate,
                                                  LocalDateTime endDate);
    List<Rent> getRentsByStatusAndDeclaredDatesBetween(RentStatus status,
                                                    LocalDateTime declaredStartDate,
                                                    LocalDateTime declaredEndDate);
    List<Rent> getAllRents();

}

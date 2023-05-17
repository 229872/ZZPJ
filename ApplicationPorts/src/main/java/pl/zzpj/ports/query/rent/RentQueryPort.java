package pl.zzpj.ports.query.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RentQueryPort {
    Rent getRent(UUID rentId);
    List<Rent> getRentsByStatus(RentStatus status);
    List<Rent> getRentsByStatuses(List<RentStatus> statuses);
    List<Rent> getRentsByUser(User user);
    List<Rent> getRentsByVehicle(String vehicle);
    List<Rent> getRentsByStatusAndDeclaredStartDate(RentStatus status, LocalDateTime declaredStartDate);
    List<Rent> getAllRents();

}

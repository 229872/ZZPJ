package pl.zzpj.repository.rest.api.command;

import pl.zzpj.repository.rest.dto.RentDto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface RentCommandRest {
    RentDto createRent(UUID userId, UUID vehicleId,
                       LocalDateTime declaredStartDate,
                       LocalDateTime declaredEndDate);
    RentDto issueVehicle(UUID id);
    RentDto returnVehicle(UUID id);
    RentDto returnDamagedVehicle(UUID id);
    RentDto returnMissingVehicle(UUID id);

}

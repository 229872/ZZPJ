package pl.zzpj.repository.rest.api.command;

import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.rest.dto.RentDto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface RentCommandRest {
    RentDto createRent(UUID userId, UUID vehicleId,
                       LocalDateTime declaredStartDate,
                       LocalDateTime declaredEndDate) throws RentInvalidDatePeriodException, UserServiceNotFoundException;
    RentDto cancelRent(UUID id) throws RentNotCancellableException, RentNotFoundException;
    RentDto issueVehicle(UUID id) throws RentCannotIssueVehicleException, RentNotFoundException;
    RentDto returnVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException;
    RentDto returnDamagedVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException;
    RentDto returnMissingVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException;

}

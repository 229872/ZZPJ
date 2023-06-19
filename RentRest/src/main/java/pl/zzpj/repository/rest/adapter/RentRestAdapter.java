package pl.zzpj.repository.rest.adapter;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.ports.command.rent.RentCommandService;
import pl.zzpj.repository.ports.query.rent.RentQueryService;
import pl.zzpj.repository.rest.adapter.mapper.RentDomainToDtoMapper;
import pl.zzpj.repository.rest.api.command.RentCommandRest;
import pl.zzpj.repository.rest.api.query.RentQueryRest;
import pl.zzpj.repository.rest.dto.PriceDto;
import pl.zzpj.repository.rest.dto.RentDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Log
public class RentRestAdapter implements RentQueryRest, RentCommandRest {

    private final RentCommandService commandService;
    private final RentQueryService queryService;

    private final RentDomainToDtoMapper rentMapper;

    @Override
    public RentDto createRent(
            UUID userId, UUID vehicleId,
            LocalDateTime declaredStartDate,
            LocalDateTime declaredEndDate
    ) throws RentInvalidDatePeriodException, UserServiceNotFoundException {
        return rentMapper.map(commandService.createRent(
                userId, vehicleId, declaredStartDate, declaredEndDate));
    }

    @Override
    public RentDto issueVehicle(UUID id) throws RentCannotIssueVehicleException, RentNotFoundException {
        return rentMapper.map(commandService.issueVehicle(id));
    }

    @Override
    public RentDto cancelRent(UUID id) throws RentNotCancellableException, RentNotFoundException {
        return rentMapper.map(commandService.cancelRent(id));
    }

    @Override
    public RentDto returnVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        return rentMapper.map(commandService.returnVehicle(id));
    }

    @Override
    public RentDto returnDamagedVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        return rentMapper.map(commandService.returnDamagedVehicle(id));
    }

    @Override
    public RentDto returnMissingVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        return rentMapper.map(commandService.returnMissingVehicle(id));
    }

    @Override
    public RentDto findRent(UUID rentId) throws RentNotFoundException {
        return rentMapper.map(queryService.findRent(rentId));
    }

    @Override
    public List<RentDto> findRentsByUser(UUID userId) {
        return queryService.findRentsByUser(userId).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findAllRentsByVehicle(UUID vehicleId) {
        return queryService.findAllRentsByVehicle(vehicleId).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findFutureRentsByVehicle(UUID vehicleId) {
        return queryService.findFutureRentsByVehicle(vehicleId).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findRentsByStatus(RentStatus status) {
        return queryService.findRentsByStatus(status).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findRentsToIssue(LocalDateTime endTime) {
        return queryService.findRentsToIssue(endTime).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findRentsToReturn(LocalDateTime endTime) {
        return queryService.findRentsToReturn(endTime).stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findAllRents() {
        return queryService.findAllRents().stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public PriceDto calculatePrice(UUID vehicleId,
                                   UUID userId,
                                   LocalDateTime start,
                                   LocalDateTime end) throws UserServiceNotFoundException {
        return new PriceDto(queryService
                .calculatePrice(vehicleId, userId, start, end));
    }
}

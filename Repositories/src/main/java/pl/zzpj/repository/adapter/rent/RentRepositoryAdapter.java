package pl.zzpj.repository.adapter.rent;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDomainToData;
import pl.zzpj.repository.adapter.rent.mapper.RentFromDataToDomain;
import pl.zzpj.repository.adapter.rent.mapper.RentFromDomainToData;
import pl.zzpj.repository.adapter.user.mapper.AccountMapper;
import pl.zzpj.repository.api.RentRepository;
import pl.zzpj.repository.core.domain.exception.rent.RentNotFoundException;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.data.rent.RentEnt;
import pl.zzpj.repository.ports.command.rent.RentCommandPort;
import pl.zzpj.repository.ports.query.rent.RentQueryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RentRepositoryAdapter implements RentCommandPort, RentQueryPort {

    private RentFromDomainToData rentFromDomainToData;
    private RentFromDataToDomain rentFromDataToDomain;
    private RentRepository rentRepository;

    @Override
    public Rent upsert(Rent rent) {
        RentEnt rentEnt = rentRepository.save(rentFromDomainToData.map(rent));
        return rentFromDataToDomain.map(rentEnt);
    }

    @Override
    public Rent getRent(UUID rentId) throws RentNotFoundException {
        return rentRepository.findById(rentId)
                .map(rentFromDataToDomain::map)
                .orElseThrow(() -> new RentNotFoundException("Rent not found"));
    }

    @Override
    public List<Rent> getRentsByStatus(RentStatus status) {
        return rentRepository.findByStatus(status).stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getRentsByStatuses(List<RentStatus> statuses) {
        return rentRepository.findByStatusIn(statuses).stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getRentsByUserId(UUID userId) {
        return rentRepository.findByUserId(userId)
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getRentsByVehicleId(UUID vehicleId) {
        return rentRepository.findByVehicleId(vehicleId)
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getFutureRentsByVehicleId(UUID vehicleId) {
        return rentRepository.findByVehicleIdFromFuture(vehicleId,
                        LocalDateTime.now(),List.of(RentStatus.CREATED,
                                RentStatus.ISSUED, RentStatus.NOT_ISSUED))
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getRentsByVehicleIdAndDatesBetween(
            UUID vehicleId,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {
        return rentRepository
                .findByVehicleIdAndDeclaredStartDateAfterAndDeclaredEndDateBefore(
                        vehicleId, startDate, endDate)
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getRentsByStatusAndDeclaredDatesBetween(RentStatus status,
                                                              LocalDateTime declaredStartDate,
                                                              LocalDateTime declaredEndDate) {
        return rentRepository.findRentsByStatusAndDeclaredDateBetween(status,
                        declaredStartDate, declaredEndDate)
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> getAllRents() {
        return rentRepository.findAll()
                .stream()
                .map(rentFromDataToDomain::map)
                .collect(Collectors.toList());
    }
}

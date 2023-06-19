package pl.zzpj.repository.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.ports.command.rent.RentCommandPort;
import pl.zzpj.repository.ports.command.rent.RentCommandService;
import pl.zzpj.repository.ports.query.rent.RentQueryPort;
import pl.zzpj.repository.ports.query.rent.RentQueryService;
import pl.zzpj.repository.ports.query.rent.RentVehiclesQueryPort;
import pl.zzpj.repository.ports.query.user.UserQueryRepositoryPort;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentCommandService, RentQueryService {

    private RentCommandPort commandPort;

    private RentQueryPort queryPort;
    private UserQueryRepositoryPort userQueryPort;
    private RentVehiclesQueryPort vehicleQueryPort;

    @Override
    public Rent findRent(UUID rentId) {
        return queryPort.getRent(rentId);
    }

    @Override
    public List<Rent> findRentsByUser(UUID userId) {
        return queryPort.getRentsByUserId(userId);
    }

    @Override
    public List<Rent> findFutureRentsByVehicle(UUID vehicleId) {
        return queryPort.getRentsByVehicleId(vehicleId); // todo
    }

    @Override
    public List<Rent> findRentsByStatus(RentStatus status) {
        return queryPort.getRentsByStatus(status);
    }

    @Override
    public List<Rent> findRentsToIssue(LocalDateTime endTime) {
        return queryPort.getRentsByStatusAndDeclaredDatesBetween(
                RentStatus.CREATED, LocalDateTime.now(), endTime);
    }

    @Override
    public List<Rent> findRentsToReturn(LocalDateTime endTime) {
        return queryPort.getRentsByStatusAndDeclaredDatesBetween(
                RentStatus.ISSUED, LocalDateTime.now(), endTime);
    }

    @Override
    public List<Rent> findAllRents() {
        return queryPort.getAllRents();
    }

    @Override
    public boolean isVehicleAvailable(UUID vehicleId, LocalDateTime start, LocalDateTime end) {
        List<Rent> vehicleRents = queryPort.getRentsByVehicleIdAndDatesBetween(
                vehicleId, start, end);
        return vehicleRents.isEmpty();
    }

    public boolean isCancellable(Rent rent) {
        return false;
    }

    @Override
    public BigDecimal calculatePrice(UUID vehicleId, UUID userId, LocalDateTime start, LocalDateTime end) {
        User user = userQueryPort.getUserById(userId).orElseThrow();
        Vehicle vehicle = vehicleQueryPort.getById(vehicleId);
        return calculatePrice(user, vehicle, start, end);
    }

    private BigDecimal calculatePrice(User user, Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        double points = 0; // get from user
        double vehicleCostPerHour = 10; // get from vehicle
        List<Rent> userRents = queryPort.getRentsByUserId(user.getClientId());

        Duration period = Duration.between(start, end);
        double baseRentCost = period.toHours() * vehicle.getHourlyRate();
        return new BigDecimal(baseRentCost);
    }

    @Override
    public Rent createRent(UUID userId, UUID vehicleId, LocalDateTime startDate, LocalDateTime endDate) {
        User user = userQueryPort.getUserById(userId).orElseThrow();
        Vehicle vehicle = vehicleQueryPort.getById(vehicleId);

        Rent rent = Rent.createBuilder()
                .user(user)
                .vehicle(vehicle)
                .price(calculatePrice(user, vehicle, startDate, endDate))
                .startDate(startDate)
                .endDate(endDate)
                .createBuild();
        return commandPort.upsert(rent);
    }

    @Override
    public Rent cancelRent(UUID id) {
        Rent rent = queryPort.getRent(id);
        if(!this.isCancellable(rent)) {
            //todo throw
            return null;
        }
        rent.setStatus(RentStatus.CANCELLED);
        return commandPort.upsert(rent);
    }

    @Override
    public Rent issueVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        LocalDateTime now = LocalDateTime.now();
        // you can rent 30 mins before declared time
        if(rent.getDeclaredStartDate()
                .plus(30, ChronoUnit.MINUTES)
                .isBefore(now)) {
            return null; // todo throw
        }
        rent.setStatus(RentStatus.ISSUED);
        rent.setActualStartDate(now);
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            return null; // todo throw
        }
        rent.setStatus(RentStatus.RETURNED_GOOD);
        rent.setActualEndDate(LocalDateTime.now());
        // todo update user points
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnDamagedVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            return null; // todo throw
        }
        rent.setStatus(RentStatus.RETURNED_DAMAGED);
        rent.setActualEndDate(LocalDateTime.now());
        // todo update user points
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnMissingVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            return null; // todo throw
        }
        rent.setStatus(RentStatus.NOT_RETURNED);
        rent.setActualEndDate(LocalDateTime.now());
        // todo update user points
        return commandPort.upsert(rent);
    }

    @Override
    public void updateRentsNotIssued() {

    }

    /*
    anulowanie wypożyczenia:
        w krótkim czasie po jego utworzeniu
        jeśli jest przed tygodniem od rozpoczęcia
    koszt wypożyczenia:
        w momencie tworzenia rezerwacji jest obliczany na podstawie wyniku konta
        przy oddaniu może być naliczona kara:
            za przetrzymanie
            za oddanie uszkodzonego
            za "zgubienie" auta
    wynik konta:
        przechowywany w userze
        aktualizowany przy każdorazowej zmianie stanu statusu wyporzyczenia
     */
}

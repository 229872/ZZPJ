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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentCommandService, RentQueryService {

    private RentCommandPort commandPort;

    private RentQueryPort queryPort;

    @Override
    public Rent findRent(UUID rentId) {
        return queryPort.getRent(rentId);
    }

    @Override
    public List<Rent> findRentsByUser(User user) {
        return queryPort.getRentsByUser(user);
    }

    @Override
    public List<Rent> findFutureRentsByVehicle(Vehicle vehicle) {
        return queryPort.getRentsByVehicle(vehicle);
    }

    @Override
    public List<Rent> findRentsByStatus(RentStatus status) {
        return queryPort.getRentsByStatus(status);
    }

    @Override
    public List<Rent> findRentsToIssue(Period timeToDeclared) {
        LocalDateTime declaredStartTime = LocalDateTime.now().plus(timeToDeclared);
        return queryPort.getRentsByStatusAndDeclaredStartDate(
                RentStatus.CREATED, declaredStartTime);
    }

    @Override
    public List<Rent> findRentsToReturn(Period timeToDeclared) {
        LocalDateTime declaredStartTime = LocalDateTime.now().plus(timeToDeclared);
        return queryPort.getRentsByStatusAndDeclaredStartDate(
                RentStatus.ISSUED, declaredStartTime);
    }

    @Override
    public List<Rent> findAllRents() {
        return queryPort.getAllRents();
    }

    @Override
    public boolean isVehicleAvailable(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        List<Rent> vehicleRents = queryPort.getRentsByVehicleAndDatesBetween(
                vehicle, start, end);
        return vehicleRents.isEmpty();
    }

    public boolean isCancellable(Rent rent) {
        return false;
    }

    @Override
    public BigDecimal calculatePrice(Vehicle vehicle, User user, LocalDateTime start, LocalDateTime end) {
        double points = 0; // get from user
        double vehicleCostPerHour = 10; // get from vehicle
        List<Rent> userRents = queryPort.getRentsByUser(user);
        Period period = Period.between(start.toLocalDate(), end.toLocalDate());
        return new BigDecimal(10);
    }

    @Override
    public Rent createRent(User user, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) {
        Rent rent = Rent.createBuilder()
                .user(user)
                .vehicle(vehicle)
                .price(calculatePrice(vehicle, user, startDate, endDate))
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
        rent.setStatus(RentStatus.ISSUED);
        rent.setActualStartDate(LocalDateTime.now());
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.RETURNED_GOOD);
        rent.setActualEndDate(LocalDateTime.now());
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnDamagedVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.RETURNED_DAMAGED);
        rent.setActualEndDate(LocalDateTime.now());
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnMissingVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.NOT_RETURNED);
        rent.setActualEndDate(LocalDateTime.now());
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

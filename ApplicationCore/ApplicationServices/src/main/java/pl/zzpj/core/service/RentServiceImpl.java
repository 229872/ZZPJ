package pl.zzpj.core.service;

import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.Person;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.rent.RentCommandPort;
import pl.zzpj.ports.command.rent.RentCommandService;
import pl.zzpj.ports.query.rent.RentQueryPort;
import pl.zzpj.ports.query.rent.RentQueryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
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
    public List<Rent> findFutureRentsByVehicle(String vehicle) {
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
    public boolean isVehicleAvailable(String vehicle, LocalDateTime start, LocalDateTime end) {
        List<Rent> vehicleRents = queryPort.getRentsByVehicle(vehicle);

        return false;
    }

    public boolean isCancellable(Rent rent) {
        return false;
    }

    @Override
    public BigDecimal calculatePrice(String vehicle, User user, LocalDateTime start, LocalDateTime end) {
        double points = 0; // get from user
        double vehicleCostPerHour = 10; // get from vehicle
        List<Rent> userRents = queryPort.getRentsByUser(user);
        Period period = Period.between(start.toLocalDate(), end.toLocalDate());
        return new BigDecimal(10);
    }

    @Override
    public Rent createRent(User user, String vehicle, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        Rent rent = Rent.createRentBuilder()
                .user(user)
                .vehicle(vehicle)
                .price(price)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        return commandPort.add(rent);
    }

    @Override
    public Rent cancelRent(UUID id) {
        Rent rent = queryPort.getRent(id);
        if(!this.isCancellable(rent)) {
            //todo throw
            return null;
        }
        rent.setStatus(RentStatus.CANCELLED);
        return commandPort.update(rent);
    }

    @Override
    public Rent issueVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.ISSUED);
        rent.setActualStartDate(LocalDateTime.now());
        return commandPort.update(rent);
    }

    @Override
    public Rent returnVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.RETURNED_GOOD);
        rent.setActualEndDate(LocalDateTime.now());
        return commandPort.update(rent);
    }

    @Override
    public Rent returnDamagedVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.RETURNED_DAMAGED);
        rent.setActualEndDate(LocalDateTime.now());
        return commandPort.update(rent);
    }

    @Override
    public Rent returnMissingVehicle(UUID id) {
        Rent rent = queryPort.getRent(id);
        rent.setStatus(RentStatus.NOT_RETURNED);
        rent.setActualEndDate(LocalDateTime.now());
        return commandPort.update(rent);
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

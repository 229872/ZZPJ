package pl.zzpj.repository.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
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
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log
public class RentServiceImpl implements RentCommandService, RentQueryService {

    private RentCommandPort commandPort;

    private RentQueryPort queryPort;
    private UserQueryRepositoryPort userQueryPort;
    private RentVehiclesQueryPort vehicleQueryPort;

    @Override
    public Rent findRent(UUID rentId) throws RentNotFoundException {
        return queryPort.getRent(rentId);
    }

    @Override
    public List<Rent> findRentsByUser(UUID userId) {
        return queryPort.getRentsByUserId(userId);
    }

    @Override
    public List<Rent> findAllRentsByVehicle(UUID vehicleId) {
        return queryPort.getRentsByVehicleId(vehicleId);
    }

    @Override
    public List<Rent> findFutureRentsByVehicle(UUID vehicleId) {
        return queryPort.getFutureRentsByVehicleId(vehicleId);
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

    @Override
    public BigDecimal calculatePrice(UUID vehicleId, UUID userId, LocalDateTime start, LocalDateTime end) throws UserServiceNotFoundException {
        User user = userQueryPort.getUserById(userId).orElseThrow(
                () -> new UserServiceNotFoundException("Given user not found"));
        Vehicle vehicle = vehicleQueryPort.getById(vehicleId);
        return calculatePrice(user, vehicle, start, end);
    }

    private BigDecimal calculatePrice(User user, Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        Duration period = Duration.between(start, end);
        long baseRentCost = period.toHours() * vehicle.getHourlyRate();
        BigDecimal cost = new BigDecimal(baseRentCost);
        return cost.multiply(BigDecimal.valueOf(100 - (user.getScore() / 10000d)))
                .divide(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public Rent createRent(UUID userId, UUID vehicleId,
                           LocalDateTime startDate, LocalDateTime endDate)
            throws RentInvalidDatePeriodException, UserServiceNotFoundException {
        User user = userQueryPort.getUserById(userId)
                .orElseThrow(() -> new UserServiceNotFoundException("Given user not found"));
        Vehicle vehicle = vehicleQueryPort.getById(vehicleId);
        LocalDateTime now = LocalDateTime.now();
        if(startDate.isBefore(now) || endDate.isBefore(startDate)) {
            throw new RentInvalidDatePeriodException("Invalid date period given");
        }

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
    public Rent cancelRent(UUID id) throws RentNotFoundException, RentNotCancellableException {
        Rent rent = queryPort.getRent(id);
        if(!this.isCancellable(rent)) {
            throw new RentNotCancellableException("Rent is not cancellable");
        }
        rent.setStatus(RentStatus.CANCELLED);
        updateUserScore(rent);
        return commandPort.upsert(rent);
    }

    public boolean isCancellable(Rent rent) {
        LocalDateTime now = LocalDateTime.now();
        if(rent.getCreatedAt().plus(5, ChronoUnit.MINUTES)
                .isAfter(now)) {
            return true;
        }
        return rent.getDeclaredStartDate().plus(7, ChronoUnit.DAYS)
                .isAfter(now);
    }

    @Override
    public Rent issueVehicle(UUID id) throws RentNotFoundException, RentCannotIssueVehicleException {
        Rent rent = queryPort.getRent(id);
        LocalDateTime now = LocalDateTime.now();
        // you can rent 30 mins before declared time
        if(rent.getDeclaredStartDate()
                .plus(30, ChronoUnit.MINUTES)
                .isBefore(now)) {
            throw new RentCannotIssueVehicleException("Cannot issue right now");
        }
        rent.setStatus(RentStatus.ISSUED);
        rent.setActualStartDate(now);
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            throw new RentVehicleNotIssuedException("Vehicle not issued");
        }
        rent.setStatus(RentStatus.RETURNED_GOOD);
        rent.setActualEndDate(LocalDateTime.now());
        updateUserScore(rent);
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnDamagedVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            throw new RentVehicleNotIssuedException("Vehicle not issued");
        }
        rent.setStatus(RentStatus.RETURNED_DAMAGED);
        rent.setActualEndDate(LocalDateTime.now());
        updateUserScore(rent);
        return commandPort.upsert(rent);
    }

    @Override
    public Rent returnMissingVehicle(UUID id) throws RentNotFoundException, RentVehicleNotIssuedException {
        Rent rent = queryPort.getRent(id);
        if(!rent.getStatus().equals(RentStatus.ISSUED)) {
            throw new RentVehicleNotIssuedException("Vehicle not issued");
        }
        rent.setStatus(RentStatus.NOT_RETURNED);
        rent.setActualEndDate(LocalDateTime.now());
        updateUserScore(rent);
        rent.getVehicle().setAvailable(false);
        return commandPort.upsert(rent);
    }

    @Override
    public void updateRentsNotIssued() {
        List<Rent> rentsToIssue = queryPort.getRentsByStatus(RentStatus.CREATED);
        LocalDateTime now = LocalDateTime.now();
        rentsToIssue.forEach(rent -> {
            if(rent.getDeclaredStartDate().isBefore(now)) {
                rent.setStatus(RentStatus.NOT_ISSUED);
                updateUserScore(rent);
                commandPort.upsert(rent);
            }
        });
    }

    // modyfikator do ceny z powodu wyniku konta to pomiędzy -30% i +10%
    // dlatego punkty mogą mieć wartości od 3000 do -1000
    // w najlepszym wypadku klient może dostać 1000 punktów za jedno wypożyczenie
    private void updateUserScore(Rent rent) {
        double rentPoints = 0;
        if(rent.getActualStartDate() != null) {
            Duration deltaStart = Duration.between(rent.getDeclaredStartDate(), rent.getActualStartDate());
            if(deltaStart.isNegative()) {
                // odbiór przed czasem jest możliwy, ale niepożądany
                rentPoints -= 50d;
            } else if(deltaStart.toMinutes() < 60){
                // im później klient odbierze samochód, tym mniej punktów dostaje
                rentPoints += 200d * (60 - deltaStart.toMinutes());
            }
        }
        log.info(Double.toString(rentPoints));

        if(rent.getActualEndDate() != null) {
            log.info(rent.getDeclaredEndDate().toString());
            log.info(rent.getActualEndDate().toString());
            Duration deltaEnd = Duration.between(rent.getActualEndDate(), rent.getDeclaredEndDate());
            if (deltaEnd.isNegative()) {
                // oddane przed zadeklarowanym czasem (klient płaci za zarezerwowany czas)
                rentPoints += 300d;
            } else if (deltaEnd.toMinutes() < 60) {
                // klient traci 0,1 pkt% zniżki za każdą minutę opóźnienia
                rentPoints -= 10d * (deltaEnd.toMinutes());
            }
        }

        switch(rent.getStatus()) {
            case NOT_ISSUED -> rentPoints -= 100d;
            case CANCELLED -> rentPoints -= 50d;
            case RETURNED_GOOD -> rentPoints += 500d;
            case RETURNED_DAMAGED -> rentPoints -= 200d;
            case NOT_RETURNED -> rentPoints -= 3000d; // zniweluj każdą zniżkę
        }

        // clamp
        rent.getUser().setScore(Math.max(-1000, Math.min(3000, rentPoints)));
    }
}

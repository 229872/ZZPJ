package pl.zzpj.repository.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.ports.command.rent.RentCommandService;
import pl.zzpj.repository.ports.query.rent.RentQueryService;
import pl.zzpj.repository.rest.api.command.RentCommandRest;
import pl.zzpj.repository.rest.api.query.RentQueryRest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RentRestAdapter implements RentQueryRest, RentCommandRest {

    private final RentCommandService commandService;
    private final RentQueryService queryService;

    @Override
    public Rent createRent(Rent rent) {
        return null;
    }

    @Override
    public Rent issueVehicle(Rent rent) {
        return null;
    }

    @Override
    public Rent returnVehicle(Rent rent) {
        return null;
    }

    @Override
    public Rent returnDamagedVehicle(Rent rent) {
        return null;
    }

    @Override
    public Rent returnMissingVehicle(Rent rent) {
        return null;
    }

    @Override
    public Rent findRent(UUID rentId) {
        return null;
    }

    @Override
    public List<Rent> findRentsByUser(User user) {
        return null;
    }

    @Override
    public List<Rent> findFutureRentsByVehicle(String vehicle) {
        return null;
    }

    @Override
    public List<Rent> findRentsByStatus(RentStatus status) {
        return null;
    }

    @Override
    public List<Rent> findRentsToIssue(Period timeToDeclared) {
        return null;
    }

    @Override
    public List<Rent> findRentsToReturn(Period timeToDeclared) {
        return null;
    }

    @Override
    public List<Rent> findAllRents() {
        return null;
    }

    @Override
    public BigDecimal calculatePrice(String vehicle, User user, LocalDateTime start, LocalDateTime end) {
        return null;
    }
}

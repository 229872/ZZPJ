package pl.zzpj.repository.adapter.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.rent.RentCommandPort;
import pl.zzpj.ports.query.rent.RentQueryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RentRepositoryAdapter implements RentCommandPort, RentQueryPort {
    @Override
    public Rent add(Rent rent) {
        return null;
    }

    @Override
    public Rent update(Rent rent) {
        return null;
    }

    @Override
    public Rent getRent(UUID rentId) {
        return null;
    }

    @Override
    public List<Rent> getRentsByStatus(RentStatus status) {
        return null;
    }

    @Override
    public List<Rent> getRentsByStatuses(List<RentStatus> statuses) {
        return null;
    }

    @Override
    public List<Rent> getRentsByUser(User user) {
        return null;
    }

    @Override
    public List<Rent> getRentsByVehicle(String vehicle) {
        return null;
    }

    @Override
    public List<Rent> getRentsByStatusAndDeclaredStartDate(RentStatus status, LocalDateTime declaredStartDate) {
        return null;
    }

    @Override
    public List<Rent> getAllRents() {
        return null;
    }
}

package pl.zzpj.core.service;

import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.Person;
import pl.zzpj.ports.command.rent.RentCommandPort;
import pl.zzpj.ports.command.rent.RentCommandService;
import pl.zzpj.ports.query.rent.RentQueryPort;
import pl.zzpj.ports.query.rent.RentQueryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Service
public class RentServiceImpl implements RentCommandService, RentQueryService {

    private RentCommandPort commandPort;

    private RentQueryPort queryPort;

    @Override
    public Rent findRent(UUID rentId) {
        return null;
    }

    @Override
    public List<Rent> findUserRents(UUID userId) {
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
    public boolean isVehicleAvailable(String vehicle, LocalDateTime start, LocalDateTime end) {
        return false;
    }

    @Override
    public BigDecimal calculatePrice(String vehicle, Person person, LocalDateTime start, LocalDateTime end) {
        return null;
    }

    /*
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

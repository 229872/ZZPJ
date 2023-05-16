package pl.zzpj.ports.command.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;

public interface RentCommandPort {
    void createRent(Rent rent);
    Rent issue(Rent rent);
    Rent returnVehicle(Rent rent);
    Rent returnDamagedVehicle(Rent rent); // może jakiś opis uszkodzeń i wycena?
    Rent returnMissingVehicle(Rent rent); // nazwa dziwna, ale wiadomo o co chodzi
    void updateRentsNotIssued(); // dla scheduled taska
}

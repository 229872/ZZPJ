package pl.zzpj.repository.rest.api.command;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;

public interface RentCommandRest {
    Rent createRent(Rent rent);
    Rent issueVehicle(Rent rent);
    Rent returnVehicle(Rent rent);
    Rent returnDamagedVehicle(Rent rent);
    Rent returnMissingVehicle(Rent rent);

}

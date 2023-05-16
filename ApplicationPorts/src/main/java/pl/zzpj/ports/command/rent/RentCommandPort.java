package pl.zzpj.ports.command.rent;

import pl.zzpj.core.domain.model.rentModel.Rent;

public interface RentCommandPort {
    Rent add(Rent rent);

    Rent update(Rent rent);
}

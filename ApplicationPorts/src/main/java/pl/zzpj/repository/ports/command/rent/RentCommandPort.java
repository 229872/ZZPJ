package pl.zzpj.repository.ports.command.rent;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;

public interface RentCommandPort {
    Rent add(Rent rent);

    Rent update(Rent rent);
}

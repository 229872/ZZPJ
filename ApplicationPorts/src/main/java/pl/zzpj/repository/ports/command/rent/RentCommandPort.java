package pl.zzpj.repository.ports.command.rent;

import pl.zzpj.repository.core.domain.model.rentModel.Rent;

public interface RentCommandPort {
    Rent upsert(Rent rent);
}

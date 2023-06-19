package pl.zzpj.repository.core.domain.exception.rent;

import pl.zzpj.repository.core.domain.exception.AppNotFoundException;

public class RentNotFoundException extends AppNotFoundException {
    public RentNotFoundException(String message) {
        super(message);
    }
}

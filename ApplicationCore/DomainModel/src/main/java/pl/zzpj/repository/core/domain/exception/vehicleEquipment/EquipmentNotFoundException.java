package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.AppNotFoundException;

public class EquipmentNotFoundException extends AppNotFoundException {

    public EquipmentNotFoundException() {
        super();
    }

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    public EquipmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentNotFoundException(Throwable cause) {
        super(cause);
    }
}

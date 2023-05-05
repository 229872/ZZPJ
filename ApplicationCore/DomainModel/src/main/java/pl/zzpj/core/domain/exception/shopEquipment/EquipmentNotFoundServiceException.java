package pl.zzpj.core.domain.exception.shopEquipment;

import pl.zzpj.core.domain.exception.AppNotFoundException;

public class EquipmentNotFoundServiceException extends AppNotFoundException {

    public EquipmentNotFoundServiceException() {
        super();
    }

    public EquipmentNotFoundServiceException(String message) {
        super(message);
    }

    public EquipmentNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentNotFoundServiceException(Throwable cause) {
        super(cause);
    }
}

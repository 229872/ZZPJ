package pl.zzpj.repository.core.domain.exception.shopEquipment;

import pl.zzpj.repository.core.domain.exception.AppNotFoundException;

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

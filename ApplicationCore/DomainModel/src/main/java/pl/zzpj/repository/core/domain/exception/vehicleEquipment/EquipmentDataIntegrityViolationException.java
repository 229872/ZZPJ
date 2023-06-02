package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

public class EquipmentDataIntegrityViolationException extends Exception {
    public EquipmentDataIntegrityViolationException() {
    }

    public EquipmentDataIntegrityViolationException(String message) {
        super(message);
    }

    public EquipmentDataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentDataIntegrityViolationException(Throwable cause) {
        super(cause);
    }
}

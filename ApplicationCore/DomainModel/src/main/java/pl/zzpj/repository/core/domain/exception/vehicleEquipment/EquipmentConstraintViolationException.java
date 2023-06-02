package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

public class EquipmentConstraintViolationException extends Exception {
    public EquipmentConstraintViolationException() {
    }

    public EquipmentConstraintViolationException(String message) {
        super(message);
    }

    public EquipmentConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentConstraintViolationException(Throwable cause) {
        super(cause);
    }
}

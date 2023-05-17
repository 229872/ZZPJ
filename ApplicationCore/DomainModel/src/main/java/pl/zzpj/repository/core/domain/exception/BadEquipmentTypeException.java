package pl.zzpj.repository.core.domain.exception;

public class BadEquipmentTypeException extends Exception {
    public BadEquipmentTypeException() {
        super();
    }

    public BadEquipmentTypeException(String message) {
        super(message);
    }

    public BadEquipmentTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEquipmentTypeException(Throwable cause) {
        super(cause);
    }
}

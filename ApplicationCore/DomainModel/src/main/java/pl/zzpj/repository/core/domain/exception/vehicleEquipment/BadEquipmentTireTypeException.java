package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

public class BadEquipmentTireTypeException extends Exception {
    public BadEquipmentTireTypeException() {
    }

    public BadEquipmentTireTypeException(String message) {
        super(message);
    }

    public BadEquipmentTireTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEquipmentTireTypeException(Throwable cause) {
        super(cause);
    }
}

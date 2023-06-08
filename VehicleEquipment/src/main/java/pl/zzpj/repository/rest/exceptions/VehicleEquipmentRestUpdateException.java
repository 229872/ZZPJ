package pl.zzpj.repository.rest.exceptions;

public class VehicleEquipmentRestUpdateException extends Exception {
    public VehicleEquipmentRestUpdateException() {
    }

    public VehicleEquipmentRestUpdateException(String message) {
        super(message);
    }

    public VehicleEquipmentRestUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentRestUpdateException(Throwable cause) {
        super(cause);
    }
}

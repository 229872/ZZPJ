package pl.zzpj.repository.rest.exceptions;

public class VehicleEquipmentRestCreateException extends Exception {
    public VehicleEquipmentRestCreateException() {
    }

    public VehicleEquipmentRestCreateException(String message) {
        super(message);
    }

    public VehicleEquipmentRestCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentRestCreateException(Throwable cause) {
        super(cause);
    }
}

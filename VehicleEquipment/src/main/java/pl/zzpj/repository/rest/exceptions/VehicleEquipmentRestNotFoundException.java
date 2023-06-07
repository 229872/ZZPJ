package pl.zzpj.repository.rest.exceptions;

public class VehicleEquipmentRestNotFoundException extends Exception {
    public VehicleEquipmentRestNotFoundException() {
    }

    public VehicleEquipmentRestNotFoundException(String message) {
        super(message);
    }

    public VehicleEquipmentRestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentRestNotFoundException(Throwable cause) {
        super(cause);
    }
}

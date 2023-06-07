package pl.zzpj.repository.rest.exceptions;

public class VehicleEquipmentRestNotSpecifiedException extends Exception {
    public VehicleEquipmentRestNotSpecifiedException() {
    }

    public VehicleEquipmentRestNotSpecifiedException(String message) {
        super(message);
    }

    public VehicleEquipmentRestNotSpecifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentRestNotSpecifiedException(Throwable cause) {
        super(cause);
    }
}

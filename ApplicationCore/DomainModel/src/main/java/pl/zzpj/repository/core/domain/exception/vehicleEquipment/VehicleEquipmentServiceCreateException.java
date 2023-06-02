package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

public class VehicleEquipmentServiceCreateException extends Exception {
    public VehicleEquipmentServiceCreateException() {
    }

    public VehicleEquipmentServiceCreateException(String message) {
        super(message);
    }

    public VehicleEquipmentServiceCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentServiceCreateException(Throwable cause) {
        super(cause);
    }
}

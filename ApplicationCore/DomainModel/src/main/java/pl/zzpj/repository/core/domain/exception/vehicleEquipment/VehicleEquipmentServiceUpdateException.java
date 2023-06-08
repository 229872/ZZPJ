package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

public class VehicleEquipmentServiceUpdateException extends Exception {
    public VehicleEquipmentServiceUpdateException() {
    }

    public VehicleEquipmentServiceUpdateException(String message) {
        super(message);
    }

    public VehicleEquipmentServiceUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentServiceUpdateException(Throwable cause) {
        super(cause);
    }
}

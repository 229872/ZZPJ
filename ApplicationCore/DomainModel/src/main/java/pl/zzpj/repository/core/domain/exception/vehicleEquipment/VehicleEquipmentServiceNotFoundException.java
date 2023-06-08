package pl.zzpj.repository.core.domain.exception.vehicleEquipment;

import pl.zzpj.repository.core.domain.exception.AppNotFoundException;

public class VehicleEquipmentServiceNotFoundException extends AppNotFoundException {

    public VehicleEquipmentServiceNotFoundException() {
        super();
    }

    public VehicleEquipmentServiceNotFoundException(String message) {
        super(message);
    }

    public VehicleEquipmentServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleEquipmentServiceNotFoundException(Throwable cause) {
        super(cause);
    }
}

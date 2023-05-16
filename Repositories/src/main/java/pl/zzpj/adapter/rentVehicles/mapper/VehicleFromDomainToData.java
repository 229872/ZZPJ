package pl.zzpj.adapter.rentVehicles.mapper;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.data.rent.VehicleEnt;

public class VehicleFromDomainToData {

    public static VehicleEnt map(Vehicle vehicle) {
        return VehicleEnt.builder()
                .make(vehicle.getMake())
                .model(vehicle.getModel())
                .isAvailable(vehicle.isAvailable())
                .hourlyRate(vehicle.getHourlyRate())
                .build();
    }
}

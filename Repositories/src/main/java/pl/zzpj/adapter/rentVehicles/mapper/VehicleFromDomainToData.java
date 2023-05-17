package pl.zzpj.adapter.rentVehicles.mapper;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.data.rent.VehicleEnt;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDomainToData {

    public static VehicleEnt map(Vehicle vehicle) {
        return VehicleEnt.builder()
                .make(vehicle.getMake())
                .model(vehicle.getModel())
                .isAvailable(vehicle.isAvailable())
                .hourlyRate(vehicle.getHourlyRate())
                .build();
    }

    public static List<VehicleEnt> mapList(List<Vehicle> vehicles) {
        List<VehicleEnt> vehicleEnts = new ArrayList<>();
        for (Vehicle vehicle: vehicles) {
            vehicleEnts.add(map(vehicle));
        }
        return vehicleEnts;
    }
}

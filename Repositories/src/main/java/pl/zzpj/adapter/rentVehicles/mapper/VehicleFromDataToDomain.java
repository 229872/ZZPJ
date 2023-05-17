package pl.zzpj.adapter.rentVehicles.mapper;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.data.rent.VehicleEnt;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDataToDomain {

    public static Vehicle map(VehicleEnt ent) {
        return Vehicle.builder()
                .make(ent.getMake())
                .model(ent.getModel())
                .isAvailable(ent.isAvailable())
                .hourlyRate(ent.getHourlyRate())
                .build();
    }

    public static List<Vehicle> mapList(List<VehicleEnt> vehicleEnts) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleEnt vehicle: vehicleEnts) {
            vehicles.add(map(vehicle));
        }
        return vehicles;
    }

}

package pl.zzpj.adapter.rentVehicles.mapper;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.data.rent.VehicleEnt;

public class VehicleFromDataToDomain {

    public static Vehicle map(VehicleEnt ent) {
        return Vehicle.builder()
                .make(ent.getMake())
                .model(ent.getModel())
                .isAvailable(ent.isAvailable())
                .hourlyRate(ent.getHourlyRate())
                .build();
    }

}

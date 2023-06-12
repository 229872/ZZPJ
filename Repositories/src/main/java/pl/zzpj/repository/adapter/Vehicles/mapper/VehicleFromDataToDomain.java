package pl.zzpj.repository.adapter.Vehicles.mapper;

import org.springframework.beans.BeanUtils;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Car;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Motorbike;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Van;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.data.vehicle.CarEnt;
import pl.zzpj.repository.data.vehicle.VanEnt;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDataToDomain {

    public static Vehicle map(VehicleEnt vehicle) {
        Vehicle dto;
        if (vehicle instanceof CarEnt){
            dto = new Car();
        } else if (vehicle instanceof VanEnt) {
            dto = new Van();
        } else  {
            dto = new Motorbike();
        }

        BeanUtils.copyProperties(vehicle, dto);
        return dto;
    }

    public static List<Vehicle> mapList(List<VehicleEnt> vehicleEnts) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleEnt vehicle : vehicleEnts) {
            vehicles.add(map(vehicle));
        }
        return vehicles;
    }

}

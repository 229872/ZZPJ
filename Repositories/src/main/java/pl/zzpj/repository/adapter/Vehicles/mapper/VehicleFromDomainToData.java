package pl.zzpj.repository.adapter.Vehicles.mapper;

import org.springframework.beans.BeanUtils;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Car;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Van;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.data.vehicle.CarEnt;
import pl.zzpj.repository.data.vehicle.MotorbikeEnt;
import pl.zzpj.repository.data.vehicle.VanEnt;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDomainToData {

    public static VehicleEnt map(Vehicle vehicle) {
        VehicleEnt dto;
        if (vehicle instanceof Car){
            dto = new CarEnt();
        } else if (vehicle instanceof Van) {
            dto = new VanEnt();
        } else  {
            dto = new MotorbikeEnt();
        }

        BeanUtils.copyProperties(vehicle, dto);
        return dto;
    }

    public static List<VehicleEnt> mapList(List<Vehicle> vehicles) {
        List<VehicleEnt> vehicleEnts = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleEnts.add(map(vehicle));
        }
        return vehicleEnts;
    }
}

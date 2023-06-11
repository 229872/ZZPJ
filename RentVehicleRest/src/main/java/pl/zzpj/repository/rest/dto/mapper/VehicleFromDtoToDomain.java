package pl.zzpj.repository.rest.dto.mapper;

import org.springframework.beans.BeanUtils;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Car;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Motorbike;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Van;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.rest.dto.CarDto;
import pl.zzpj.repository.rest.dto.MotorbikeDto;
import pl.zzpj.repository.rest.dto.VanDto;
import pl.zzpj.repository.rest.dto.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDtoToDomain {
    public static Vehicle map(VehicleDto vehicle) {
        Vehicle dto;
        if (vehicle instanceof CarDto){
            dto = new Car();
        } else if (vehicle instanceof VanDto) {
            dto = new Van();
        } else  {
            dto = new Motorbike();
        }

        BeanUtils.copyProperties(vehicle, dto);
        return dto;
    }

    public static List<Vehicle> mapList(List<VehicleDto> vehicleDtos) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleDto vehicle: vehicleDtos) {
            vehicles.add(map(vehicle));
        }
        return vehicles;
    }
}

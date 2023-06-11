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

public class VehicleFromDomainToDto {

    public static VehicleDto map(Vehicle vehicle) {
        VehicleDto dto;
        if (vehicle instanceof Car){
            dto = new CarDto();
        } else if (vehicle instanceof Van) {
            dto = new VanDto();
        } else  {
            dto = new MotorbikeDto();
        }

        BeanUtils.copyProperties(vehicle, dto);
        return dto;
    }

    public static List<VehicleDto> mapList(List<Vehicle> vehicles) {
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle: vehicles) {
            vehicleDtos.add(map(vehicle));
        }
        return vehicleDtos;
    }
}

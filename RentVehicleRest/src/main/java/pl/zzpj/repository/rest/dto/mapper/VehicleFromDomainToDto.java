package pl.zzpj.repository.rest.dto.mapper;

import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.rest.dto.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDomainToDto {

    public static VehicleDto map(Vehicle vehicle) {
        return VehicleDto.builder()
                .make(vehicle.getMake())
                .model(vehicle.getModel())
                .hourlyRate(vehicle.getHourlyRate())
                .build();
    }

    public static List<VehicleDto> mapList(List<Vehicle> vehicles) {
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        for (Vehicle vehicle: vehicles) {
            vehicleDtos.add(map(vehicle));
        }
        return vehicleDtos;
    }
}

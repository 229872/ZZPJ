package pl.zzpj.rest.dto.mapper;

import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.data.rent.VehicleEnt;
import pl.zzpj.rest.dto.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDtoToDomain {
    public static Vehicle map(VehicleDto dto) {
        return Vehicle.builder()
                .make(dto.getMake())
                .model(dto.getModel())
                .isAvailable(true)
                .hourlyRate(dto.getHourlyRate())
                .build();
    }

    public static List<Vehicle> mapList(List<VehicleDto> vehicleDtos) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (VehicleDto vehicle: vehicleDtos) {
            vehicles.add(map(vehicle));
        }
        return vehicles;
    }
}

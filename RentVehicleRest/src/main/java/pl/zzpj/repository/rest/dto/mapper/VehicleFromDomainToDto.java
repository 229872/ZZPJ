package pl.zzpj.repository.rest.dto.mapper;

import org.springframework.beans.BeanUtils;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Car;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Van;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.rest.dto.CarDto;
import pl.zzpj.repository.rest.dto.PickupDto;
import pl.zzpj.repository.rest.dto.VanDto;
import pl.zzpj.repository.rest.dto.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleFromDomainToDto {

    public static VehicleDto map(Vehicle vehicle) {
        VehicleDto dto;
        if (vehicle.getCar_type().toLowerCase().contains("van")){
            dto = new VanDto();
        } else if (vehicle.getCar_type().toLowerCase().contains("pickup")){

            dto = new PickupDto();
        } else  {
            dto = new CarDto();
        }

        BeanUtils.copyProperties(vehicle, dto);
//        switch (vehicle.getRating()) {
//            case DRY:
//                dto.setRating(ConditionRating.DRY);
//                break;
//            case SUNNY:
//                dto.setRating(ConditionRating.SUNNY);
//                break;
//            case TOUGH:
//                dto.setRating(ConditionRating.TOUGH);
//                break;
//            default:
//                dto.setRating(ConditionRating.ALLWEATHER);
//                break;
//        }
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

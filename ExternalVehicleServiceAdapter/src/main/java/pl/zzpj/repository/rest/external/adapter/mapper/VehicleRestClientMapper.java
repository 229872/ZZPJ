package pl.zzpj.repository.rest.external.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.*;
import pl.zzpj.repository.rest.external.adapter.VehicleRestClientAdapter;
import pl.zzpj.repository.rest.external.dto.VehicleInputDto;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VehicleRestClientMapper {
  public Vehicle vehicleInputDtoToDomain (VehicleInputDto inputDto) {
    String type = inputDto.car_type().toLowerCase();
    String[] makeModel = inputDto.make_and_model().split("\\s+");

    if (type.contains("van")) {
      return Van.fromApiBuilder()
              .make(makeModel[0])
              .model(makeModel[1])
              .hourlyRate(80)
              .isAvailable(true)
              .rating(ConditionRating.ALLWEATHER)
              .damage(new ArrayList<>())
              .color(inputDto.color())
              .transmission(inputDto.transmission())
              .drive_type(inputDto.drive_type())
              .fuel_type(inputDto.fuel_type())
              .car_type(inputDto.car_type())
              .car_options(inputDto.car_options())
              .specs(inputDto.specs())
              .doors(inputDto.doors())
              .kilometrage(inputDto.kilometrage())
              .license_plate(inputDto.license_plate())
              .cargoCapacity("2000l")
              .build();

    } else if (type.contains("pickup")) {
      return Pickup.fromApiBuilder()
              .make(makeModel[0])
              .model(makeModel[1])
              .hourlyRate(80)
              .isAvailable(true)
              .rating(ConditionRating.TOUGH)
              .damage(new ArrayList<>())
              .color(inputDto.color())
              .transmission(inputDto.transmission())
              .drive_type(inputDto.drive_type())
              .fuel_type(inputDto.fuel_type())
              .car_type(inputDto.car_type())
              .car_options(inputDto.car_options())
              .specs(inputDto.specs())
              .doors(inputDto.doors())
              .kilometrage(inputDto.kilometrage())
              .license_plate(inputDto.license_plate())
              .build();

    } else {
      ConditionRating rating = ConditionRating.ALLWEATHER;
      if (type.contains("cabrio")) {
        rating = ConditionRating.SUNNY;
      } else if (type.contains("suv")) {
        rating = ConditionRating.TOUGH;
      }
      return Car.fromApiBuilder()
              .make(makeModel[0])
              .model(makeModel[1])
              .hourlyRate(80)
              .isAvailable(true)
              .rating(rating)
              .damage(new ArrayList<>())
              .color(inputDto.color())
              .transmission(inputDto.transmission())
              .drive_type(inputDto.drive_type())
              .fuel_type(inputDto.fuel_type())
              .car_type(inputDto.car_type())
              .car_options(inputDto.car_options())
              .specs(inputDto.specs())
              .doors(inputDto.doors())
              .kilometrage(inputDto.kilometrage())
              .license_plate(inputDto.license_plate())
              .build();

    }
  }
}

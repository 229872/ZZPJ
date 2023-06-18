package pl.zzpj.repository.core.domain.model.rentModel.vehicles;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Car extends Vehicle{

    @Builder(builderMethodName = "fromApiBuilder")
    public Car(String make, String model, long hourlyRate, boolean isAvailable, ConditionRating rating, List<String> damage, String color, String transmission, String drive_type, String fuel_type, String car_type, ArrayList<String> car_options, ArrayList<String> specs, int doors, int kilometrage, String license_plate, String fuelType) {
        super(make, model, hourlyRate, isAvailable, rating, damage, color, transmission, drive_type, fuel_type, car_type, car_options, specs, doors, kilometrage, license_plate);

    }
}

package pl.zzpj.repository.core.domain.model.rentModel.vehicles;


import lombok.*;
import pl.zzpj.repository.core.domain.model.AbstractDataModel;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Vehicle extends AbstractDataModel {
    private String make;
    private String model;
    private long hourlyRate;
    private boolean isAvailable;
    ConditionRating rating;
    List<String> damage;
    String color;
    String transmission;
    String drive_type;
    String fuel_type;
    String car_type;
    ArrayList<String> car_options;
    ArrayList<String> specs;
    int doors;

    public Vehicle(String make, String model, long hourlyRate, boolean isAvailable, ConditionRating rating, List<String> damage, String color, String transmission, String drive_type, String fuel_type, String car_type, ArrayList<String> car_options, ArrayList<String> specs, int doors, int kilometrage, String license_plate) {
        this.make = make;
        this.model = model;
        this.hourlyRate = hourlyRate;
        this.isAvailable = isAvailable;
        this.rating = rating;
        this.damage = damage;
        this.color = color;
        this.transmission = transmission;
        this.drive_type = drive_type;
        this.fuel_type = fuel_type;
        this.car_type = car_type;
        this.car_options = car_options;
        this.specs = specs;
        this.doors = doors;
        this.kilometrage = kilometrage;
        this.license_plate = license_plate;
    }

    int kilometrage;
    String license_plate;



}

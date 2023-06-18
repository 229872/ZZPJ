package pl.zzpj.repository.rest.external.dto;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public record VehicleInputDto(
    int id,
    String uid,
    String vin,
    String make_and_model,
    String color,
    String transmission,
    String drive_type,
    String fuel_type,
    String car_type,
    ArrayList<String> car_options,
    ArrayList<String> specs,
    int doors,
    int mileage,
    int kilometrage,
    String license_plate
){}

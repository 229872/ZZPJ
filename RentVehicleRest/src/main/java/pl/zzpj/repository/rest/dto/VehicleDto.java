package pl.zzpj.repository.rest.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "vehicleType", visible = true)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = VanDto.class, name = "VAN"),
//        @JsonSubTypes.Type(value = CarDto.class, name = "CAR"),
//        @JsonSubTypes.Type(value = PickupDto.class, name = "PICKUP")
//})
public class VehicleDto {
    private UUID id;
    private String make;
    private String model;
    private long hourlyRate;
    private boolean isAvailable;
    List<String> damage;
    ConditionRating rating;
    String color;
    String transmission;
    String drive_type;
    String fuel_type;
    String car_type;
    ArrayList<String> car_options;
    ArrayList<String> specs;
    int doors;

}

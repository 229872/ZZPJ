package pl.zzpj.repository.rest.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Motorbike;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "vehicleType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = VanDto.class, name = "VAN"),
        @JsonSubTypes.Type(value = CarDto.class, name = "CAR"),
        @JsonSubTypes.Type(value = MotorbikeDto.class, name = "MOTORBIKE")
})
public class VehicleDto {
    private UUID id;
    private String make;
    private String model;
    private long hourlyRate;
}

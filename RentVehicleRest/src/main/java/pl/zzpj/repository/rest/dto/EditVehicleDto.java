package pl.zzpj.repository.rest.dto;

import lombok.*;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditVehicleDto {
    private long hourlyRate;
    List<String> damage;
    String color;
}

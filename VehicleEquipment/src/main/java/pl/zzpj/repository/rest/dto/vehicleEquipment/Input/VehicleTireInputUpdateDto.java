package pl.zzpj.repository.rest.dto.vehicleEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record VehicleTireInputUpdateDto(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        @Positive
        Double cost,

        @NotNull
        @Positive
        Double maximumSpeed,

        @NotNull
        @Positive
        Double maximumWeight
) {

}

package pl.zzpj.repository.rest.dto.vehicleEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VehicleTireInputUpdateDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Positive
    private Double cost;

    @NotNull
    @Positive
    private Double maximumSpeed;

    @NotNull
    @Positive
    private Double maximumWeight;
}

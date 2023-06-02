package pl.zzpj.repository.rest.dto.vehicleEquipment.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class VehicleTireInputCreateDto {

    @NotBlank
    protected String name;

    @NotBlank
    protected String description;

    @NotNull
    @Positive
    protected Double cost;

    @NotNull
    protected Boolean archive;

    @NotBlank
    private String size;

    @NotNull
    @Positive
    private Double maximumSpeed;

    @NotNull
    @Positive
    private Double maximumWeight;

    @Builder
    public VehicleTireInputCreateDto(String name,
                                     String description, Double cost, String size, Boolean archive,
                                     Double maximumSpeed, Double maximumWeight) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
    }
}

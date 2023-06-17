package pl.zzpj.repository.rest.dto.vehicleEquipment.Output;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
public class VehicleTireOutputDto extends VehicleEquipmentOutputDto {
    private String size;

    private Double maximumSpeed;

    private Double maximumWeight;

    private RestTireType type;

    @Builder(builderMethodName = "fromDomainBuilder")
    public VehicleTireOutputDto(UUID uuid, String name,
                                String description, Double cost, boolean archive, String size,
                                Double maximumSpeed, Double maximumWeight, RestTireType type) {
        super(uuid, name, description, cost, archive);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.type = type;
    }
}

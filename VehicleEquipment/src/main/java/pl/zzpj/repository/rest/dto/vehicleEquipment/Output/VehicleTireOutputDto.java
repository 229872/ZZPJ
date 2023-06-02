package pl.zzpj.repository.rest.dto.vehicleEquipment.Output;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.format.annotation.DateTimeFormat;
import pl.zzpj.repository.rest.dto.vehicleEquipment.RestTireType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
public class VehicleTireOutputDto extends VehicleEquipmentOutputDto {
    private String size;

    private Long maximumSpeed;

    private Long maximumWeight;

    @DateTimeFormat
    private LocalDateTime productionDate;

    private RestTireType type;

    @Builder(builderMethodName = "fromDomainBuilder")
    public VehicleTireOutputDto(UUID uuid, String name,
                                String description, Double cost, String size,
                                Long maximumSpeed, Long maximumWeight, LocalDateTime productionDate, RestTireType type) {
        super(uuid, name, description, cost);
        this.size = size;
        this.maximumSpeed = maximumSpeed;
        this.maximumWeight = maximumWeight;
        this.productionDate = productionDate;
        this.type = type;
    }
}

package pl.zzpj.repository.rest.dto.vehicleEquipment.Output;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@NoArgsConstructor
@Jacksonized
public class VehicleEquipmentOutputDto {

    protected UUID uuid;

    protected String name;

    protected String description;

    protected Double cost;

    protected boolean archive;

    public VehicleEquipmentOutputDto(UUID uuid, String name, String description, Double cost, boolean archive) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.archive = archive;
    }
}

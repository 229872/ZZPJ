package pl.zzpj.repository.adapter.vehicleEquipment.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.data.vehicleEquipment.VehicleEquipmentEnt;
import pl.zzpj.repository.data.vehicleEquipment.VehicleTireEnt;
import pl.zzpj.repository.data.vehicleEquipment.TireTypeEnt;

@Component
@NoArgsConstructor
public class VehicleTireFromDomainToDataMapper {
    public VehicleEquipmentEnt convertDomainModelToDataRepository(VehicleTire tire) {
        return VehicleTireEnt.toDataBuilder()
                .id(tire.getEquipment().getSuperModel().getId())
                .version(tire.getEquipment().getSuperModel().getVersion())
                .name(tire.getEquipment().getName())
                .description(tire.getEquipment().getDescription())
                .cost(tire.getEquipment().getCost())
                .archive(tire.getEquipment().getArchive())
                .size(tire.getSize())
                .maximumSpeed(tire.getMaximumSpeed())
                .maximumWeight(tire.getMaximumWeight())
                .productionDate(tire.getProductionDate())
                .typeEnt(TireTypeEnt.valueOf(tire.getType().name()))
                .build();
    }
}

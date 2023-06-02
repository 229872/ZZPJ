package pl.zzpj.repository.adapter.vehicleEquipment.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.data.vehicleEquipment.TireTypeEnt;
import pl.zzpj.repository.data.vehicleEquipment.VehicleEquipmentEnt;
import pl.zzpj.repository.data.vehicleEquipment.VehicleTireEnt;

@Component
@NoArgsConstructor
public class VehicleTireFromDomainToDataMapper {
    public VehicleEquipmentEnt convertDomainModelToDataRepository(VehicleTire tire) {
        return new VehicleTireEnt(
                tire.getEquipment().getSuperModel().getId(),
                tire.getEquipment().getSuperModel().getVersion(),
                tire.getEquipment().getName(),
                tire.getEquipment().getDescription(),
                tire.getEquipment().getCost(),
                tire.getEquipment().getArchive(),
                tire.getSize(),
                tire.getMaximumSpeed(),
                tire.getMaximumWeight(),
                TireTypeEnt.valueOf(tire.getType().name()));
    }
}

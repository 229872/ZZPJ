package pl.zzpj.repository.adapter.vehicleEquipment.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.vehicleModel.TireType;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.data.vehicleEquipment.VehicleTireEnt;

@Component
@NoArgsConstructor
public class VehicleTireFromDataToDomainMapper {

    public VehicleTire convertDataToDomainModel(VehicleTireEnt tireEnt) {

        return new VehicleTire(tireEnt.getId(), tireEnt.getVersion(),
                tireEnt.getName(), tireEnt.isArchive(), tireEnt.getDescription(), tireEnt.getCost(), tireEnt.getSize(),
                tireEnt.getMaximumSpeed(), tireEnt.getMaximumWeight(),
                TireType.valueOf(tireEnt.getTypeEnt().name()));
    }
}

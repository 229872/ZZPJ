package pl.zzpj.repository.adapter.rent.mapper;

import lombok.AllArgsConstructor;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDataToDomain;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDomainToData;
import pl.zzpj.repository.adapter.user.mapper.AccountMapper;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.data.rent.RentEnt;

@AllArgsConstructor
public class RentFromDomainToData {

    private AccountMapper mapper;


    public RentEnt map(Rent rent) {
        return RentEnt.builder()
                .id(rent.getId())
                .version(rent.getVersion())
                .status(rent.getStatus())
                .user(mapper.mapToAccount(rent.getUser()))
                .vehicle(VehicleFromDomainToData.map(rent.getVehicle()))
                .price(rent.getPrice())
                .penalty(rent.getPenalty())
                .declaredEndDate(rent.getDeclaredEndDate())
                .declaredStartDate(rent.getDeclaredStartDate())
                .actualEndDate(rent.getActualEndDate())
                .actualStartDate(rent.getActualStartDate())
                .createdAt(rent.getCreatedAt())
                .build();
    }
}

package pl.zzpj.repository.adapter.rent.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDataToDomain;
import pl.zzpj.repository.adapter.user.mapper.AccountMapper;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.data.rent.RentEnt;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

@AllArgsConstructor
@Component
public class RentFromDataToDomain {

    private final AccountMapper accountMapper;

    public Rent map(RentEnt rentEnt) {
        return Rent.builder()
                .id(rentEnt.getId())
                .version(rentEnt.getVersion())
                .status(rentEnt.getStatus())
                .user(accountMapper.mapToUser(rentEnt.getUser()))
                .vehicle(VehicleFromDataToDomain.map(rentEnt.getVehicle()))
                .price(rentEnt.getPrice())
                .penalty(rentEnt.getPenalty())
                .declaredStartDate(rentEnt.getDeclaredStartDate())
                .declaredEndDate(rentEnt.getDeclaredEndDate())
                .actualStartDate(rentEnt.getActualStartDate())
                .actualEndDate(rentEnt.getActualEndDate())
                .createdAt(rentEnt.getCreatedAt())
                .build();
    }
}

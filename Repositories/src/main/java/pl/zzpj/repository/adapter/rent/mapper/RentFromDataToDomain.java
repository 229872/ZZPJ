package pl.zzpj.repository.adapter.rent.mapper;

import lombok.AllArgsConstructor;
import pl.zzpj.repository.adapter.user.mapper.AccountMapper;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.data.rent.RentEnt;

@AllArgsConstructor
public class RentFromDataToDomain {

    private static AccountMapper mapper;

    public static Rent map(RentEnt rentEnt) {
        return Rent.builder()
                .id(rentEnt.getId())
                .status(rentEnt.getStatus())
                .user(mapper.mapToUser(rentEnt.getUser()))
                .vehicle(rentEnt.getVehicle())
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

package pl.zzpj.repository.adapter.rent.mapper;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.adapter.user.mapper.AccountToUserMapper;
import pl.zzpj.repository.data.rent.RentEnt;

public class RentFromDataToDomain {

    public static Rent map(RentEnt rentEnt) {
        AccountToUserMapper mapper = new AccountToUserMapper();//todo
        return Rent.builder()
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

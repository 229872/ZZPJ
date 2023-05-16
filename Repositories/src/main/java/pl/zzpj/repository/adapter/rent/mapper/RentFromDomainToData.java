package pl.zzpj.repository.adapter.rent.mapper;

import pl.zzpj.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.adapter.user.mapper.UserToAccountMapper;
import pl.zzpj.repository.data.rent.RentEnt;

public class RentFromDomainToData {
    public static RentEnt map(Rent rent) {
        UserToAccountMapper mapper = new UserToAccountMapper();
        return RentEnt.builder()
                .status(rent.getStatus())
                .user(mapper.mapToAccount(rent.getUser()))
                .vehicle(rent.getVehicle())
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

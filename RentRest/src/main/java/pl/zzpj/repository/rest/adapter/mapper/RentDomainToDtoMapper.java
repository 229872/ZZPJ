package pl.zzpj.repository.rest.adapter.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.rentModel.Rent;
import pl.zzpj.repository.rest.dto.RentDto;
import pl.zzpj.repository.rest.dto.mapper.VehicleFromDomainToDto;

@Component
@AllArgsConstructor
public class RentDomainToDtoMapper {
    private UserMapper userMapper;

    public RentDto map(Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .version(rent.getVersion())
                .status(rent.getStatus())
                .user(userMapper.mapToUserOutputDTO(rent.getUser()))
                .vehicle(VehicleFromDomainToDto.map(rent.getVehicle()))
                .price(rent.getPrice())
                .penalty(rent.getPenalty())
                .declaredStartDate(rent.getDeclaredStartDate())
                .declaredEndDate(rent.getDeclaredEndDate())
                .actualStartDate(rent.getActualStartDate())
                .actualEndDate(rent.getActualEndDate())
                .createdAt(rent.getCreatedAt())
                .build();
    }
}

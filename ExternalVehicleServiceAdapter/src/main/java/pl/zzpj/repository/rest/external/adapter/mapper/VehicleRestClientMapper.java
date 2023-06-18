package pl.zzpj.repository.rest.external.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Van;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.rest.external.dto.VehicleInputDto;

@Component
@RequiredArgsConstructor
public class VehicleRestClientMapper {
  public Vehicle vehicleInputDtoToDomain (VehicleInputDto inputDto) {
    return Van.fromApiBuilder()
            .make(inputDto.make_and_model())
            .model("model")
            .cargoCapacity("2000l")
            .build();
  }
}

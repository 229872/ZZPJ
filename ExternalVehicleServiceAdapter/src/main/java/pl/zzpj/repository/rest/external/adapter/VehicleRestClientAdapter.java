package pl.zzpj.repository.rest.external.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.ports.command.rent.RentVehiclesCommandService;
import pl.zzpj.repository.rest.external.adapter.mapper.VehicleRestClientMapper;
import pl.zzpj.repository.rest.external.api.VehicleService;
import pl.zzpj.repository.rest.external.dto.VehicleInputDto;
import pl.zzpj.repository.rest.external.exception.VehicleCreationException;

@Component
@RequiredArgsConstructor
public class VehicleRestClientAdapter implements VehicleService {

  private final RentVehiclesCommandService vehicleService;
  private final VehicleRestClientMapper vehicleRestClientMapper;

  @Override
  public void add(VehicleInputDto vehicle) {
    try {
      vehicleService.addVehicle(vehicleRestClientMapper.vehicleInputDtoToDomain(vehicle));
    } catch (Exception e) {
      throw new VehicleCreationException(e.getMessage(), e.getCause());
    }
  }
}

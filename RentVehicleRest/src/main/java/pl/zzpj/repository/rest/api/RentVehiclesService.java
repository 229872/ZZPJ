package pl.zzpj.repository.rest.api;

import pl.zzpj.repository.rest.dto.VehicleDto;

import java.util.List;
import java.util.UUID;

public interface RentVehiclesService {
    VehicleDto addVehicle(VehicleDto vehicle);
    VehicleDto updateVehicle(UUID id, VehicleDto vehicle);
    void switchAvailability(UUID id);
    void removeVehicle(UUID id);

    VehicleDto getById(UUID id);
    List<VehicleDto> getAll();
    List<VehicleDto> getAllByMake(String make);
    List<VehicleDto> getAllAvailable();

}

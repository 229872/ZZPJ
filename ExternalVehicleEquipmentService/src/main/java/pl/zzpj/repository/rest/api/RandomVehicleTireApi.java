package pl.zzpj.repository.rest.api;

import pl.zzpj.repository.rest.dto.RandomVehicleTireDto;

public interface RandomVehicleTireApi {
    void addRandomVehicleTire(RandomVehicleTireDto dto, Integer type);
}

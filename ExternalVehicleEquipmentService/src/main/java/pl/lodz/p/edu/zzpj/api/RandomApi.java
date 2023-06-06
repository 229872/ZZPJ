package pl.lodz.p.edu.zzpj.api;

import pl.lodz.p.edu.zzpj.dto.RandomDto;

public interface RandomApi {
    void addRandomVehicleTire(RandomDto dto, Integer type);
}

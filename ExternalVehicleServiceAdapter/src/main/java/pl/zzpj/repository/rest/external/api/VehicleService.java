package pl.zzpj.repository.rest.external.api;

import pl.zzpj.repository.rest.external.dto.VehicleInputDto;

public interface VehicleService {

  void add(VehicleInputDto vehicle);
}

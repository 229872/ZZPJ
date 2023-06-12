package pl.zzpj.repository.rest.api;

import pl.zzpj.repository.rest.dto.SuperDto;

public interface ExternalClient {
    SuperDto getWeatherForecastFromExternalService(double lat, double lon);
}

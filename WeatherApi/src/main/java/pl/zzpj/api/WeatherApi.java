package pl.zzpj.api;

import pl.zzpj.dto.SuperDto;

public interface WeatherApi {
    void getWeatherForecast(SuperDto dto);
}

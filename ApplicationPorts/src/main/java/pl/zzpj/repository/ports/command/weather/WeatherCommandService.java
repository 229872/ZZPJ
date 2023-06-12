package pl.zzpj.repository.ports.command.weather;

import pl.zzpj.repository.core.domain.model.weatherModel.Weather;

public interface WeatherCommandService {

    Weather getWeatherForecast(double lat, double lon);
}

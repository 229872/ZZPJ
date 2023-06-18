package pl.zzpj.repository.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.weatherModel.Weather;
import pl.zzpj.repository.ports.command.weather.WeatherCommandService;
import pl.zzpj.repository.rest.client.ExternalWeatherClient;

@Component
@AllArgsConstructor
public class WeatherExternalClientAdapter implements WeatherCommandService {

    ExternalWeatherClient weatherClient;
    SuperDtoToWeatherMapper dtoToWeatherMapper;

    @Override
    public Weather getWeatherForecast(double lat, double lon) {
        return dtoToWeatherMapper.convertSuperDtoToWeatherDomainModel(weatherClient
            .getWeatherForecastFromExternalService(lat, lon));
    }
}

package pl.zzpj.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.api.WeatherApi;
import pl.zzpj.dto.SuperDto;

@Component
@AllArgsConstructor
public class WeatherExternalClientAdapter implements WeatherApi {

    @Override
    public void getWeatherForecast(SuperDto dto) {
        System.out.println(dto.toString());
    }
}

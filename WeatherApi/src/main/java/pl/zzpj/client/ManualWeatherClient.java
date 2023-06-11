package pl.zzpj.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
@AllArgsConstructor
public class ManualWeatherClient {

    private final ExternalWeatherClient externalWeatherClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/now")
    public void getWeatherForecast() {
        externalWeatherClient.getWeatherForecastFromExternalService();
    }
}

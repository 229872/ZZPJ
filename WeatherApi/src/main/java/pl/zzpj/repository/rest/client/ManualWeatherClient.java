package pl.zzpj.repository.rest.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
@AllArgsConstructor
public class ManualWeatherClient {

    private final ExternalWeatherClient externalWeatherClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getWeatherForecast(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon) {
        externalWeatherClient.getWeatherForecastFromExternalService(lat, lon);
    }
}

package pl.zzpj.client;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zzpj.api.WeatherApi;
import pl.zzpj.dto.SuperDto;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Log
public class ExternalWeatherClient {
    private final String urlApi = "https://api.openweathermap.org/data/2.5/forecast?lat=57.75&lon=19.45&appid" +
    "=287852d62a12d9f7346899c198b3acb2&units=metric";
    private final WebClient.Builder weatherClient;
    private final WeatherApi api;

    public void getWeatherForecastFromExternalService() {
        Mono<SuperDto> dtoMono = fetchUserDataFromExternalService();
        dtoMono.doOnSuccess(
            x -> {
                api.getWeatherForecast(new SuperDto(x.cod(), x.message(), x.cnt(), x.list(), x.city()));
            }).doOnError(x -> log.warning("something")).subscribe(); //TODO HERE IN IN ANOTHER PLACE
    }

    private Mono<SuperDto> fetchUserDataFromExternalService() {
        return weatherClient.build()
            .get()
            .uri(urlApi)
            .retrieve()
            .bodyToMono(SuperDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(dto -> log.info("Successfully fetched data from external service: "
                + dto));
    }
}

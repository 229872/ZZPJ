package pl.zzpj.repository.rest.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.zzpj.repository.rest.api.ExternalClient;
import pl.zzpj.repository.rest.dto.SuperDto;
import reactor.core.publisher.Mono;

@Log
@Component
@RequiredArgsConstructor
@PropertySource("classpath:weatherApi.properties")
public class ExternalWeatherClient implements ExternalClient {

    private final WebClient.Builder weatherClient;

    @Value("${weather.api.key}")
    private String apikey;
    @Value("${weather.api.units}")
    private String units;
    @Value("${weather.api.url}")
    private String baseApiUrl;

    public SuperDto getWeatherForecastFromExternalService(double lat, double lon) {
        Mono<SuperDto> dtoMono = fetchWeatherForecastFromExternalService(lat, lon);
        return dtoMono.block(); //Blocks current thread

//        dtoMono.subscribe(
//            x -> new SuperDto(x.cod(), x.message(), x.cnt(), x.list(), x.city()),
//            err -> log.warning("Something went wrong."),
//            () -> log.info("Something went right.")
//        );

//        dtoMono.doOnSuccess(
//            x -> new SuperDto(x.cod(), x.message(), x.cnt(), x.list(), x.city()))
//            .doOnError(x -> log.warning("Something went wrong.")).subscribe();
    }

    private Mono<SuperDto> fetchWeatherForecastFromExternalService(double lat, double lon) {
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(this.baseApiUrl);
        urlBuilder.replaceQueryParam("appid", apikey);
        urlBuilder.replaceQueryParam("units", units);
        urlBuilder.replaceQueryParam("lat", lat);
        urlBuilder.replaceQueryParam("lon", lon);

        String finalUrl = urlBuilder.build().toUriString();

        return weatherClient.build()
            .get()
            .uri(finalUrl)
            .retrieve()
            .bodyToMono(SuperDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(dto -> log.info("Successfully fetched data from external service: "
                + dto));
    }
}

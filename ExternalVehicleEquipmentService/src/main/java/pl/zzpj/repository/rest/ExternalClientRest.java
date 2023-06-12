package pl.zzpj.repository.rest;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zzpj.repository.rest.api.RandomVehicleTireApi;
import pl.zzpj.repository.rest.dto.RandomVehicleTireDto;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Log
public class ExternalClientRest {
    private final String api = "https://random-data-api.com/api/commerce/random_commerce";
    private final WebClient.Builder webClientBuilder;
    private final RandomVehicleTireApi service;

    @Scheduled(fixedRateString = "${schedule.time.ms:300000}")
    public void getNewTireFromExternalService() {
        Mono<RandomVehicleTireDto> dtoMono = getDtoFromExternalService();
        dtoMono.doOnSuccess(
            x -> {
                service.addRandomVehicleTire(new RandomVehicleTireDto(x.id(), x.uid(),
                    x.color(), x.department(), x.material(), x.product_name(),
                    x.price(), x.price_string(), x.promo_code()), null); //fixme
            }).doOnError(x -> log.warning("Something went wrong.")).subscribe();
    }

    private Mono<RandomVehicleTireDto> getDtoFromExternalService() {
        return webClientBuilder.build()
            .get()
            .uri(api)
            .retrieve()
            .bodyToMono(RandomVehicleTireDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(dto -> log.info("Successfully fetched data from external service: " + dto));
    }
}

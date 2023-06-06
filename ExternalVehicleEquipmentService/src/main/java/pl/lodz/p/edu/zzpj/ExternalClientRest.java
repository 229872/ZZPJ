package pl.lodz.p.edu.zzpj;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.lodz.p.edu.zzpj.api.RandomApi;
import pl.lodz.p.edu.zzpj.dto.RandomDto;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Log
public class ExternalClientRest {
    private final String api = "https://random-data-api.com/api/commerce/random_commerce";
    private final WebClient.Builder webClientBuilder;
    private final RandomApi service;

    //    @Scheduled(fixedRateString = "${schedule.time.ms:300000}")
    public void getNewTireFromExternalService() {
        Mono<RandomDto> dtoMono = getDtoFromExternalService();
        dtoMono.doOnSuccess(
            x -> {
                service.addRandomVehicleTire(new RandomDto(x.id(), x.uid(),
                    x.color(), x.department(), x.material(), x.product_name(),
                    x.price(), x.price_string(), x.promoCode()), null); //fixme
            }).doOnError(x -> log.warning("something")).subscribe();
    }

    private Mono<RandomDto> getDtoFromExternalService() {
        return webClientBuilder.build()
            .get()
            .uri(api)
            .retrieve()
            .bodyToMono(RandomDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(dto -> log.info("Successfully fetched data from external service: " + dto));
    }
}

package pl.zzpj.repository.rest.external.client;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zzpj.repository.rest.external.api.VehicleService;
import pl.zzpj.repository.rest.external.dto.VehicleInputDto;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Log
public class ExternalClient {
    private final String api = "https://random-data-api.com/api/commerce/random_vehicle";
    private final WebClient.Builder webClientBuilder;
    private final VehicleService service;

    @Scheduled(fixedRateString = "${schedule.time.ms:300000}")
    public void getNewTireFromExternalService() {
        Mono<VehicleInputDto> dtoMono = getDtoFromExternalService();
        dtoMono.doOnSuccess(
                vehicle -> {
                    service.add(new VehicleInputDto(vehicle.id(), vehicle.uid(),
                            vehicle.color(), vehicle.make_and_model(), vehicle.color(), vehicle.transmission(), vehicle.drive_type(), vehicle.fuel_type(), vehicle.car_type(), vehicle.car_options(), vehicle.specs(), vehicle.doors(), vehicle.mileage(), vehicle.kilometrage(), vehicle.license_plate()));
                }).doOnError(vehicle -> log.warning("something")).subscribe();
    }

    private Mono<VehicleInputDto> getDtoFromExternalService() {
        return webClientBuilder.build()
                .get()
                .uri(api)
                .retrieve()
                .bodyToMono(VehicleInputDto.class)
                .doOnError(e -> log.warning("Could not fetch data from external service"))
                .doOnSuccess(dto -> log.info("Successfully fetched data from external service: " + dto));
    }
}

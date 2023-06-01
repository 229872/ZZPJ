package pl.zzpj.repository.rest.external.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zzpj.repository.rest.external.api.UserService;
import pl.zzpj.repository.rest.external.dto.AddressInputDto;
import pl.zzpj.repository.rest.external.dto.PersonalDataInputDto;
import pl.zzpj.repository.rest.external.dto.UserInputDto;
import reactor.core.publisher.Mono;


@Component
@Log
@RequiredArgsConstructor
public class UserRestClient {

  @Value("${client.api.user.link:https://random-data-api.com/api/users/random_user}")
  private String userApi;
  @Value("${client.api.address.link:https://random-data-api.com/api/address/random_address}")
  private String addressApi;

  private final WebClient.Builder webClientBuilder;
  private final UserService userService;


  @Scheduled(fixedRateString = "${schedule.time.ms:300000}")
  public void getNewClientFromExternalService() {
    Mono<AddressInputDto> addressMono = fetchClientAddressFromExternalService();
    Mono<PersonalDataInputDto> userMono = fetchUserDataFromExternalService();


    Mono.zip(userMono, addressMono)
            .doOnSuccess(tuple -> {
              PersonalDataInputDto personalData = tuple.getT1();
              AddressInputDto address = tuple.getT2();
              UserInputDto user = new UserInputDto(personalData, address);
              userService.add(user);
              log.info("Successfully saved user into database");
            })
            .doOnError(e -> log.warning("Could not save user into database"))
            .subscribe();

  }

  private Mono<AddressInputDto> fetchClientAddressFromExternalService() {
    return webClientBuilder.build()
            .get()
            .uri(addressApi)
            .retrieve()
            .bodyToMono(AddressInputDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(address -> log.info("Successfully fetched address data from external service: "
                    + address));
  }

  private Mono<PersonalDataInputDto> fetchUserDataFromExternalService() {
    return webClientBuilder.build()
            .get()
            .uri(userApi)
            .retrieve()
            .bodyToMono(PersonalDataInputDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(user -> log.info("Successfully fetched data from external service: "
                    + user));
  }
}

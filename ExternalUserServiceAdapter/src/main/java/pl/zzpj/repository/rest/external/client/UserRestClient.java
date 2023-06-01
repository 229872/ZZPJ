package pl.zzpj.repository.rest.external.client;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zzpj.repository.rest.external.api.UserService;
import pl.zzpj.repository.rest.external.dto.UserInputDto;
import pl.zzpj.repository.rest.external.exception.UserCreationException;
import reactor.core.publisher.Mono;

@Component
@Log
public class UserRestClient {

  @Value("${client.api.link:https://random-data-api.com/api/users/random_user}")
  private String api;

  private final WebClient.Builder webClientBuilder = WebClient.builder();

  private final UserService userService;

  public UserRestClient(UserService userService) {
    this.userService = userService;
  }

  @Scheduled(fixedRateString = "${schedule.time.ms:10000}")
  public void getNewClientFromExternalService() {
    webClientBuilder.build()
            .get()
            .uri(api)
            .retrieve()
            .bodyToMono(UserInputDto.class)
            .doOnError(e -> log.warning("Could not fetch data from external service"))
            .doOnSuccess(user -> {
              log.info("Successfully fetched data from external service: " + user);
              userService.add(user);
              log.info("Successfully saved user in database");
            })
            .doOnError(e -> log.warning("Could not save user into database"))
            .subscribe();
  }
}

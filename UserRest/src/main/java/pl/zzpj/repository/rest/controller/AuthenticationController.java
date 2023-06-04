package pl.zzpj.repository.rest.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.repository.rest.api.UserService;
import pl.zzpj.repository.rest.dto.input.AddressInputDTO;
import pl.zzpj.repository.rest.dto.input.CredentialsDto;
import pl.zzpj.repository.rest.dto.input.PersonInputDTO;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.exception.UserAuthenticationException;
import pl.zzpj.repository.rest.exception.UserCreationException;

import java.time.LocalDateTime;
import java.time.Month;

import static pl.zzpj.repository.utils.security.RoleName.ADMIN;
import static pl.zzpj.repository.utils.security.RoleName.GUEST;

@RestController
@RequestMapping(value = "/users/auth", produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
})
@RequiredArgsConstructor
@Log
public class AuthenticationController {

  private final UserService userService;

  @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
  @RolesAllowed(GUEST)
  public ResponseEntity<?> authenticate(@RequestBody @NotNull @Valid CredentialsDto credentials) {
    try {
      String token = userService.authenticate(credentials);
      return ResponseEntity.ok(token);

    } catch (UserAuthenticationException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }












  @PostConstruct
  private void initAdmin() {
    try {
      log.info("Creating admin");
      AddressInputDTO address = AddressInputDTO.builder()
              .city("London")
              .country("England")
              .streetName("Sea")
              .streetNumber("2")
              .buildingNumber(30)
              .postalCode("40-050")
              .build();


      PersonInputDTO person = new PersonInputDTO("John", "Doe",
              "Male", "1967-12-29", address);

      userService.createUser(new UserInputDTO(
              "admin",
              "Kochamzzpj!",
              "example123@example123.example",
              person, "997", "555", "374927342", ADMIN, null, "pl"
      ));

    }  catch (UserCreationException e) {
      log.severe("Admin couldn't be created");
    }
  }
}

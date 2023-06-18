package pl.zzpj.repository.rest.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.api.UserService;
import pl.zzpj.repository.rest.dto.input.*;
import pl.zzpj.repository.rest.dto.output.ConfirmStatus;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserAuthenticationException;
import pl.zzpj.repository.rest.exception.UserCreationException;
import pl.zzpj.repository.rest.exception.UserNotFoundException;


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


  @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
  @RolesAllowed(GUEST)
  public ResponseEntity<?> register(@RequestBody @NotNull @Valid UserRegisterDTO userRegister) {
    try {
      UserOutputDTO user = userService.registerUser(userRegister);
      return ResponseEntity.status(HttpStatus.CREATED).body(user);

    } catch (UserCreationException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/confirm")
  @RolesAllowed(GUEST)
  public ResponseEntity<?> confirmAccount(@RequestParam String token) {
    try {
      userService.confirmAccount(token);
      return ResponseEntity.ok(new ConfirmStatus("Account successfully verified"));
    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.GONE).body(new ConfirmStatus(e.getMessage()));
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
              "Bri'ish", "1967-12-29", address);

      userService.createUser(new UserInputDTO(
              "admin",
              "Kochamzzpj!",
              "soroj32379@onlcool.com",
              person, "997", "555", "374927342", ADMIN, null, "pl"
      ));

    }  catch (UserCreationException e) {
      log.severe("Admin couldn't be created");
    }
  }
}

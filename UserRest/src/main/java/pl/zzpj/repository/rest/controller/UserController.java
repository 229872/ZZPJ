package pl.zzpj.repository.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.api.UserService;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping(produces = {
          MediaType.APPLICATION_JSON_VALUE,
          MediaType.APPLICATION_XML_VALUE
  })
  public List<UserOutputDTO> getAll() {
    return userService.getAllUsers();
  }

  @GetMapping(value = "/id/{id}", produces = {
          MediaType.APPLICATION_JSON_VALUE,
          MediaType.APPLICATION_XML_VALUE
  })
  public ResponseEntity<?> getById(@PathVariable UUID id) {
    try {
      UserOutputDTO foundUser = userService.getUserById(id).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @GetMapping(value = "/login/{login}", produces = {
          MediaType.APPLICATION_JSON_VALUE,
          MediaType.APPLICATION_XML_VALUE
  })
  public ResponseEntity<?> getByLogin(@PathVariable String login) {
    try {
      UserOutputDTO foundUser = userService.getUserByLogin(login).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @GetMapping(value = "/email/{email}", produces = {
          MediaType.APPLICATION_JSON_VALUE,
          MediaType.APPLICATION_XML_VALUE
  })
  public ResponseEntity<?> getByEmail(@PathVariable String email) {
    try {
      UserOutputDTO foundUser = userService.getUserByEmail(email).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody @Valid UserInputDTO user) {
    try {
      UserOutputDTO newUser = userService.createUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    } catch (UserCreationException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
  }

}

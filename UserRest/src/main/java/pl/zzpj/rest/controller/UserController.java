package pl.zzpj.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.rest.api.UserService;
import pl.zzpj.rest.dto.input.UserInputDTO;
import pl.zzpj.rest.dto.output.UserOutputDTO;
import pl.zzpj.rest.exception.UserCreationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public List<UserOutputDTO> getAll() {
    return userService.getAllUsers();
  }

  @GetMapping("/users/id/{id}")
  public ResponseEntity getById(@PathVariable UUID id) {
    try {
      UserOutputDTO foundUser = userService.getUserById(id).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @GetMapping("/users/login/{login}")
  public ResponseEntity getByLogin(@PathVariable String login) {
    try {
      UserOutputDTO foundUser = userService.getUserByLogin(login).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @GetMapping("/users/email/{email}")
  public ResponseEntity getByEmail(@PathVariable String email) {
    try {
      UserOutputDTO foundUser = userService.getUserByEmail(email).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(foundUser);

    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping("/users")
  public ResponseEntity create(@RequestBody @Valid UserInputDTO user) {
    try {
      UserOutputDTO newUser = userService.createUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    } catch (UserCreationException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
  }

}

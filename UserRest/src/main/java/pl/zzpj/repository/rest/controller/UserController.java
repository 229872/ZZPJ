package pl.zzpj.repository.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
@RequestMapping(value = "/users", produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE
})
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<UserOutputDTO> getAll() {
    return userService.getAllUsers();
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<?> getById(@PathVariable UUID id) {
    return userService.getUserById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

  }

  @GetMapping("/login/{login}")
  public ResponseEntity<?> getByLogin(@PathVariable String login) {
    return userService.getUserByLogin(login)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<?> getByEmail(@PathVariable String email) {
    return userService.getUserByEmail(email)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> create(@RequestBody @Valid UserInputDTO user) {
    try {
      UserOutputDTO newUser = userService.createUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    } catch (UserCreationException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
  }

}

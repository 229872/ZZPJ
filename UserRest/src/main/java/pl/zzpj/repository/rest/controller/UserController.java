package pl.zzpj.repository.rest.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.api.UserService;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.input.UserUpdateDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;
import pl.zzpj.repository.rest.exception.UserNotFoundException;
import pl.zzpj.repository.rest.exception.UserUpdateException;

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
  public ResponseEntity<?> create(@RequestBody @NotNull @Valid UserInputDTO user) {
    try {
      UserOutputDTO newUser = userService.createUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    } catch (UserCreationException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
  }

  //todo
  @PutMapping(path = "/id/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateUser(@PathVariable UUID id,
                                      @RequestBody @NotNull @Valid UserUpdateDTO user) {
    try {
      UserOutputDTO updatedUser = userService.updateUser(id, null);
      return ResponseEntity.ok(updatedUser);

    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (UserCreationException | UserUpdateException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping(path = "/id/{id}/archive")
  public ResponseEntity<?> archiveUser(@PathVariable UUID id) {
    try {
      UserOutputDTO updatedUser = userService.archiveUser(id);
      return ResponseEntity.ok(updatedUser);

    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (UserUpdateException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping(path = "/id/{id}/block")
  public ResponseEntity<?> blockUser(@PathVariable UUID id) {
    try {
      UserOutputDTO updatedUser = userService.blockUser(id);
      return ResponseEntity.ok(updatedUser);

    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (UserUpdateException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping(path = "/id/{id}/unblock")
  public ResponseEntity<?> unblockUser(@PathVariable UUID id) {
    try {
      UserOutputDTO updatedUser = userService.unblockUser(id);
      return ResponseEntity.ok(updatedUser);

    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (UserUpdateException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PutMapping(path = "/id/{id}/role/{role}")
  public ResponseEntity<?> changeRole(@PathVariable UUID id, @PathVariable String role) {
    try {
      UserOutputDTO updatedUser = userService.changeRole(id, role);
      return ResponseEntity.ok(updatedUser);

    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (UserUpdateException | UserCreationException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}

package pl.zzpj.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.rest.api.UserService;
import pl.zzpj.rest.dto.input.UserInputDTO;
import pl.zzpj.rest.dto.output.UserOutputDTO;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public List<UserOutputDTO> getAll() {
    return userService.getAllUsers();
  }

  @PostMapping("/users")
  public UserOutputDTO create(@RequestBody @Valid UserInputDTO user) {
    return userService.createUser(user);
  }

}

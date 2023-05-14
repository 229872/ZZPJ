package pl.zzpj.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.rest.api.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping(path = "/users")
  public List<User> getAll() {
    return userService.getAllUsers();
  }

}

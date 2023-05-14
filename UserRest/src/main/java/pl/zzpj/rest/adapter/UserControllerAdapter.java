package pl.zzpj.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.query.user.UserQueryServicePort;
import pl.zzpj.rest.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserControllerAdapter implements UserService {
  private final UserQueryServicePort userService;
  //fixme needs map to dto
  @Override
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return userService.getUserById(id);
  }
}

package pl.zzpj.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.clientModel.User;
import pl.zzpj.rest.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserControllerAdapter implements UserService {

  @Override
  public List<User> getAllUsers() {
    return null;
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return Optional.empty();
  }
}

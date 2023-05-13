package pl.zzpj.rest.api;

import pl.zzpj.core.domain.model.clientModel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
  List<User> getAllUsers();
  Optional<User> getUserById(UUID id);
}

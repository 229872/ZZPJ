package pl.zzpj.ports.query.user;

import pl.zzpj.core.domain.model.userModel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserQueryServicePort {
  List<User> getAllUsers();
  Optional<User> getUserById(UUID id);
}

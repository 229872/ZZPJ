package pl.zzpj.ports.query.user;

import pl.zzpj.core.domain.model.userModel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserQueryRepositoryPort {
  List<User> getAllUsers();
  Optional<User> getUserById(UUID id);
  Optional<User> getUserByLogin(String login);
  Optional<User> getUserByEmail(String email);
}

package pl.zzpj.ports.command.user;

import pl.zzpj.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.core.domain.model.userModel.User;
import java.util.UUID;

public interface UserCommandRepositoryPort {
  User add(User user) throws UserServiceCreateException;
  User update(UUID id, User user);
  void remove(UUID id);
}

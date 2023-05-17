package pl.zzpj.repository.ports.command.user;

import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.util.UUID;

public interface UserCommandServicePort {
  User add(User user) throws UserServiceCreateException;
  User update(UUID id, User user);
  void remove(User user);
}

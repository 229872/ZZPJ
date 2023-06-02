package pl.zzpj.repository.ports.command.user;

import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceDeleteException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.util.UUID;

public interface UserCommandRepositoryPort {
  User add(User user) throws UserServiceCreateException;
  User update(User user) throws UserServiceUpdateException;
  void delete(User user) throws UserServiceDeleteException;
}

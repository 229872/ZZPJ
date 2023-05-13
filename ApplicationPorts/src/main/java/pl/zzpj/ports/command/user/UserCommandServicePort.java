package pl.zzpj.ports.command.user;

import pl.zzpj.core.domain.model.clientModel.User;

import java.util.UUID;

public interface UserCommandServicePort {
  User add(User user);
  User update(UUID id, User user);
  void remove(User user);
}

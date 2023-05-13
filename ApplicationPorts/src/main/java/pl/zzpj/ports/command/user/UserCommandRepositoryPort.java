package pl.zzpj.ports.command.user;

import pl.zzpj.core.domain.model.clientModel.User;
import java.util.UUID;

public interface UserCommandRepositoryPort {
  User add(User user);
  User update(UUID id, User user);
  void remove(UUID id);
}

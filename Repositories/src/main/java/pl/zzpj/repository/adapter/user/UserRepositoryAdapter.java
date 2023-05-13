package pl.zzpj.repository.adapter.user;

import lombok.AllArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.clientModel.User;
import pl.zzpj.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.repository.adapter.user.mapper.AccountToUserMapper;
import pl.zzpj.repository.adapter.user.mapper.UserToAccountMapper;
import pl.zzpj.repository.api.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserQueryRepositoryPort, UserCommandRepositoryPort {
  private final AccountRepository accountRepository;
  private final AccountToUserMapper accountToUserMapper;
  private final UserToAccountMapper userToAccountMapper;


  @Override
  public List<User> getAllUsers() {
    throw new NotYetImplementedException();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    throw new NotYetImplementedException();
  }

  @Override
  public User add(User user) {
    throw new NotYetImplementedException();
  }

  @Override
  public User update(UUID id, User user) {
    throw new NotYetImplementedException();
  }

  @Override
  public void remove(UUID id) {
    throw new NotYetImplementedException();
  }
}

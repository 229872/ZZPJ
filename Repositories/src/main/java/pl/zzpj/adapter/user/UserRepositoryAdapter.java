package pl.zzpj.adapter.user;

import lombok.AllArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.adapter.user.mapper.AccountToUserMapper;
import pl.zzpj.adapter.user.mapper.UserToAccountMapper;
import pl.zzpj.api.AccountRepository;

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
    return accountRepository.findAll().stream()
            .map(accountToUserMapper::mapToUser)
            .toList();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return accountRepository.findById(id).map(accountToUserMapper::mapToUser);
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

package pl.zzpj.repository.adapter.user;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceDeleteException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.repository.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.repository.adapter.user.mapper.AccountMapper;
import pl.zzpj.repository.api.AccountRepository;
import pl.zzpj.repository.data.user.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
@Log
public class UserRepositoryAdapter implements UserQueryRepositoryPort, UserCommandRepositoryPort {
  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;


  @Override
  public List<User> getAllUsers() {
    return accountRepository.findAll().stream()
            .map(accountMapper::mapToUser)
            .toList();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return accountRepository.findById(id).map(accountMapper::mapToUser);
  }

  @Override
  public Optional<User> getUserByLogin(String login) {
    return accountRepository.findByLogin(login).map(accountMapper::mapToUser);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return accountRepository.findByEmail(email).map(accountMapper::mapToUser);
  }

  @Override
  public User add(User user) throws UserServiceCreateException {
    try {
      Account account = accountRepository.save(accountMapper.mapToAccount(user));
      return accountMapper.mapToUser(account);

    } catch (DataIntegrityViolationException e) {
      throw new UserServiceCreateException(e.getMessage(), e);
    }
  }

  @Override
  public User update(User user) throws UserServiceUpdateException {
    try {
      log.info("Update: " + user);
      Account account = accountRepository.save(accountMapper.mapToAccount(user));
      return accountMapper.mapToUser(account);
      
    } catch (DataIntegrityViolationException e) {
      log.warning("Sth gone wrong: " + e);
      throw new UserServiceUpdateException(e.getMessage(), e);
    }
  }

  @Override
  public void delete(User user) throws UserServiceDeleteException {
    try {
      Account account = accountMapper.mapToAccount(user);
      accountRepository.delete(account);

    } catch (DataIntegrityViolationException e) {
      throw new UserServiceDeleteException(e.getMessage(), e);
    }
  }
}

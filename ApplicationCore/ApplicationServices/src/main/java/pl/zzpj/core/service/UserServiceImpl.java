package pl.zzpj.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.ports.command.user.UserCommandServicePort;
import pl.zzpj.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.ports.query.user.UserQueryServicePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserQueryServicePort, UserCommandServicePort {
  private final UserQueryRepositoryPort userQueryRepositoryPort;
  private final UserCommandRepositoryPort userCommandRepositoryPort;
  @Override
  public List<User> getAllUsers() {
    return userQueryRepositoryPort.getAllUsers();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return userQueryRepositoryPort.getUserById(id);
  }

  @Override
  public User add(User user) {
    return userCommandRepositoryPort.add(user);
  }

  @Override
  public User update(UUID id, User user) {
    return null;
  }

  @Override
  public void remove(User user) {

  }
}

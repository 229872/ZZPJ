package pl.zzpj.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.user.UserCommandServicePort;
import pl.zzpj.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.ports.query.user.UserQueryServicePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserQueryServicePort, UserCommandServicePort {
  private final UserQueryRepositoryPort userRepository;
  @Override
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return userRepository.getUserById(id);
  }

  @Override
  public User add(User user) {
    return null;
  }

  @Override
  public User update(UUID id, User user) {
    return null;
  }

  @Override
  public void remove(User user) {

  }
}

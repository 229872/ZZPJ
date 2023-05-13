package pl.zzpj.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.model.clientModel.User;
import pl.zzpj.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.ports.query.user.UserQueryServicePort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserQueryServicePort {
  private final UserQueryRepositoryPort userRepository;
  @Override
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }

  @Override
  public Optional<User> getUserById(UUID id) {
    return userRepository.getUserById(id);
  }
}

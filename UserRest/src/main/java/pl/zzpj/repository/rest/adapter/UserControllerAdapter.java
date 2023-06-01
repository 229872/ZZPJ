package pl.zzpj.repository.rest.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.ports.command.user.UserCommandServicePort;
import pl.zzpj.repository.ports.query.user.UserQueryServicePort;
import pl.zzpj.repository.rest.adapter.mapper.UserMapper;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;
import pl.zzpj.repository.rest.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserControllerAdapter implements UserService {
  private final UserQueryServicePort userQueryServicePort;
  private final UserCommandServicePort userCommandServicePort;
  private final UserMapper userMapper;

  @Override
  public List<UserOutputDTO> getAllUsers() {
    return userQueryServicePort.getAllUsers().stream()
            .map(userMapper::mapToUserOutputDTO)
            .toList();
  }

  @Override
  public Optional<UserOutputDTO> getUserById(UUID id) {
    return userQueryServicePort.getUserById(id).map(userMapper::mapToUserOutputDTO);
  }

  @Override
  public Optional<UserOutputDTO> getUserByLogin(String login) {
    return userQueryServicePort.getUserByLogin(login).map(userMapper::mapToUserOutputDTO);
  }

  @Override
  public Optional<UserOutputDTO> getUserByEmail(String email) {
    return userQueryServicePort.getUserByEmail(email).map(userMapper::mapToUserOutputDTO);
  }

  @Override
  public UserOutputDTO createUser(UserInputDTO user) throws UserCreationException {
    try {
      User newUser = userCommandServicePort.add(userMapper.mapToDomainModelUser(user));
      return userMapper.mapToUserOutputDTO(newUser);

    } catch (UserServiceCreateException e) {
      throw new UserCreationException(e.getMessage(), e);
    }
  }
}

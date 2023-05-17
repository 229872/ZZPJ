package pl.zzpj.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.ports.command.user.UserCommandServicePort;
import pl.zzpj.ports.query.user.UserQueryServicePort;
import pl.zzpj.rest.adapter.mapper.UserMapper;
import pl.zzpj.rest.api.UserService;
import pl.zzpj.rest.dto.input.UserInputDTO;
import pl.zzpj.rest.dto.output.UserOutputDTO;
import pl.zzpj.rest.exception.UserCreationException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
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

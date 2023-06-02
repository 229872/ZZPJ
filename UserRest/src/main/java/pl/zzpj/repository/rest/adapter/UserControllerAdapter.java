package pl.zzpj.repository.rest.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.ports.command.user.UserCommandServicePort;
import pl.zzpj.repository.ports.query.user.UserQueryServicePort;
import pl.zzpj.repository.rest.adapter.mapper.RestRoleMapper;
import pl.zzpj.repository.rest.adapter.mapper.UserMapper;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;
import pl.zzpj.repository.rest.api.UserService;
import pl.zzpj.repository.rest.exception.UserNotFoundException;
import pl.zzpj.repository.rest.exception.UserUpdateException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserControllerAdapter implements UserService {
  private final UserQueryServicePort userQueryServicePort;
  private final UserCommandServicePort userCommandServicePort;
  private final UserMapper userMapper;
  private final RestRoleMapper roleMapper;

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

  @Override
  public UserOutputDTO updateUser(UUID id, UserInputDTO user) throws UserCreationException,
          UserUpdateException, UserNotFoundException {
    try {
      User updated = userCommandServicePort.update(id,userMapper.mapToDomainModelUser(user));
      return userMapper.mapToUserOutputDTO(updated);

    } catch (UserCreationException e) {
      throw new UserCreationException(e.getMessage(), e);
    } catch (UserServiceUpdateException e) {
      throw new UserUpdateException(e.getMessage(), e);
    } catch (UserServiceNotFoundException e) {
      throw new UserNotFoundException(e.getMessage(), e);
    }
  }

  @Override
  public UserOutputDTO archiveUser(UUID id) throws UserUpdateException, UserNotFoundException {
    try {
      User archived = userCommandServicePort.archive(id);
      return userMapper.mapToUserOutputDTO(archived);

    } catch (UserServiceUpdateException e) {
      throw new UserUpdateException(e.getMessage(), e);
    } catch (UserServiceNotFoundException e) {
      throw new UserNotFoundException(e.getMessage(), e);
    }
  }

  @Override
  public UserOutputDTO blockUser(UUID id) throws UserUpdateException, UserNotFoundException {
    try {
      User blocked = userCommandServicePort.block(id);
      return userMapper.mapToUserOutputDTO(blocked);

    } catch (UserServiceUpdateException e) {
      throw new UserUpdateException(e.getMessage(), e);
    } catch (UserServiceNotFoundException e) {
      throw new UserNotFoundException(e.getMessage(), e);
    }
  }

  @Override
  public UserOutputDTO unblockUser(UUID id) throws UserUpdateException, UserNotFoundException {
    try {
      User unblocked = userCommandServicePort.unblock(id);
      return userMapper.mapToUserOutputDTO(unblocked);

    } catch (UserServiceUpdateException e) {
      throw new UserUpdateException(e.getMessage(), e);
    } catch (UserServiceNotFoundException e) {
      throw new UserNotFoundException(e.getMessage(), e);
    }
  }

  @Override
  public UserOutputDTO changeRole(UUID id, String newRole) throws UserUpdateException, UserCreationException,
          UserNotFoundException {
    try {
      User changed = userCommandServicePort.changeRole(id, roleMapper.mapToUserRole(newRole));
      return userMapper.mapToUserOutputDTO(changed);

    } catch (UserServiceUpdateException e) {
      throw new UserUpdateException(e.getMessage(), e);
    } catch (UserServiceNotFoundException e) {
      throw new UserNotFoundException(e.getMessage(), e);
    }
  }
}

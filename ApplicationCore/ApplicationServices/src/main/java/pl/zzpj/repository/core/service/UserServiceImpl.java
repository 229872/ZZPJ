package pl.zzpj.repository.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.core.domain.model.userModel.UserRole;
import pl.zzpj.repository.core.domain.model.userModel.UserState;
import pl.zzpj.repository.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.repository.ports.command.user.UserCommandServicePort;
import pl.zzpj.repository.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.repository.ports.query.user.UserQueryServicePort;

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
  public Optional<User> getUserByLogin(String login) {
    return userQueryRepositoryPort.getUserByLogin(login);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return userQueryRepositoryPort.getUserByEmail(email);
  }

  @Override
  public User add(User user) throws UserServiceCreateException {
    return userCommandRepositoryPort.add(user);
  }

  @Override
  public User update(UUID id, User user) throws UserServiceNotFoundException, UserServiceUpdateException {
    User foundUser = userQueryRepositoryPort.getUserById(id)
            .orElseThrow(() -> new UserServiceNotFoundException("User not found"));

    if (!isUserArchivalOrNotVerified(foundUser)) {
      foundUser.update(user);
      return userCommandRepositoryPort.update(foundUser);
    } else {
      throw new UserServiceUpdateException("Can't update archival or not verified user");
    }

  }

  @Override
  public User archive(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException {
    User user = userQueryRepositoryPort.getUserById(id)
            .orElseThrow(() -> new UserServiceNotFoundException("User not found"));
    if (!user.getUserState().equals(UserState.NOT_VERIFIED)) {
      user.setUserState(UserState.ARCHIVAL);
      return userCommandRepositoryPort.update(user);
    } else {
      throw new UserServiceUpdateException("Can't archive not verified user");
    }
  }

  @Override
  public User block(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException {
    User user = userQueryRepositoryPort.getUserById(id)
            .orElseThrow(() -> new UserServiceNotFoundException("User not found"));

    if (user.getUserState().equals(UserState.ACTIVE)) {
      user.setUserState(UserState.BLOCKED);
      return userCommandRepositoryPort.update(user);
    } else {
      throw new UserServiceUpdateException("Not active user can't be blocked");
    }
  }

  @Override
  public User unblock(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException {
    User user = userQueryRepositoryPort.getUserById(id)
            .orElseThrow(() -> new UserServiceNotFoundException("User not found"));

    if (user.getUserState().equals(UserState.BLOCKED)) {
      user.setUserState(UserState.ACTIVE);
      return userCommandRepositoryPort.update(user);
    } else {
      throw new UserServiceUpdateException("Not blocked user can't be activated");
    }
  }

  @Override
  public User changeRole(UUID id, UserRole newRole) throws UserServiceNotFoundException, UserServiceUpdateException {
    User user = userQueryRepositoryPort.getUserById(id)
            .orElseThrow(() -> new UserServiceNotFoundException("User not found"));

    if (canChangeRole(user, newRole)) {
      user.setUserRole(newRole);
      return userCommandRepositoryPort.update(user);
    } else {
      throw new UserServiceUpdateException("User is not active or you are trying to change role for guest or" +
              " role is already assigned");
    }
  }

  private boolean canChangeRole(User user, UserRole newRole) {
    return user.getUserState().equals(UserState.ACTIVE) &&
            !(newRole.equals(user.getUserRole()) || newRole.equals(UserRole.GUEST));

  }

  private boolean isUserArchivalOrNotVerified(User user) {
    return user.getUserState().equals(UserState.NOT_VERIFIED)
            || user.getUserState().equals(UserState.ARCHIVAL);
  }

}

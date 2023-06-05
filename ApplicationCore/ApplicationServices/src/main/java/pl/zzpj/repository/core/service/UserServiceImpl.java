package pl.zzpj.repository.core.service;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.exception.user.auth.AuthenticationException;
import pl.zzpj.repository.core.domain.model.userModel.*;
import pl.zzpj.repository.ports.command.user.EmailCommandPort;
import pl.zzpj.repository.ports.command.user.UserCommandRepositoryPort;
import pl.zzpj.repository.ports.command.user.UserCommandServicePort;
import pl.zzpj.repository.ports.query.user.UserQueryRepositoryPort;
import pl.zzpj.repository.ports.query.user.UserQueryServicePort;
import pl.zzpj.repository.utils.security.CryptUtils;
import pl.zzpj.repository.utils.security.JtwUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log
public class UserServiceImpl implements UserQueryServicePort, UserCommandServicePort {

  @Value("${authentication.failure.tolerance.tries:2}")
  private Integer authenticationFailAttempts;
  @Value("${account.blockade.time.seconds:180}")
  private Integer accountBlockadeTimeInSeconds;

  private final UserQueryRepositoryPort userQueryRepositoryPort;
  private final UserCommandRepositoryPort userCommandRepositoryPort;
  private final EmailCommandPort emailCommandPort;
  private final JtwUtils jwtUtils;
  private final CryptUtils cryptUtils;
  private final HttpServletRequest request;

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
  public User update(UUID id, UserUpdateData user) throws UserServiceNotFoundException, UserServiceUpdateException {
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
      emailCommandPort.sendEmailWithInfoAboutBlockingAccount(user.getEmail(), user.getLocale());
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
      emailCommandPort.sendEmailWithInfoAboutActivatingAccount(user.getEmail(), user.getLocale());
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

  @Override
  public String authenticate(String login, String password) throws AuthenticationException {
    try {
      User user = userQueryRepositoryPort.getUserByLogin(login)
              .orElseThrow(() -> new UserServiceNotFoundException("User not found"));

      validateIfCanAuthenticate(user, password);
      String token = jwtUtils.generateToken(login, user.getUserRole().name());

      if (user.getUserRole().equals(UserRole.ADMIN)) {
        emailCommandPort.sendEmailAboutAdminSession(user.getEmail(), user.getLocale(), request.getRemoteAddr());
      }

      updateUserAuthenticationInformationIfAuthenticationCorrect(user);
      return token;

    } catch (UserServiceNotFoundException e) {
      throw new AuthenticationException("Wrong credentials");
    }
  }

  @Override
  public User register(User user) throws UserServiceCreateException {


    User added = add(user);
    String token = jwtUtils.generateConfirmationToken(added.getLogin());
    emailCommandPort.sendEmailWithAccountConfirmationLink(added.getEmail(),
            added.getLocale(), token, added.getLogin());

    return added;
  }

  @Override
  public void confirmUser(String token) throws UserServiceNotFoundException {
    try {
      Claims claims = jwtUtils.parseJWT(token).getBody();
      String login = claims.getSubject();
      User user = userQueryRepositoryPort.getUserByLogin(login)
              .orElseThrow();
      user.setUserState(UserState.ACTIVE);
      userCommandRepositoryPort.update(user);
    } catch (Exception e) {
      throw new UserServiceNotFoundException("Token expired. Create new user");
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

  private void validateIfCanAuthenticate(User user, String password) throws AuthenticationException {
    try {
      checkIfCanAuthenticate(user);
      validateCredentials(user, password);
    } catch (AuthenticationException e) {
      log.info("Authentication exception: " + e.getMessage());
      updateUserAuthenticationInformationIfAuthenticationFailed(user);
      throw e;
    }
  }

  private void validateCredentials(User user, String password) throws AuthenticationException {
    if (!cryptUtils.verifyPassword(password, user.getPassword())) {
      throw new AuthenticationException("Wrong credentials");
    }
  }

  private void checkIfCanAuthenticate(User user) throws AuthenticationException {
    if (!user.getUserState().equals(UserState.ACTIVE)) {
      throw new AuthenticationException("Account is not active");
    }
  }

  private void updateUserAuthenticationInformationIfAuthenticationFailed(User user) {
    try {
      User userWithSessionData = setUserAuthenticationInformationIfFailed(user);
      userCommandRepositoryPort.update(userWithSessionData);

    } catch (UserServiceUpdateException e) {
      log.warning("Sth went wrong with saving account metadata");
    }
  }

  private User setUserAuthenticationInformationIfFailed(User user) {
    UserAccountInformations data = user.getUserAccountInformations();

    data.setLastFailedAuthenticationTime(LocalDateTime.now());
    data.setLastFailedLoginIpAddress(request.getRemoteAddr());

    tryBlockAccount(user);
    return user;
  }

  private User setUserAuthenticationInformationIfCorrect(User user) {
    String remoteAddress = request.getRemoteAddr();
    UserAccountInformations data = UserAccountInformations.builder()
            .failedLoginCounter(0)
            .lastCorrectAuthenticationTime(LocalDateTime.now())
            .lastLoginIpAddress(remoteAddress)
            .build();

    user.setUserAccountInformations(data);
    return user;
  }

  private void updateUserAuthenticationInformationIfAuthenticationCorrect(User user) {
    try {
      User userWithSessionData = setUserAuthenticationInformationIfCorrect(user);
      userCommandRepositoryPort.update(userWithSessionData);

    } catch (UserServiceUpdateException e) {
      log.warning("Sth went wrong with saving account metadata");
    }
  }

  private void tryBlockAccount(User user) {
    UserAccountInformations userAccountInformations = user.getUserAccountInformations();

    if (user.getUserState().equals(UserState.ACTIVE)
            && userAccountInformations.getFailedLoginCounter().equals(authenticationFailAttempts)) {

      userAccountInformations.setFailedLoginCounter(0);

      LocalDateTime blockadeStart = LocalDateTime.now();
      userAccountInformations.setBlockadeStart(blockadeStart);
      userAccountInformations.setBlockadeEnd(blockadeStart.plusSeconds(accountBlockadeTimeInSeconds));
      user.setUserState(UserState.BLOCKED);
      emailCommandPort.sendEmailWithInfoAboutBlockingAccount(user.getEmail(), user.getLocale());
      // set timer
    } else if (user.getUserState().equals(UserState.ACTIVE)) {
      userAccountInformations.setFailedLoginCounter(userAccountInformations.getFailedLoginCounter() + 1);
    }
  }

}

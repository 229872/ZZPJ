package pl.zzpj.repository.ports.command.user;

import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.core.domain.model.userModel.UserRole;
import pl.zzpj.repository.core.domain.model.userModel.UserUpdateData;

import java.util.UUID;

public interface UserCommandServicePort {
  User add(User user) throws UserServiceCreateException;
  User update(UUID id, UserUpdateData user) throws UserServiceNotFoundException, UserServiceUpdateException;
  User archive(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException;
  User block(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException;
  User unblock(UUID id) throws UserServiceNotFoundException, UserServiceUpdateException;
  User changeRole(UUID id, UserRole newRole) throws UserServiceNotFoundException, UserServiceUpdateException;

}

package pl.zzpj.repository.ports.command.user;

import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.user.UserServiceUpdateException;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.util.UUID;

public interface UserDiscountCommandPort {
  User updateScore(UUID id, Double score) throws UserServiceNotFoundException, UserServiceUpdateException;
}

package pl.zzpj.rest.api;

import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.rest.dto.input.UserInputDTO;
import pl.zzpj.rest.dto.output.UserOutputDTO;
import pl.zzpj.rest.exception.UserCreationException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
  List<UserOutputDTO> getAllUsers();
  Optional<UserOutputDTO> getUserById(UUID id);
  Optional<UserOutputDTO> getUserByLogin(String login);
  Optional<UserOutputDTO> getUserByEmail(String email);
  UserOutputDTO createUser(UserInputDTO user) throws UserCreationException;
}

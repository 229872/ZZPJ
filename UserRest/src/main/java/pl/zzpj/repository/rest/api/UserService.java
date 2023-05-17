package pl.zzpj.repository.rest.api;

import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;

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

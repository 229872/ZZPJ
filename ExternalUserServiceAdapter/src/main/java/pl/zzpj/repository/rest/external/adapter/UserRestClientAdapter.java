package pl.zzpj.repository.rest.external.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.user.UserServiceCreateException;
import pl.zzpj.repository.ports.command.user.UserCommandServicePort;
import pl.zzpj.repository.rest.external.adapter.mapper.UserRestClientMapper;
import pl.zzpj.repository.rest.external.api.UserService;
import pl.zzpj.repository.rest.external.dto.PersonalDataInputDto;
import pl.zzpj.repository.rest.external.dto.UserInputDto;
import pl.zzpj.repository.rest.external.exception.UserCreationException;

@Component
@RequiredArgsConstructor
public class UserRestClientAdapter implements UserService {

  private final UserCommandServicePort userService;
  private final UserRestClientMapper userRestClientMapper;

  @Override
  public UserInputDto add(UserInputDto user) {
    try {
      userService.add(userRestClientMapper.mapToDomainModelUser(user));
      return user;
    } catch (UserServiceCreateException e) {
      throw new UserCreationException(e.getMessage(), e.getCause());
    }
  }
}

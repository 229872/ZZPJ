package pl.zzpj.repository.rest.external.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.external.dto.UserInputDto;

@Component
public class UserRestClientMapper {
  public User mapToDomainModel(UserInputDto userInputDto) {
    return User.builder(
            userInputDto.username(),
            userInputDto.password(),
            userInputDto.email(),
            null //fixme add fields to dto
    ).build();
  }
}

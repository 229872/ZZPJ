package pl.zzpj.repository.rest.adapter.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.dto.output.PersonOutputDTO;
import pl.zzpj.repository.rest.security.CryptUtils;

@Component
@AllArgsConstructor
public class UserMapper {
  private final PersonRestMapper personMapper;
  private final CryptUtils cryptUtils;

  public UserOutputDTO mapToUserOutputDTO(User user) {
    PersonOutputDTO person = personMapper.mapToPersonOutputDTO(user.getPerson());

    return new UserOutputDTO(
            user.getClientId(),
            user.getLogin(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getSocialInsuranceNumber(),
            user.getCreditCard(),
            user.getScore(),
            person
    );
  }

  public User mapToDomainModelUser(UserInputDTO user) {
    Person person = personMapper.mapToModelDomainPerson(user.getPerson());

    return User.builder(user.getLogin(), cryptUtils.hashPassword(user.getPassword()), user.getEmail(), person)
            .build();
  }

}

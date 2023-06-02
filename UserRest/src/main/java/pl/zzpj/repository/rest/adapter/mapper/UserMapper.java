package pl.zzpj.repository.rest.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.core.domain.model.userModel.UserUpdateData;
import pl.zzpj.repository.rest.dto.input.UserUpdateDTO;
import pl.zzpj.repository.rest.exception.UserCreationException;
import pl.zzpj.repository.utils.security.CryptUtils;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.dto.input.UserInputDTO;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;
import pl.zzpj.repository.rest.dto.output.PersonOutputDTO;


@Component
@RequiredArgsConstructor
public class UserMapper {
  private final PersonRestMapper personMapper;
  private final RestRoleMapper roleMapper;
  private final RestTimeZoneMapper timeZoneMapper;
  private final RestUserStateMapper userStateMapper;
  private final CryptUtils cryptUtils;

  public UserOutputDTO mapToUserOutputDTO(User user) {
    PersonOutputDTO person = personMapper.mapToPersonOutputDTO(user.getPerson());

    return new UserOutputDTO(
            user.getSumOfVersions(),
            user.getClientId(),
            user.getLogin(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getSocialInsuranceNumber(),
            user.getCreditCard(),
            user.getScore(),
            person,
            roleMapper.mapRoleToString(user.getUserRole()),
            userStateMapper.mapUserStateToString(user.getUserState()),
            timeZoneMapper.mapTimeZoneToString(user.getUserTimeZone()),
            user.getLocale()
    );
  }

  public User mapUserInputDtoToDomainModelUser(UserInputDTO user) throws UserCreationException {
    Person person = personMapper.mapToModelDomainPerson(user.person());



    User.UserBuilder userBuilder = User.userBuilderWithDefaultsForRestAdapter(
            user.login(),
            cryptUtils.hashPassword(user.password()),
            user.email(),
            person,
            roleMapper.mapToUserRole(user.role())
    );

    return userBuilder
            .locale(user.locale())
            .userTimeZone(timeZoneMapper.mapToUserTimeZone(user.timeZone()))
            .phoneNumber(user.phoneNumber())
            .socialInsuranceNumber(user.socialInsuranceNumber())
            .creditCard(user.creditCard())
            .build();
  }

  public UserUpdateData mapToDomainModelUpdateData(UserUpdateDTO user) {
    return UserUpdateData.builder()
            .country(user.country())
            .buildingNumber(user.buildingNumber())
            .mailBox(user.mailBox())
            .city(user.city())
            .lastName(user.lastName())
            .name(user.name())
            .secondaryAddress(user.secondaryAddress())
            .state(user.state())
            .streetName(user.streetName())
            .socialInsuranceNumber(user.socialInsuranceNumber())
            .postalCode(user.postalCode())
            .phoneNumber(user.phoneNumber())
            .creditCard(user.creditCard())
            .locale(user.locale())
            .build();
  }

}

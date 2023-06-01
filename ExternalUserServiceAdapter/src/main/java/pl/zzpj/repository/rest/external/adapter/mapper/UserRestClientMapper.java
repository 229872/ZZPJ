package pl.zzpj.repository.rest.external.adapter.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.utils.security.CryptUtils;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.external.dto.AddressInputDto;
import pl.zzpj.repository.rest.external.dto.PersonalDataInputDto;
import pl.zzpj.repository.rest.external.dto.UserInputDto;

@Component
@RequiredArgsConstructor
public class UserRestClientMapper {
  private final CryptUtils cryptUtils;

  public User mapToDomainModelUser(UserInputDto userInputDto) {
    PersonalDataInputDto user = userInputDto.user();
    Address address = mapToDomainModelAddress(userInputDto.address());
    Person person = mapToDomainModelPerson(user, address);

    User.UserBuilder userBuilder = User.builder(
            user.username(),
            cryptUtils.hashPassword(user.password()),
            user.email(), person);

    return userBuilder
            .creditCard(user.credit_card().cc_number())
            .phoneNumber(user.phone_number())
            .socialInsuranceNumber(user.social_insurance_number())
            .build();
  }

  private Address mapToDomainModelAddress(AddressInputDto addressInputDto) {
    //todo change _ to camelcase
    Address.AddressBuilder builder = Address.builder(
            addressInputDto.country(),
            addressInputDto.city(),
            addressInputDto.street_name(),
            addressInputDto.street_address(),
            addressInputDto.postcode()
    );

    return builder
            .fullAddress(addressInputDto.full_address())
            .secondaryAddress(addressInputDto.secondary_address())
            .buildingNumber(Integer.parseInt(addressInputDto.building_number()))
            .mailBox(addressInputDto.mail_box())
            .timeZone(addressInputDto.time_zone())
            .state(addressInputDto.state())
            .longitude(addressInputDto.longitude())
            .latitude(addressInputDto.latitude())
            .community(addressInputDto.community())
            .countryCode(addressInputDto.country_code())
            .streetSuffix(addressInputDto.street_suffix())
            .cityPrefix(addressInputDto.city_prefix())
            .citySuffix(addressInputDto.city_suffix())
            .stateAbbr(addressInputDto.state_abbr())
            .build();
  }

  private Person mapToDomainModelPerson(PersonalDataInputDto user, Address address) {

    return Person.builder(
            user.first_name(),
            user.last_name(),
            user.gender(),
            user.date_of_birth(),
            address
    ).build();
  }
}

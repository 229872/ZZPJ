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

    User.UserBuilder userBuilder = User.userBuilderWithDefaultsForRestClientAdapter(
            user.username(),
            cryptUtils.hashPassword(user.password()),
            user.email(),
            person
    );


    return userBuilder
            .creditCard(user.creditCard().ccNumber())
            .phoneNumber(user.phoneNumber())
            .socialInsuranceNumber(user.socialInsuranceNumber())
            .build();
  }

  private Address mapToDomainModelAddress(AddressInputDto addressInputDto) {
    Address.AddressBuilder builder = Address.builder(
            addressInputDto.country(),
            addressInputDto.city(),
            addressInputDto.streetName(),
            addressInputDto.streetAddress(),
            addressInputDto.postcode()
    );

    return builder
            .fullAddress(addressInputDto.fullAddress())
            .secondaryAddress(addressInputDto.secondaryAddress())
            .buildingNumber(parseBuildingNumber(addressInputDto.buildingNumber()))
            .mailBox(addressInputDto.mailBox())
            .state(addressInputDto.state())
            .longitude(addressInputDto.longitude())
            .latitude(addressInputDto.latitude())
            .community(addressInputDto.community())
            .countryCode(addressInputDto.countryCode())
            .streetSuffix(addressInputDto.streetSuffix())
            .cityPrefix(addressInputDto.cityPrefix())
            .citySuffix(addressInputDto.citySuffix())
            .stateAbbr(addressInputDto.stateAbbr())
            .build();
  }

  private Person mapToDomainModelPerson(PersonalDataInputDto user, Address address) {

    return Person.builder(
            user.firstName(),
            user.lastName(),
            user.gender(),
            user.dateOfBirth(),
            address
    ).build();
  }

  private Integer parseBuildingNumber(String number) {
    if (number == null) return null;
    return Integer.valueOf(number);
  }
}

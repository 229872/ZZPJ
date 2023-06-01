package pl.zzpj.repository.rest.external.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.external.dto.AddressInputDto;
import pl.zzpj.repository.rest.external.dto.PersonalDataInputDto;
import pl.zzpj.repository.rest.external.dto.UserInputDto;

@Component
public class UserRestClientMapper {
  public User mapToDomainModelUser(UserInputDto userInputDto) {
    PersonalDataInputDto user = userInputDto.user();

    return User.builder(
            user.username(),
            user.password(),
            user.email(),
            Person.builder(
                    user.first_name(),
                    user.last_name(),
                    user.gender(),
                    user.date_of_birth(),
                    mapToDomainModelAddress(userInputDto.address())
            ).build()
    ).build();
  }

  private Address mapToDomainModelAddress(AddressInputDto addressInputDto) {
    //todo add all fields and change _ to camelcase
    return Address.builder()
            .country(addressInputDto.country())
            .countryCode(addressInputDto.country_code())
            .city(addressInputDto.city())
            .streetAddress(addressInputDto.street_address())
            .streetName(addressInputDto.street_name())
            .zipCode(addressInputDto.zip_code())
            .build();
  }
}

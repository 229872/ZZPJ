package pl.zzpj.repository.rest.adapter.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.rest.dto.input.PersonInputDTO;
import pl.zzpj.repository.rest.dto.output.PersonOutputDTO;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class PersonRestMapper {
  private final AddressRestMapper addressMapper;
  public PersonOutputDTO mapToPersonOutputDTO(Person person) {
    var address = addressMapper.mapToAddressOutputDTO(person.getAddress());

    return PersonOutputDTO.builder()
            .firstName(person.getName())
            .lastName(person.getLastName())
            .address(address)
            .dateOfBirth(person.getDateOfBirth())
            .gender(person.getGender())
            .build();
  }

  public Person mapToModelDomainPerson(PersonInputDTO person) {
    Address address = addressMapper.mapToDomainModelAddress(person.getAddress());
    LocalDate dateOfBirth = LocalDate.parse(person.getDateOfBirth());

    return Person.builder(person.getName(), person.getLastName(), person.getGender(),
            dateOfBirth, address).build();
  }
}

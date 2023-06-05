package pl.zzpj.repository.rest.adapter.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.core.domain.model.userModel.Person;
import pl.zzpj.repository.rest.dto.input.PersonInputDTO;
import pl.zzpj.repository.rest.dto.output.PersonOutputDTO;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PersonRestMapper {
  private final AddressRestMapper addressMapper;
  public PersonOutputDTO mapToPersonOutputDTO(Person person) {
    var address = addressMapper.mapToAddressOutputDTO(person.getAddress());

    return new PersonOutputDTO(
            person.getName(),
            person.getLastName(),
            person.getGender(),
            person.getDateOfBirth(),
            person.getAge(),
            address
            );
  }

  public Person mapToModelDomainPerson(PersonInputDTO person) {
    Address address = addressMapper.mapToDomainModelAddress(person.address());
    LocalDate dateOfBirth = LocalDate.parse(person.dateOfBirth());

    return Person.builder(person.name(), person.lastName(), person.gender(),
            dateOfBirth, address).build();
  }
}

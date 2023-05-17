package pl.zzpj.repository.adapter.user.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.data.user.Address;
import pl.zzpj.repository.data.user.Person;

@Component
@AllArgsConstructor
public class PersonMapper {
    private final AddressMapper addressMapper;

    public Person mapToDatabasePerson(pl.zzpj.repository.core.domain.model.userModel.Person person) {
        Address address = addressMapper.mapToDatabaseAddress(person.getAddress());

        return Person.builder(person.getName(), person.getLastName(), person.getGender(),
                        person.getDateOfBirth(), address)
                .build();
    }

    public pl.zzpj.repository.core.domain.model.userModel.Person mapToDomainModelPerson(Person person) {
        var address = addressMapper.mapToDomainModelAddress(person.getAddress());

        return pl.zzpj.repository.core.domain.model.userModel.Person.builder(person.getFirstName(),
                        person.getLastName(), person.getGender(), person.getDateOfBirth(), address)
                .build();
    }

}

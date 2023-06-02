package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Log
public class Person {
  private UUID personId;
  private Long version;
  private String name;
  private String lastName;
  private String gender;
  private LocalDate dateOfBirth;
  private Address address;

  public int getAge() {
    Period period = Period.between(dateOfBirth, LocalDate.now());
    return period.getYears();
  }

  public void update(UserUpdateData person) {
    if (person == null) return;
    this.name = person.name() != null ? person.name() : name;
    this.lastName = person.lastName() != null ? person.lastName() : lastName;
    this.address.update(person);
  }

  public static PersonBuilder builder(String name, String lastName, String gender,
                                      LocalDate dateOfBirth, Address address) {
    return new PersonBuilder().name(name).lastName(lastName).gender(gender)
            .dateOfBirth(dateOfBirth).address(address);
  }
}

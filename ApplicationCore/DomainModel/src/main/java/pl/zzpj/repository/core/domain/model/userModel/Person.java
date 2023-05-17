package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Person {
  private String name;
  private String lastName;
  private String gender;
  private LocalDate dateOfBirth;
  private Address address;

  public static PersonBuilder builder(String name, String lastName, String gender,
                                      LocalDate dateOfBirth, Address address) {
    return new PersonBuilder().name(name).lastName(lastName).gender(gender)
            .dateOfBirth(dateOfBirth).address(address);
  }
}

package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@Builder
@Log
public class Person {
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

  public static PersonBuilder builder(String name, String lastName, String gender,
                                      LocalDate dateOfBirth, Address address) {
    return new PersonBuilder().name(name).lastName(lastName).gender(gender)
            .dateOfBirth(dateOfBirth).address(address);
  }
}

package pl.zzpj.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
  private String name;
  private String lastName;
  private String gender;
  private LocalDate dateOfBirth;
  private Address address;
}

package pl.zzpj.rest.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonOutputDTO {
  private String firstName;
  private String lastName;
  private String gender;
  private LocalDate dateOfBirth;
  private AddressOutputDTO address;
}

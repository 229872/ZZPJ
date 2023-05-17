package pl.zzpj.rest.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zzpj.core.domain.model.userModel.Address;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonInputDTO {
  @NotBlank
  private String name;
  @NotBlank
  private String lastName;
  @NotBlank
  private String gender;
  @NotBlank
  private String dateOfBirth;
  @NotNull
  @Valid
  private AddressInputDTO address;
}

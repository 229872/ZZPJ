package pl.zzpj.rest.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressInputDTO {
  @NotBlank
  private String country;
  @NotBlank
  private String countryCode;
  @NotBlank
  private String city;
  @NotBlank
  private String streetName;
  @NotBlank
  private String streetAddress;
  @NotBlank
  private String zipCode;
}

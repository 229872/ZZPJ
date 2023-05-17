package pl.zzpj.rest.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressOutputDTO {
  private String country;
  private String countryCode;
  private String city;
  private String streetName;
  private String streetAddress;
}

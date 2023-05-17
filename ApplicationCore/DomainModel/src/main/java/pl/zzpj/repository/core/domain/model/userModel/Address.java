package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Address {
  private String country;
  private String countryCode;
  private String city;
  private String streetName;
  private String streetAddress;
  private String zipCode;

}

package pl.zzpj.core.domain.model.clientModel;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
  private String city;
  private String streetName;
  private String streetAddress;
  private String zipCode;
  private String country;
}

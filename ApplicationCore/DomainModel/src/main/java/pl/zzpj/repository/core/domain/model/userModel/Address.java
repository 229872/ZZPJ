package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Address {
  private UUID addressId;
  private Long version;
  private String country;
  private String city;
  private String streetName;
  private String streetNumber;
  private String postalCode;
  private String fullAddress;

  private String secondaryAddress;
  private Integer buildingNumber;
  private String mailBox;
  private String state;

  private Double longitude;
  private Double latitude;
  private String community;
  private String countryCode;
  private String streetSuffix;
  private String cityPrefix;
  private String citySuffix;
  private String stateAbbr;

  public static AddressBuilder builder(String country, String city, String streetName, String streetNumber,
                                String postalCode) {
    return new AddressBuilder()
            .country(country).city(city).streetName(streetName).streetNumber(streetNumber)
            .postalCode(postalCode);
  }

  public String getFullAddress() {
    return fullAddress != null ? fullAddress : buildFullAddress();
  }

  private String buildFullAddress() {
    StringBuilder stringBuilder = new StringBuilder();
    if (secondaryAddress != null) {
      stringBuilder.append(secondaryAddress).append(" ");
    }
    stringBuilder.append(streetNumber).append(" ");
    stringBuilder.append(streetName).append(", ");
    stringBuilder.append(city).append(", ");

    if (stateAbbr != null) {
      stringBuilder.append(stateAbbr).append(" ");
    }

    stringBuilder.append(postalCode);

    return stringBuilder.toString();
  }

}

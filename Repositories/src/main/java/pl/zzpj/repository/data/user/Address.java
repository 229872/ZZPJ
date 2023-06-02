package pl.zzpj.repository.data.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.zzpj.repository.data.AbstractEntity;

import java.util.Optional;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SecondaryTable(
        name = "address_additional_data",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "address_id")
)
public class Address extends AbstractEntity {
  @Column(nullable = false)
  private String country;
  @Column(nullable = false)
  private String city;
  @Column(name = "street_name", nullable = false)
  private String streetName;
  @Column(name = "street_number", nullable = false)
  private String streetNumber;
  @Column(name = "postal_code", nullable = false)
  private String postalCode;
  @Column(name = "full_address", table = "address_additional_data", nullable = false)
  private String fullAddress;

  @Column(name = "secondary_address")
  private String secondaryAddress;
  @Column(name = "building_number")
  private Integer buildingNumber;
  @Column(name = "mail_box")
  private String mailBox;
  @Column(name = "time_zone", table = "address_additional_data")
  private String timeZone;
  @Column(table = "address_additional_data")
  private String state;


  @Embedded
  private Coordinates coordinates;
  @Column(table = "address_additional_data")
  private String community;
  @Column(name = "country_code")
  private String countryCode;
  @Column(name = "street_suffix", table = "address_additional_data")
  private String streetSuffix;
  @Column(name = "city_prefix", table = "address_additional_data")
  private String cityPrefix;
  @Column(name = "city_suffix", table = "address_additional_data")
  private String citySuffix;
  @Column(name = "state_abbr", table = "address_additional_data")
  private String stateAbbr;


  public static AddressBuilder<?,?> builder(String country, String city, String streetName,
                                            String streetNumber, String postalCode, String fullAddress) {

    return new AddressBuilderImpl().country(country).city(city).streetName(streetName)
            .streetNumber(streetNumber).postalCode(postalCode).fullAddress(fullAddress);
  }

  public Optional<Coordinates> getCoordinates() {
    return Optional.ofNullable(coordinates);
  }
}
